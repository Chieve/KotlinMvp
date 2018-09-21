package com.chieveke.androidframework.feature.mvp

import com.chieveke.androidframework.feature.data.User

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/19 15:08
 * @version: V1.0
 */
interface IUserModel {
    fun setId(id: Int)
    fun setUserName(userName: String)
    fun setAge(age: Int)
    fun save()
    fun load(id: Int): User
}