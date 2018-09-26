package com.chieveke.androidframework.feature.presenter.contract;

import com.chieveke.androidframework.feature.modle.bean.UserEntity;
import com.chieveke.arms.framework.IBaseModel;
import com.chieveke.arms.framework.IBasePresenter;
import com.chieveke.arms.framework.IBaseView;

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/26 16:27
 * @version: V1.0
 */
public interface IUserLoginContract {
    interface IView<T> extends IBaseView {
        String getId();
        String getName();
        String getPassword();
        void onSave();
        void loadUser(UserEntity user);
    }

    interface IPresenter extends IBasePresenter<IUserLoginContract.IView> {
        void onSave(String id, String name, String password);
        void loadUser(String id);
    }

    interface IModel extends IBaseModel {
        void getUser();
    }
}
