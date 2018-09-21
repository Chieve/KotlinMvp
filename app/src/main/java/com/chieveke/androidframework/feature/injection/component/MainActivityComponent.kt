package com.chieveke.androidframework.base.injection.component

import com.chieveke.androidframework.base.injection.module.MainActivityModul
import com.chieveke.androidframework.feature.MainActivity
import dagger.Component


/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/20 19:48
 * @version: V1.0
 */
@Component(modules = arrayOf(MainActivityModul::class))
interface MainActivityComponent {
    fun inject(mainActivity: MainActivity)
}