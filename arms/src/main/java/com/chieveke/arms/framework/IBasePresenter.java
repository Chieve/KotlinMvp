package com.chieveke.arms.framework;

/**
 * @description: Presenter基类
 * @author: chieveke
 * @date: 2018/9/28 15:00
 * @version: V1.0
 */
public interface IBasePresenter<V extends IBaseView>{

    /**
     *   lifecycle attachView
     * @param view
     */
    void attachView(V view);

    /**
     *  lifecycle detachView{@link XDaggerActivity#onDestroy()}
     */
    void detachView();

}
