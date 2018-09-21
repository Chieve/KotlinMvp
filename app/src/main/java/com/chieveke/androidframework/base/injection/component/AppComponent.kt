package com.chieveke.androidframework.base.injection.component

import com.chieveke.androidframework.App
import com.chieveke.androidframework.base.injection.module.AppModule
import dagger.Component


/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/20 19:48
 * @version: V1.0
 */
@Component(modules = arrayOf(AppModule::class))
interface AppComponent {
    fun inject(app: App)
}