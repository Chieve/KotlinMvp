package com.chieveke.androidframework.feature.modle;


import com.chieveke.androidframework.feature.presenter.contract.IUserLoginContract;
import com.chieveke.arms.data.HttpHelper;

import javax.inject.Inject;

/**
 * @author
 * @createDate
 * @description
 */

public class UserLoginDataService implements IUserLoginContract.IModel {

    private HttpHelper mHttpHelper;

    @Inject
    public UserLoginDataService(HttpHelper httpHelper) {
        this.mHttpHelper = httpHelper;
    }

    @Override
    public void getUser() {

    }
}