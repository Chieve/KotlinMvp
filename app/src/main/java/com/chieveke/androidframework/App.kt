package com.chieveke.androidframework

import com.chieveke.arms.base.BaseApplication
import com.chieveke.arms.utils.Utils
import timber.log.Timber


/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/19 17:37
 * @version: V1.0
 */
class App : BaseApplication() {

    override fun onCreate() {
        super.onCreate()
        //  timber Log管理
        if (BuildConfig.DEBUG) {
            Timber.plant(object : Timber.DebugTree() {
                override fun isLoggable(tag: String?, priority: Int): Boolean {
                    return BuildConfig.DEBUG
                }
            })
        }
//        spUtils
        Utils.init(this)
    }
}