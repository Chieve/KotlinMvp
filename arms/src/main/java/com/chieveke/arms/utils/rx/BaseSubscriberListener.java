package com.chieveke.arms.utils.rx;


import com.chieveke.arms.data.net.NetError;
import com.chieveke.arms.data.net.SubscriberListener;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;

import org.json.JSONException;

import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.net.UnknownHostException;

import retrofit2.HttpException;


/**
 * @description:  ${请求统一处理}
 * @author: chieveke
 * @date: 2018/9/28 15:04
 * @version: V1.0
 */
public abstract class BaseSubscriberListener<T> extends SubscriberListener<T> {


    public void onFail(NetError errorMsg) {

    }


    @Override
    public void onError(Throwable e) {
        NetError error = null;
        if (e != null) {
            if (!(e instanceof NetError)) {
                if (e instanceof UnknownHostException) {
                    error = new NetError(e, NetError.NoConnectError);
                } else if (e instanceof JSONException
                        || e instanceof JsonParseException
                        || e instanceof JsonSyntaxException) {
                    error = new NetError(e, NetError.ParseError);
                } else if (e instanceof SocketException
                        || e instanceof SocketTimeoutException) {
                    error = new NetError(e, NetError.SocketError);
                } else if (e instanceof HttpException) {
                    HttpException httpException = (HttpException) e;
                    if (isCheckReLogin(httpException)) {//去认证
                        checkReLogin("401", "checkout");
                    }
                    error = new NetError(e, NetError.NetError);
                } else {
                    error = new NetError(e, NetError.OtherError);
                }
            } else {
                error = (NetError) e;
            }
            onFail(error);
        }
    }

    @Override
    public void checkReLogin(String errorCode, String errorMsg) {
        //todo
    }

    @Override
    public boolean isCheckReLogin(HttpException httpException) {
        return false;
    }

}
