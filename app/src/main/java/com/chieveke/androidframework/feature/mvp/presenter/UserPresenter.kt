package com.chieveke.androidframework.feature.mvp.presenter

import android.util.Log
import com.chieveke.androidframework.feature.mvp.IUserPresenter
import com.chieveke.androidframework.feature.mvp.IUserView
import com.chieveke.androidframework.feature.mvp.model.UserModel

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/19 15:23
 * @version: V1.0
 */

class UserPresenter: IUserPresenter {

    private val mUserModel: UserModel = UserModel()
    private var view: IUserView? = null

    override fun saveUser(id: Int, userName: String, age: Int) {
        Log.d("test_log", "saveUser : $id,$userName,$age")
        mUserModel.setId(id)
        mUserModel.setUserName(userName)
        mUserModel.setAge(age)
        mUserModel.save()
        view?.onSaveSuccess()
    }

    override fun loadUser(id: Int) {
        Log.d("test_log", "loadUser : $id")
        val user = mUserModel.load(id)
        view?.setUserName(user.userName)
        view?.setAge(user.age)
    }

    fun attachView(iUserView:IUserView) {
        this.view=iUserView
    }
}