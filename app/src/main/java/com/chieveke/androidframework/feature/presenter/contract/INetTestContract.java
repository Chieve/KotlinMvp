package com.chieveke.androidframework.feature.presenter.contract;

import com.chieveke.androidframework.base.SampleApiResponse;
import com.chieveke.androidframework.feature.modle.bean.GankItemBean;
import com.chieveke.arms.framework.IBaseModel;
import com.chieveke.arms.framework.IBasePresenter;
import com.chieveke.arms.framework.IBaseView;

import java.util.List;

import io.reactivex.Flowable;

/**
 * @author
 * @createDate
 * @description
 */
public interface INetTestContract {

    interface IView<T> extends IBaseView {

        void success(T data);

        void failure(String code, String msg);
    }

    interface IPresenter extends IBasePresenter<IView> {

        void getRandomGirl();

    }

    interface IModel extends IBaseModel {

        Flowable<SampleApiResponse<List<GankItemBean>>> getRandomGirl();

    }

}