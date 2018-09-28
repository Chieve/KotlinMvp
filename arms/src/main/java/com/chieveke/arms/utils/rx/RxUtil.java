package com.chieveke.arms.utils.rx;


import com.chieveke.arms.data.net.ApiResponse;
import com.chieveke.arms.data.net.RetryWhenHandler;

import io.reactivex.Flowable;
import io.reactivex.FlowableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @description: Rxjava使用的工具类
 * @author: chieveke
 * @date: 2018/9/28 15:04
 * @version: V1.0
 */
public class RxUtil {

    /**
     * 统一线程处理
     *
     * @param <T>
     * @return
     */
    public static <T extends ApiResponse> FlowableTransformer<T, T> rxSchedulerHelper() {    //compose简化线程
        return rxSchedulerHelper(3,3);
    }


    /**
     *  统一线程处理和失败重连
     * @param count   失败重连次数
     * @param delay  延迟时间
     * @param <T>      返回数据data实际的 数据
     * @return   返回数据data实际的 数据
     */
    public static <T extends ApiResponse> FlowableTransformer<T, T> rxSchedulerHelper(final int count, final long delay) {    //compose简化线程
        return new FlowableTransformer<T, T>() {
            @Override
            public Flowable<T> apply(Flowable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .flatMap(new Function<T, Flowable<T>>() {
                            @Override
                            public Flowable<T> apply(T t) throws Exception {

//                                if (t != null && "40108".equals(t.getCode())) {
//                                    SPHelper.put(AppContext.get(), "access_token", t.getMessage());
//                                    throw new NullPointerException("token_is_need_refresh");
//                                } else {
//                                    return Flowable.just(t);
//                                }

                                // TODO: 2017/8/22 根据实际情况去处理 
                                    return Flowable.just(t);
                            }
                        })
                        .retryWhen(new RetryWhenHandler(count, delay))
                        .observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


    //    /**
    //     * 统一返回结果处理
    //     * @param <T>
    //     * @return
    //     */
    //    public static <T> Observable.Transformer<MyHttpResponse<T>, T> handleMyResult() {   //compose判断结果
    //        return new Observable.Transformer<MyHttpResponse<T>, T>() {
    //            @Override
    //            public Observable<T> call(Observable<MyHttpResponse<T>> httpResponseObservable) {
    //                return httpResponseObservable.flatMap(new Func1<MyHttpResponse<T>, Observable<T>>() {
    //                    @Override
    //                    public Observable<T> call(MyHttpResponse<T> tMyHttpResponse) {
    //                        if(tMyHttpResponse.getCode() == 200) {
    //                            return createData(tMyHttpResponse.getData());
    //                        } else {
    //                            return Observable.error(new ApiException("服务器返回error"));
    //                        }
    //                    }
    //                });
    //            }
    //        };
    //    }

}
