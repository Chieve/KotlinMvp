package com.chieveke.androidframework.feature.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.text.Selection;
import android.text.Spannable;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.chieveke.androidframework.R;
import com.chieveke.androidframework.feature.di.DiHelper;
import com.chieveke.androidframework.feature.modle.StaticData;
import com.chieveke.androidframework.feature.modle.bean.LoginUserEntity;
import com.chieveke.androidframework.feature.presenter.LoginPersenter;
import com.chieveke.androidframework.feature.presenter.contract.ILoginContract;
import com.chieveke.arms.base.XDaggerActivity;
import com.chieveke.arms.utils.ToastUtils;
import com.chieveke.arms.utils.Utils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends XDaggerActivity<LoginPersenter> implements ILoginContract.IView {


    @BindView(R.id.iv_icon_logo)
    ImageView ivIconLogo;
    @BindView(R.id.et_username)
    AppCompatEditText etUsername;
    @BindView(R.id.ll_user)
    LinearLayout llUser;
    @BindView(R.id.et_password)
    AppCompatEditText etPassword;
    @BindView(R.id.cb_pwd_visible)
    CheckBox cbPwdVisible;
    @BindView(R.id.ll_passwprd)
    LinearLayout llPasswprd;
    @BindView(R.id.cb_remember_account)
    CheckBox cbRememberAccount;
    @BindView(R.id.cb_remember_password)
    CheckBox cbRememberPassword;
    @BindView(R.id.ll_remeber)
    LinearLayout llRemeber;
    @BindView(R.id.btn_login)
    Button btnLogin;
    @BindView(R.id.tv_forget_pwd)
    TextView tvForgetPwd;
    @BindView(R.id.imageView)
    ImageView imageView;

    private String mUserName = "";
    private String mPassword = "";
    private boolean isHidden = true;//密码是否隐藏


    @Override
    public void initInject(Bundle savedInstanceState) {
        DiHelper.getActivityComponent(getActivityModule()).inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login2;
    }

    @Override
    public void initEventAndData(Bundle savedInstanceState) {
        ButterKnife.bind(this);
        mUserName = Utils.getSpUtils().getString(StaticData.USERACCOUNT);
        mPassword = Utils.getSpUtils().getString(StaticData.USERPASSWORD);
        if (mUserName != null) {
            etUsername.setText(mUserName);
        }
        if (mPassword != null) {
            etPassword.setText(mPassword);
        }
        if (getIntent().getBooleanExtra(StaticData.ISSAVEUSERACCOUNT, false)) {
            cbRememberAccount.setChecked(true);
        } else {
            cbRememberAccount.setChecked(Utils.getSpUtils().getBoolean(StaticData.ISSAVEUSERACCOUNT, true));
        }
        cbRememberPassword.setChecked(Utils.getSpUtils().getBoolean(StaticData.ISSAVEUSERPASSWORD, false));
    }

    @OnClick({R.id.btn_login, R.id.cb_pwd_visible, R.id.cb_remember_account, R.id.cb_remember_password, R.id.tv_forget_pwd})
    public void onClick(View v) {

        int id = v.getId();
        switch (id) {
            case R.id.btn_login:
                if (prepareForLogin()) {
                    return;
                }
                mUserName = etUsername.getText().toString().trim();
                mPassword = etPassword.getText().toString().trim();
                if (cbRememberAccount.isChecked()) {
                    Utils.getSpUtils().put(StaticData.USERACCOUNT, mUserName);
                    Utils.getSpUtils().put(StaticData.ISSAVEUSERACCOUNT, true);
                } else {
                    Utils.getSpUtils().remove(StaticData.USERACCOUNT);
                    Utils.getSpUtils().put(StaticData.ISSAVEUSERACCOUNT, false);
                }
                if (cbRememberPassword.isChecked()) {
                    Utils.getSpUtils().put(StaticData.USERPASSWORD, mPassword);
                    Utils.getSpUtils().put(StaticData.ISSAVEUSERPASSWORD, true);
                } else {
                    Utils.getSpUtils().put(StaticData.ISSAVEUSERPASSWORD, false);
                    Utils.getSpUtils().remove(StaticData.USERPASSWORD);
                }
                mPresenter.login(mUserName, mPassword);
                break;
            case R.id.cb_pwd_visible:
                if (isHidden) {
                    //设置EditText文本为可见的
                    etPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    //设置EditText文本为隐藏的
                    etPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                isHidden = !isHidden;
                etPassword.postInvalidate();
                //切换后将EditText光标置于末尾
                CharSequence charSequence = etPassword.getText();
                if (charSequence instanceof Spannable) {
                    Spannable spanText = (Spannable) charSequence;
                    Selection.setSelection(spanText, charSequence.length());
                }
                break;
            case R.id.cb_remember_account:
                if (cbRememberAccount.isChecked()) {
                    mUserName = etUsername.getText().toString().trim();
                    Utils.getSpUtils().put(StaticData.USERACCOUNT, mUserName);
                    Utils.getSpUtils().put(StaticData.ISSAVEUSERACCOUNT, true);
                } else {
                    Utils.getSpUtils().remove(StaticData.USERACCOUNT);
                    Utils.getSpUtils().put(StaticData.ISSAVEUSERACCOUNT, false);
                }
                break;
            case R.id.cb_remember_password:
                if (cbRememberPassword.isChecked()) {
                    mPassword = etUsername.getText().toString().trim();
                    Utils.getSpUtils().put(StaticData.USERPASSWORD, mPassword);
                    Utils.getSpUtils().put(StaticData.ISSAVEUSERPASSWORD, true);
                } else {
                    Utils.getSpUtils().put(StaticData.ISSAVEUSERPASSWORD, false);
                    Utils.getSpUtils().remove(StaticData.USERPASSWORD);
                }
                break;
            case R.id.tv_forget_pwd:
                //忘记密码
                ToastUtils.showShortToast("请联系分公司管理员重置密码");
                break;
            default:
                break;
        }
    }

    /**
     * 检查用户和密码格式
     *
     * @return
     */
    private boolean prepareForLogin() {

        if (etUsername.length() == 0) {
            etUsername.setError("请输入账号");
            etUsername.requestFocus();
            return true;
        }

        if (etPassword.length() == 0) {
            etPassword.setError("请输入密码");
            etPassword.requestFocus();
            return true;
        }
        return false;
    }

    @Override
    public void loginSuccess(LoginUserEntity response) {

//        pref.saveUserid(info.getData().getUserid());
        //判断极光推送服务是否启动
//        if (JPushInterface.isPushStopped(getApplicationContext())) {
//            JPushInterface.resumePush(getApplicationContext());
//        }
//        //设置极光推送的别名和标签
//        JPushCustomUtil.getInstance(this).setTagAndAlias();
//        DbUtils.insertDb(this, pref.getUserid());
        Intent intent = new Intent();
        intent.setClass(this, MainActivity.class);
//                123456默认密码修改
        if ("123456".contentEquals(mPassword)) {
            intent.putExtra(StaticData.PASSWORD, 1);
        } else {
            intent.putExtra(StaticData.PASSWORD, response.getNeed_to_resetpassword());
        }
//                密码超过半年密码
        startActivity(intent);
        finish();
    }

    @Override
    public void loginFaile(String message) {
        ToastUtils.showShortToast(message);
//        清空密码
        Utils.getSpUtils().remove(StaticData.USERPASSWORD);
        etPassword.setText("");
    }
}

