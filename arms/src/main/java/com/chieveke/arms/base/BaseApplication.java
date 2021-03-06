package com.chieveke.arms.base;


import android.app.Application;
import android.content.res.Configuration;

import com.chieveke.arms.data.IDataHelper;
import com.chieveke.arms.di.component.AppComponent;
import com.chieveke.arms.di.component.DaggerAppComponent;
import com.chieveke.arms.framework.ISupportApplication;
import com.chieveke.arms.framework.XAppDelegate;

/**
 * @description: BaseApplication
 * @author: chieveke
 * @date: 2018/9/28 15:08
 * @version: V1.0
 */
public class BaseApplication extends Application implements ISupportApplication {
    private XAppDelegate xAppDelegate;


    @Override
    public void onCreate() {
        super.onCreate();
        xAppDelegate = new XAppDelegate.DefaultAppDelegate(this).netConfig(getNetConfig());
        xAppDelegate.onCreate();
    }

    public XAppDelegate getXAppDelegate() {
        return xAppDelegate;
    }


    @Override
    public AppComponent getAppComponent() {
        return xAppDelegate.getAppComponent();
    }

    @Override
    public DaggerAppComponent.Builder getAppComponentBuilder() {
        return xAppDelegate.getAppComponentBuilder();
    }

    @Override
    public IDataHelper.NetConfig getNetConfig() {
        return null;
    }


    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        xAppDelegate.onTrimMemory(level);
    }

    @Override
    public void onLowMemory() {
        super.onLowMemory();
        xAppDelegate.onLowMemory();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        xAppDelegate.onTerminate();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        xAppDelegate.onConfigurationChanged(newConfig);
    }



}
