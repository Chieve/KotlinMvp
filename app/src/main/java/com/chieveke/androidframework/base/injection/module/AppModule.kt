package com.chieveke.androidframework.base.injection.module

import dagger.Module
import dagger.Provides

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/20 19:47
 * @version: V1.0
 */
@Module
class AppModule {
    @Provides
    fun provideHelloWorld(): String {
        return "Hello World"
    }
}