package com.chieveke.androidframework.feature.view;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.chieveke.androidframework.R;
import com.chieveke.androidframework.feature.di.DiHelper;
import com.chieveke.androidframework.feature.modle.bean.UserEntity;
import com.chieveke.androidframework.feature.presenter.UserLoginPersenter;
import com.chieveke.androidframework.feature.presenter.contract.IUserLoginContract;
import com.chieveke.arms.base.XDaggerActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/26 15:46
 * @version: V1.0
 */
public class LoginActivity extends XDaggerActivity<UserLoginPersenter>  implements IUserLoginContract.IView{


    @BindView(R.id.tv_id)
    TextView tvId;
    @BindView(R.id.edt_id)
    EditText edtId;
    @BindView(R.id.tv_username)
    TextView tvUsername;
    @BindView(R.id.edt_username)
    EditText edtUsername;
    @BindView(R.id.tv_pwd)
    TextView tvPwd;
    @BindView(R.id.edt_pwd)
    EditText edtPwd;
    @BindView(R.id.saveButton)
    Button saveButton;
    @BindView(R.id.loadButton)
    Button loadButton;

    @Override
    public void initInject(Bundle savedInstanceState) {
        DiHelper.getActivityComponent(getActivityModule()).inject(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    public void initEventAndData(Bundle savedInstanceState) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.saveButton,R.id.loadButton})
    public void onclick(View v){
        switch (v.getId()) {
            case R.id.saveButton:
                mPresenter.onSave(getId(),getName(),getPassword());
                break;
            case R.id.loadButton:
                mPresenter.loadUser(getId());
                break;
            default:
                break;
        }
    }

    @Override
    public String getId() {
        return edtId.getText().toString();
    }

    @Override
    public String getName() {
        return edtUsername.getText().toString();
    }

    @Override
    public String getPassword() {
        return edtPwd.getText().toString();
    }

    @Override
    public void onSave() {
        edtUsername.setText("");
        edtPwd.setText("");
        Snackbar.make(saveButton,"保存",Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void loadUser(UserEntity user) {
        edtUsername.setText(user.getName());
        edtPwd.setText(user.getAge());
        Snackbar.make(saveButton,"加载",Snackbar.LENGTH_SHORT).show();
    }
}
