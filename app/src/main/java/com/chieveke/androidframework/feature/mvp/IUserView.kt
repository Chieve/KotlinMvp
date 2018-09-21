package com.chieveke.androidframework.feature.mvp

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/19 15:05
 * @version: V1.0
 */
interface IUserView {
    fun getID(): Int
    fun getUserName(): String
    fun getAge(): Int
    fun setUserName(userName: String)
    fun setAge(age: Int)
    fun onSaveSuccess()
}