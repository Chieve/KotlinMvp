package com.chieveke.androidframework.feature.di.component;


import com.chieveke.androidframework.feature.view.NetSampleFragment;
import com.chieveke.arms.di.FragmentScope;
import com.chieveke.arms.di.component.AppComponent;
import com.chieveke.arms.di.module.FragmentModule;

import dagger.Component;

/**
 * @author:
 * @createDate :
 * @description :The annotation in Fragment, defines the scope of Activity, and the scope of dependent injection is Fragment
 */
@FragmentScope
@Component(dependencies = AppComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

    //TODO inject(IView)
    void  inject(NetSampleFragment netSampleFragment);
}
