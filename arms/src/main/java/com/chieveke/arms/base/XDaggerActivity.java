package com.chieveke.arms.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.chieveke.arms.di.module.ActivityModule;
import com.chieveke.arms.framework.IBasePresenter;
import com.chieveke.arms.framework.IBaseView;
import com.chieveke.arms.framework.ISupportDagger;
import com.trello.rxlifecycle2.LifecycleTransformer;

import javax.inject.Inject;

/**
 * @description: XDaggerActivity is  MVP by Dagger2
 * @author: chieveke
 * @date: 2018/9/28 15:10
 * @version: V1.0
 */
public abstract class XDaggerActivity<T extends IBasePresenter> extends BaseActivity implements IBaseView, ISupportDagger {

    @Inject
    protected T mPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        initInject(savedInstanceState);
        if (mPresenter != null)
            mPresenter.attachView(this);
        super.onCreate(savedInstanceState);

    }


    @Override
    public <E> LifecycleTransformer<E> bindLifecycle() {
        return this.<E>bindToLifecycle();
    }


    @Override
    public Context getAContext() {
        return this;
    }



    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }

}