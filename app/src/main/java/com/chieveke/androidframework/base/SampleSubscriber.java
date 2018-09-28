package com.chieveke.androidframework.base;


import android.util.Log;

import com.chieveke.arms.base.BaseSubscriber;
import com.chieveke.arms.data.net.ApiResponse;
import com.chieveke.arms.data.net.NetError;
import com.chieveke.arms.data.net.SubscriberListener;

/**
 * 创建者
 * 创建时间   2017/8/26 16:26
 * 描述	      ${业务异常干货统一处理,自定义的Subscriber}
 */

public class SampleSubscriber<T extends ApiResponse> extends BaseSubscriber<T> {
    private static final String TAG =SampleSubscriber.class.getSimpleName() ;


    public SampleSubscriber(SubscriberListener mSubscriberOnNextListener) {
        super(mSubscriberOnNextListener);
    }

    @Override
    public void onNext(T response) {
        Log.i(TAG,"onNext");
        if (mSubscriberOnNextListener != null) {
            if (response != null && response.isSuccess()) {
                mSubscriberOnNextListener.onSuccess(response.getData());
            } else {
                if (response.checkReLogin())
                    mSubscriberOnNextListener.checkReLogin("请先登陆", "请先登陆");
                mSubscriberOnNextListener.onFail(new NetError("请先登陆", NetError.BusinessError));
            }
        }
    }
}