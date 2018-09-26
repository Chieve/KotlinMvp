package com.chieveke.androidframework.feature.modle;


import com.chieveke.androidframework.base.SampleApiResponse;
import com.chieveke.androidframework.feature.modle.bean.GankItemBean;

import java.util.List;
import java.util.concurrent.TimeUnit;

import io.reactivex.Flowable;
import io.rx_cache2.LifeCache;

/**
 * @creator：denghc(desoce)
 * @updateTime：rxcache 缓存
 */
public  interface CacheApi {

    /**
     * 随机妹纸图
     */
    @LifeCache(duration = 2,timeUnit = TimeUnit.MINUTES)//两分钟失效
    Flowable<SampleApiResponse<List<GankItemBean>>> getRandomGirl(Flowable<SampleApiResponse<List<GankItemBean>>> sampleApiResponseFlowable);
}
