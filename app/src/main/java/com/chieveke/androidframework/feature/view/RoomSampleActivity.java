package com.chieveke.androidframework.feature.view;

import android.os.Bundle;
import android.widget.TextView;

import com.chieveke.androidframework.R;
import com.chieveke.androidframework.feature.di.DiHelper;
import com.chieveke.androidframework.feature.modle.bean.GankItemBean;
import com.chieveke.androidframework.feature.presenter.RoomTestPresenter;
import com.chieveke.androidframework.feature.presenter.contract.INetTestContract;
import com.chieveke.arms.base.XDaggerActivity;

import java.util.List;

import io.reactivex.functions.Consumer;


/**
 * @creator：denghc(desoce)
 * @updateTime：2018/8/23 下午2:55
 * @description：使用 Room示例
 */
public class RoomSampleActivity extends XDaggerActivity<RoomTestPresenter> implements INetTestContract
        .IView<List<GankItemBean>> {

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
        mPresenter.loadAllByIds(new String[]{data.get(0).get_id()}).subscribe(new
                                                                          Consumer<List<GankItemBean>>() {
            @Override
            public void accept(List<GankItemBean> gankItemBeans) throws Exception {
                ((TextView )$(R.id.tv_database)).setText("数据库数据: "+gankItemBeans.get(0).toString());
            }
        });
    }

    @Override
    public void failure(String code, String msg) {

    }
}
