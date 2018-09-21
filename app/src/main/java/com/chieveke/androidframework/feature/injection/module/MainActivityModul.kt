package com.chieveke.androidframework.base.injection.module

import com.chieveke.androidframework.feature.mvp.presenter.UserPresenter
import dagger.Module
import dagger.Provides

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/20 19:47
 * @version: V1.0
 */
@Module
class MainActivityModul {
    @Provides
    fun providePresenter(): UserPresenter {
        return UserPresenter()
    }
}