package com.chieveke.arms.data.net;

import android.support.annotation.NonNull;
import android.util.Log;

import com.chieveke.arms.utils.string.HmacSHA1Encryption;
import com.chieveke.arms.utils.sys.TimeUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

import okhttp3.FormBody;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @description: 添加公共请求参数
 * @author: chieveke
 * @date: 2018/10/23 20:47
 * @version: V1.0
 */
public class CommonInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        //获取原先的请求
        Request originalRequest = chain.request();
        //重新构建url
        HttpUrl.Builder builder = originalRequest.url().newBuilder();

        //这里是我的时间戳公共参数
        builder.addQueryParameter("timestamp", TimeUtil.currentTimeSecond() + "");
        //这里是我的第2个公共参数token
        builder.addQueryParameter("token", makeTokenString(originalRequest));

        //新的url
        HttpUrl httpUrl = builder.build();
        Request request = originalRequest.newBuilder().method(originalRequest.method(), originalRequest.body()).url(httpUrl).build();
        return chain.proceed(request);
    }

    @NonNull
    private String makeTokenString(Request originalRequest) {
        Map<String, String> stringMap = new HashMap<String, String>();
        FormBody body = (FormBody) originalRequest.body();
        for (int i = 0; i < body.size(); i++) {
            Log.i("RequestFatory", body.name(i) + "---" + body.value(i));
//                builder.addQueryParameter(body.name(i), body.value(i));
            stringMap.put(body.name(i), body.value(i));
        }
        Map sortedMap = new TreeMap();
        sortedMap.putAll(stringMap);
        Map.Entry entry;
        StringBuffer sb = new StringBuffer();
        for (Iterator iterator = sortedMap.entrySet().iterator(); iterator.hasNext(); ) {
            entry = (Map.Entry) iterator.next();
            sb.append(entry.getKey().toString()).append("=").append(null == entry.getValue() ? "" :
                    entry.getValue().toString()).append(iterator.hasNext() ? "&" : "");
        }
        return HmacSHA1Encryption.HmacSHA1Encrypt(sb.toString());
    }
}