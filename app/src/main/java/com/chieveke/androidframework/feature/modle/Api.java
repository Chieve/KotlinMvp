package com.chieveke.androidframework.feature.modle;


import com.chieveke.androidframework.base.InfoResponseEntityBase;
import com.chieveke.androidframework.base.SampleApiResponse;
import com.chieveke.androidframework.feature.modle.bean.GankItemBean;
import com.chieveke.androidframework.feature.modle.bean.LoginUserEntity;

import java.util.List;

import io.reactivex.Flowable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * @creator：denghc(desoce)
 * @updateTime：2018/8/22 下午2:22
 * @description：TODO 请描述该类职责
 */
public interface Api {

//    String baseURL= "http://gank.io/api/";
    String baseURL= "http://kservice.gigastage.cc";
    /**
     * 随机妹纸图
     */
//    @GET("random/data/福利/{num}")
    @GET("data/Android/10/{num}")
    Flowable<SampleApiResponse<List<GankItemBean>>> getRandomGirl(@Path("num") int num);

    //登录接口
    @FormUrlEncoded
    @POST("/Kaisa/login/login")
    Flowable<InfoResponseEntityBase<LoginUserEntity>> login(@Field(StaticData.USERNAME) String username,
                                                            @Field(StaticData.PASSWORD) String password);

}
