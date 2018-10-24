package com.chieveke.androidframework.feature.modle;


import com.chieveke.androidframework.base.InfoResponseEntityBase;
import com.chieveke.androidframework.feature.modle.bean.LoginUserEntity;
import com.chieveke.androidframework.feature.presenter.contract.ILoginContract;
import com.chieveke.arms.data.HttpHelper;
import com.chieveke.arms.utils.rx.RxUtil;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * @author
 * @createDate
 * @description
 */

public class LoginDataService implements ILoginContract.IModel {

    private HttpHelper mHttpHelper;

    @Inject
    public LoginDataService(HttpHelper httpHelper) {
        this.mHttpHelper = httpHelper;
    }


    @Override
    public Flowable<InfoResponseEntityBase<LoginUserEntity>> login(String mUserName, String mPassword) {
        return mHttpHelper.createApi(Api.class).login(mUserName,mPassword).compose(RxUtil.<InfoResponseEntityBase<LoginUserEntity>> rxSchedulerHelper());
    }
}