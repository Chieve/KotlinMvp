package com.chieveke.androidframework.feature.presenter;

import com.chieveke.androidframework.base.InfoResponseEntityBase;
import com.chieveke.androidframework.base.SampleSubscriber;
import com.chieveke.androidframework.base.SampleSubscriberListener;
import com.chieveke.androidframework.feature.modle.LoginDataService;
import com.chieveke.androidframework.feature.modle.bean.LoginUserEntity;
import com.chieveke.androidframework.feature.presenter.contract.ILoginContract;
import com.chieveke.androidframework.feature.utils.MD5Util;
import com.chieveke.arms.base.XPresenter;
import com.chieveke.arms.data.net.NetError;

import javax.inject.Inject;

/**
 * @description: 登录页面persenter
 * @author: chieveke
 * @date: 2018/10/23 17:08
 * @version: V1.0
 */
public class LoginPersenter extends XPresenter<ILoginContract.IView> implements ILoginContract.IPresenter {

    private LoginDataService mLoginDataService;

    @Inject
    public LoginPersenter(LoginDataService loginDataService) {
        mLoginDataService = loginDataService;
    }

    @Override
    public void saveAcount() {

    }

    @Override
    public void savePassword() {

    }

    @Override
    public void forgetPassword() {

    }

    @Override
    public void login(String mUserName, String mPassword) {
        //      MD5加密后大写转小写
        mPassword = MD5Util.md5(mPassword).toLowerCase();
        mLoginDataService.login(mUserName,mPassword)
                .compose(getV().<InfoResponseEntityBase<LoginUserEntity>>bindLifecycle())
                .subscribe(new SampleSubscriber<InfoResponseEntityBase<LoginUserEntity>>(new SampleSubscriberListener<LoginUserEntity>() {
                    @Override
                    public void onSuccess(LoginUserEntity response) {
                        getV().loginSuccess(response);
                    }

                    @Override
                    public void onFail(NetError errorMsg) {
                        super.onFail(errorMsg);
                        getV().loginFaile(errorMsg.getMessage());
                    }
                }));
    }
}
