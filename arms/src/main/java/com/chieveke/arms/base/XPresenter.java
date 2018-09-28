package com.chieveke.arms.base;


import com.chieveke.arms.framework.IBasePresenter;
import com.chieveke.arms.framework.IBaseView;

/**
 * @description: Used to attachView and detachView
 * @author: chieveke
 * @date: 2018/9/28 15:10
 * @version: V1.0
 */
public class XPresenter<V extends IBaseView> implements IBasePresenter<V> {

    private V mView;

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    @Override
    public void detachView() {
        this.mView = null;
    }

    /**
     *  getViewModel ViewModel  is Activity or Fragment
     *
     * @return  IBaseView
     */
    protected V getV() {
        if (mView == null) {
            throw new IllegalStateException("view can not be null");
        }
        return mView;
    }
}