package com.chieveke.androidframework.feature.presenter;


import com.chieveke.androidframework.base.SampleApiResponse;
import com.chieveke.androidframework.base.SampleSubscriber;
import com.chieveke.androidframework.base.SampleSubscriberListener;
import com.chieveke.androidframework.feature.modle.NetTestRemoteDataService;
import com.chieveke.androidframework.feature.modle.bean.GankItemBean;
import com.chieveke.androidframework.feature.presenter.contract.INetTestContract;
import com.chieveke.arms.base.XPresenter;
import com.chieveke.arms.data.net.NetError;

import java.util.List;

import javax.inject.Inject;

/**
 * @author
 * @createDate
 * @description
 */

public class NetTestPresenter extends XPresenter<INetTestContract.IView> implements INetTestContract.IPresenter {

    private NetTestRemoteDataService mNetTestRemoteDataService;

    @Inject
    public NetTestPresenter(NetTestRemoteDataService NetTestRemoteDataService) {
        mNetTestRemoteDataService = NetTestRemoteDataService;
    }


    @Override
    public void getRandomGirl() {
        mNetTestRemoteDataService.getRandomGirl()
                .compose(getV().<SampleApiResponse<List<GankItemBean>>>bindLifecycle())
                .subscribe(new SampleSubscriber<SampleApiResponse<List<GankItemBean>>>(new SampleSubscriberListener<List<GankItemBean>>() {
                    @Override
                    public void onSuccess(List<GankItemBean> response) {
                        getV().success(response);
                    }

                    @Override
                    public void onFail(NetError errorMsg) {
                        super.onFail(errorMsg);
                        getV().failure("-1", errorMsg.getMessage());
                    }
                }));
    }
}