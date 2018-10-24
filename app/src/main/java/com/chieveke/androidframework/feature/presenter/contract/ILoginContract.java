package com.chieveke.androidframework.feature.presenter.contract;

import com.chieveke.androidframework.base.InfoResponseEntityBase;
import com.chieveke.androidframework.feature.modle.bean.LoginUserEntity;
import com.chieveke.arms.framework.IBaseModel;
import com.chieveke.arms.framework.IBasePresenter;
import com.chieveke.arms.framework.IBaseView;

import io.reactivex.Flowable;

/**
 * @description:
 * @author: chieveke
 * @date: 2018/10/23 17:01
 * @version: V1.0
 */
public interface ILoginContract {
    interface IView<T> extends IBaseView {
        void loginSuccess(LoginUserEntity response);
        void loginFaile(String message);
    }

    interface IPresenter extends IBasePresenter<ILoginContract.IView> {
        void saveAcount();
        void savePassword();
        void forgetPassword();
        void login(String mUserName, String mPassword);
    }

    interface IModel extends IBaseModel {
        Flowable<InfoResponseEntityBase<LoginUserEntity>> login(String mUserName, String mPassword);
    }
}
