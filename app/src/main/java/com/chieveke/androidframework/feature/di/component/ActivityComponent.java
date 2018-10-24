package com.chieveke.androidframework.feature.di.component;

import com.chieveke.androidframework.feature.view.LoginActivity;
import com.chieveke.androidframework.feature.view.LoginDemoActivity;
import com.chieveke.androidframework.feature.view.MainActivity;
import com.chieveke.androidframework.feature.view.NetSampleActivity;
import com.chieveke.androidframework.feature.view.RoomSampleActivity;
import com.chieveke.androidframework.feature.view.RxCacheSampleActivity;
import com.chieveke.arms.di.ActivityScope;
import com.chieveke.arms.di.component.AppComponent;
import com.chieveke.arms.di.module.ActivityModule;

import dagger.Component;

/**
 * @author:
 * @createDate :
 * @description :The annotations to the activity are used to restrict the scope of the Context and the scope of the dependency injection
 */
@ActivityScope
@Component(dependencies =AppComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    //TODO inject(IView)
    void  inject(NetSampleActivity netSampleActivity);

    void  inject(RxCacheSampleActivity rxCacheSampleActivity);

    void  inject(RoomSampleActivity roomSampleActivity);

    void  inject(MainActivity mainActivity);

    void inject(LoginDemoActivity loginDemoActivity);

    void inject(LoginActivity loginActivity);
}
