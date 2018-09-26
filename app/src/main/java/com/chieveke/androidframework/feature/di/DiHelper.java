package com.chieveke.androidframework.feature.di;


import com.chieveke.androidframework.feature.di.component.ActivityComponent;
import com.chieveke.androidframework.feature.di.component.DaggerActivityComponent;
import com.chieveke.androidframework.feature.di.component.DaggerFragmentComponent;
import com.chieveke.androidframework.feature.di.component.FragmentComponent;
import com.chieveke.arms.base.BaseApplication;
import com.chieveke.arms.di.module.ActivityModule;
import com.chieveke.arms.di.module.FragmentModule;
import com.chieveke.arms.utils.AppContext;

/**
 * @author:   邓浩宸
 * @createDate :
 * @description :  helper for inject
 */
public class DiHelper {

        public static ActivityComponent getActivityComponent(ActivityModule activityModule) {
            return DaggerActivityComponent.builder()
                    .appComponent(((BaseApplication) AppContext.get()).getAppComponent())
                    .activityModule(activityModule)
                    .build();
        }


    public static FragmentComponent getFragmentComponent(FragmentModule fragmentModule){
            return DaggerFragmentComponent.builder()
                    .appComponent(((BaseApplication)AppContext.get()).getAppComponent())
                    .fragmentModule(fragmentModule)
                    .build();
        }


}
