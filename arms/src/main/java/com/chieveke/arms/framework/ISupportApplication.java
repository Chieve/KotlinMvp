package com.chieveke.arms.framework;


import com.chieveke.arms.data.IDataHelper;
import com.chieveke.arms.di.component.AppComponent;
import com.chieveke.arms.di.component.DaggerAppComponent;


/**
 * @creator：denghc(desoce)
 * @updateTime：2018/7/30 10:55
 * @description：
 */
public interface ISupportApplication {


     AppComponent getAppComponent();

     DaggerAppComponent.Builder getAppComponentBuilder();

     IDataHelper.NetConfig getNetConfig();


}
