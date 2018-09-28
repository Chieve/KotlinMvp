package com.chieveke.arms.framework;

import android.content.Context;

import com.trello.rxlifecycle2.LifecycleTransformer;

/**
 * @description: View的基类
 * @author: chieveke
 * @date: 2018/9/28 15:00
 * @version: V1.0
 */
public interface IBaseView  {

    /**
     * Retrofit bind View Lifecycle
     * @param <T>   Response data
     * @return  Response data
     */
    <T> LifecycleTransformer<T> bindLifecycle() ;

    /**
     * get  View context
     * @return
     */
    Context getAContext() ;

}
