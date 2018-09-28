package com.chieveke.arms.di.module;


import com.chieveke.arms.base.BaseApplication;
import com.chieveke.arms.data.DBHelper;
import com.chieveke.arms.data.HttpHelper;
import com.chieveke.arms.data.IDataHelper;
import com.chieveke.arms.data.cache.ICache;
import com.chieveke.arms.data.cache.MemoryCache;
import com.chieveke.arms.utils.file.FileUtil;

import java.io.File;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.rx_cache2.internal.RxCache;
import io.victoralbertos.jolyglot.GsonSpeaker;


/**
 * @description: 数据工具提供者
 * @author: chieveke
 * @date: 2018/9/28 14:59
 * @version: V1.0
 */
@Module
public class DataModule {

    IDataHelper.NetConfig netConfig;


    public DataModule(IDataHelper.NetConfig netConfig) {
        this.netConfig = netConfig;
    }

    @Provides
    @Singleton
    HttpHelper provideHttpHelper(BaseApplication application, ICache iCache) {
        HttpHelper httpHelper = new HttpHelper(application,iCache);
        if (netConfig == null)
            netConfig = new IDataHelper.NetConfig();
        httpHelper.initConfig(netConfig);
        return httpHelper;
    }
    @Provides
    @Singleton
    DBHelper provideDatabaseHelper(BaseApplication application, ICache iCache) {
        return new DBHelper(application,iCache);
    }



    @Singleton
    @Provides
    ICache provideLruCache() {
        return MemoryCache.getInstance();
    }


    /**
     * 提供 {@link RxCache}
     *
     * @param cacheDirectory RxCache缓存路径
     * @return
     */
    @Singleton
    @Provides
    RxCache provideRxCache(@Named("RxCacheDirectory") File cacheDirectory) {
        RxCache.Builder builder = new RxCache.Builder();
        return builder
                .persistence(cacheDirectory, new GsonSpeaker());
    }

    /**
     * 需要单独给 {@link RxCache} 提供缓存路径
     *
     * @return
     */
    @Singleton
    @Provides
    @Named("RxCacheDirectory")
    File provideRxCacheDirectory(BaseApplication application) {
        File cacheDirectory = new File(FileUtil.getCacheDirectory(application), "RxCache");
        return FileUtil.makeDirs(cacheDirectory);
    }

}
