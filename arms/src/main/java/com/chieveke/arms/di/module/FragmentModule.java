package com.chieveke.arms.di.module;

import android.app.Activity;
import android.support.v4.app.Fragment;

import com.chieveke.arms.di.FragmentScope;

import dagger.Module;
import dagger.Provides;

/**
 * @description: TODO 请描述该类职责
 * @author: chieveke
 * @date: 2018/9/28 14:59
 * @version: V1.0
 */
@Module
public class FragmentModule {

    private Fragment fragment;

    public FragmentModule(Fragment fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public Activity provideActivity() {
        return fragment.getActivity();
    }
}
