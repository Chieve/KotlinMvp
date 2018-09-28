package com.chieveke.arms.di.component;


import com.chieveke.arms.base.BaseApplication;
import com.chieveke.arms.data.DBHelper;
import com.chieveke.arms.data.HttpHelper;
import com.chieveke.arms.data.cache.ICache;
import com.chieveke.arms.di.module.AppModule;
import com.chieveke.arms.di.module.DataModule;

import java.util.Random;

import javax.inject.Singleton;

import dagger.Component;
import io.rx_cache2.internal.RxCache;


/**
 * @description: App的注解使用
 * @author: chieveke
 * @date: 2018/9/28 14:58
 * @version: V1.0
 */
@Singleton
@Component(modules = {DataModule.class,AppModule.class})
public interface AppComponent {

    BaseApplication getContext();  // 提供App的Context

    HttpHelper httpHelper();  //提供http的帮助类

    ICache memoryCache();

    DBHelper dtabaseHelper();  //提供db的帮助类
    /**
     * {@link Random} instance from {@link AppModule}
     * which now can be injected to children
     * that depend on {@link AppComponent}.
     */
    Random random();

    RxCache getRxCache();
}
