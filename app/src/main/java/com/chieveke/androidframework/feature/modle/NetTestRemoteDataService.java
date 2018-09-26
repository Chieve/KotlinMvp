package com.chieveke.androidframework.feature.modle;


import com.chieveke.androidframework.base.SampleApiResponse;
import com.chieveke.androidframework.feature.modle.bean.GankItemBean;
import com.chieveke.androidframework.feature.presenter.contract.INetTestContract;
import com.chieveke.arms.data.HttpHelper;
import com.chieveke.arms.utils.rx.RxUtil;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.Flowable;

/**
 * @author
 * @createDate
 * @description
 */

public class NetTestRemoteDataService implements INetTestContract.IModel {

    private HttpHelper mHttpHelper;

    @Inject
    public NetTestRemoteDataService(HttpHelper httpHelper) {
        this.mHttpHelper = httpHelper;
    }


    @Override
    public Flowable<SampleApiResponse<List<GankItemBean>>> getRandomGirl() {
        return mHttpHelper.createApi(Api.class).getRandomGirl(1).compose(RxUtil.<SampleApiResponse<List<GankItemBean>>>rxSchedulerHelper());
    }

}