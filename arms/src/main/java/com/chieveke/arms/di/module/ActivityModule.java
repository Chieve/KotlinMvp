package com.chieveke.arms.di.module;

import android.app.Activity;

import com.chieveke.arms.di.ActivityScope;

import dagger.Module;
import dagger.Provides;

/**
 * @description: TODO 请描述该类职责
 * @author: chieveke
 * @date: 2018/9/28 14:58
 * @version: V1.0
 */
@Module
public class ActivityModule {
    private Activity mActivity;

    public ActivityModule(Activity activity) {
        this.mActivity = activity;
    }

    @Provides
    @ActivityScope
    public Activity provideActivity() {
        return mActivity;
    }
}
