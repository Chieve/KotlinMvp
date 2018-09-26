package com.chieveke.androidframework.feature.view;

import android.os.Bundle;
import android.widget.TextView;

import com.chieveke.androidframework.R;
import com.chieveke.androidframework.feature.di.DiHelper;
import com.chieveke.androidframework.feature.modle.bean.GankItemBean;
import com.chieveke.androidframework.feature.presenter.RxCacheTestPresenter;
import com.chieveke.androidframework.feature.presenter.contract.INetTestContract;
import com.chieveke.arms.base.XDaggerActivity;

import java.util.List;

/**
 * @creator：denghc(desoce)
 * @updateTime：2018/8/23 下午2:55
 * @description：使用 RXCACHE示例
 */
public class RxCacheSampleActivity extends XDaggerActivity<RxCacheTestPresenter> implements INetTestContract.IView<List<GankItemBean>> {

    private TextView title;
    private TextView content;

    @Override
    public int getLayoutId() {
        return R.layout.activity_rxcache_sample;
    }

    @Override
    public void initEventAndData(Bundle savedInstanceState) {
        title = $(R.id.tv_title);
        title.setText("Url : http://gank.io/api/random/data/福利/1");
        content = $(R.id.tv_content);
        mPresenter.getRandomGirl();//调用方法请求接口
    }

    @Override
    public void initInject(Bundle savedInstanceState) {
        DiHelper.getActivityComponent(getActivityModule()).inject(this);
    }

    @Override
    public void success(List<GankItemBean> data) {
        content.setText(getString(R.string.data_f,data.get(0).toString()));
    }

    @Override
    public void failure(String code, String msg) {

    }
}
