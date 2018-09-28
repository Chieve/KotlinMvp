package com.chieveke.arms.framework;


import com.chieveke.arms.data.IDataHelper;
import com.chieveke.arms.di.component.AppComponent;
import com.chieveke.arms.di.component.DaggerAppComponent;

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/28 15:07
 * @version: V1.0
 */
public interface ISupportApplication {


     AppComponent getAppComponent();

     DaggerAppComponent.Builder getAppComponentBuilder();

     IDataHelper.NetConfig getNetConfig();


}
