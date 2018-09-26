package com.chieveke.androidframework.feature.presenter;

import android.app.Activity;
import android.util.Log;

import com.chieveke.androidframework.feature.dao.AppDatabase;
import com.chieveke.androidframework.feature.modle.UserLoginDataService;
import com.chieveke.androidframework.feature.modle.bean.UserEntity;
import com.chieveke.androidframework.feature.presenter.contract.IUserLoginContract;
import com.chieveke.arms.base.XPresenter;
import com.chieveke.arms.data.DBHelper;

import javax.inject.Inject;

import static android.support.constraint.Constraints.TAG;

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/26 16:44
 * @version: V1.0
 */
public class UserLoginPersenter extends XPresenter<IUserLoginContract.IView> implements IUserLoginContract.IPresenter {


    private UserLoginDataService mUserLoginDataService;
    private AppDatabase cacheApi;


    @Inject
    public UserLoginPersenter(UserLoginDataService mUserLoginDataService, DBHelper dbHelper) {
        mUserLoginDataService = mUserLoginDataService;
        cacheApi = dbHelper.getApi(AppDatabase
                .class, "UserEntity");

    }

    //    @Inject
//    public UserLoginPersenter(UserLoginDataService mUserLoginDataService) {
//        mUserLoginDataService = mUserLoginDataService;
//    }
    @Override
    public void onSave(final String id, final String name, final String password) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //返回的是插入元素的primary key index
                Long aLong = cacheApi.UserDao().insertUser(new UserEntity(id, name, password));;
                if (aLong > 0) {
                    String msg = "insert one success, index is " + aLong.toString();
                    Log.i(TAG, msg);
                } else {
                    String msg = "insert one fail ";
                    Log.i(TAG, msg);
                }
                ((Activity)getV().getAContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getV().onSave();
                    }
                });
            }
        }).start();
    }

    @Override
    public void loadUser(final String id) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //返回的是插入元素的primary key index
                final UserEntity user = cacheApi.UserDao().findById(id);;
                ((Activity)getV().getAContext()).runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        getV().loadUser(user);
                    }
                });
            }
        }).start();

    }
}
