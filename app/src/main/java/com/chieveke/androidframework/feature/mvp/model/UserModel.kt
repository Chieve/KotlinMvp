package com.chieveke.androidframework.feature.mvp.model

import android.util.SparseArray
import com.chieveke.androidframework.feature.data.User
import com.chieveke.androidframework.feature.mvp.IUserModel

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/19 15:12
 * @version: V1.0
 */

class UserModel : IUserModel {
    private var mId: Int = 0
    private var mUserName:String =""
    private var mAge:Int = 0
    private val mUserArray = SparseArray<User>()

    override fun setId(id: Int) {
        mId=id
    }

    override fun setUserName(userName: String) {
        mUserName=userName
    }

    override fun setAge(age: Int) {
        mAge = age
    }

    override fun save() {
        mUserArray.append(mId,User(mUserName,mAge))
    }

    override fun load(id: Int): User {
        mId = id
        return mUserArray.get(mId,User("not found",0))
    }

}