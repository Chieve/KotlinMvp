package com.chieveke.androidframework

import android.app.Application
import com.chieveke.androidframework.base.injection.component.DaggerAppComponent
import timber.log.Timber
import timber.log.Timber.DebugTree
import javax.inject.Inject


/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/19 17:37
 * @version: V1.0
 */
class App : Application() {

    @Inject
    lateinit var helloWorld:String

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.create().inject(this)
        //  timber Log管理
        if (BuildConfig.DEBUG) {
            Timber.plant(object : DebugTree() {
                override fun isLoggable(tag: String?, priority: Int): Boolean {
                    return BuildConfig.DEBUG
                }
            })
        }
    }
}