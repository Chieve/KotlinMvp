package com.chieveke.androidframework.feature.mvp

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/19 15:21
 * @version: V1.0
 */
interface IUserPresenter {
    fun saveUser(id: Int, userName: String, age: Int)
    fun loadUser(id: Int)
}