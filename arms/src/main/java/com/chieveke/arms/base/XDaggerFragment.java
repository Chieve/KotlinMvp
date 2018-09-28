package com.chieveke.arms.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.chieveke.arms.di.module.FragmentModule;
import com.chieveke.arms.framework.IBasePresenter;
import com.chieveke.arms.framework.IBaseView;
import com.chieveke.arms.framework.ISupportDagger;
import com.trello.rxlifecycle2.LifecycleTransformer;

import javax.inject.Inject;


/**
 * 创建者：
 * 时间 ：2016/11/15 16:07
 * 描述 ： XDaggerFragment is  MVP by Dagger2
 */
public abstract class XDaggerFragment<T extends IBasePresenter> extends BaseFragment implements IBaseView,ISupportDagger {

    @Inject
    protected T mPresenter;
    public boolean isShowView=false;


    @Override
    public <E> LifecycleTransformer<E> bindLifecycle() {
        return this.<E>bindToLifecycle();
    }


    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        initInject(savedInstanceState);
        if (mPresenter != null) {
            isShowView = true;
            mPresenter.attachView(this);
        }
        super.onViewCreated(view, savedInstanceState);
    }


    @Override
    public Context getAContext() {
        return _mActivity;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mPresenter != null)
            mPresenter.detachView();
    }

    protected FragmentModule getFragmentModule() {
        return new FragmentModule(this);
    }

}