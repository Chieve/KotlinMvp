package com.chieveke.arms.framework;

import android.os.Bundle;
import android.view.View;

/**
 * @description: expand Activity&Fragment
 * @author: chieveke
 * @date: 2018/9/28 15:08
 * @version: V1.0
 */
public interface ISupportBaseView {

    /**
     * get LayoutResID
     *
     * @return layoutResId
     */
    int getLayoutId();

    /**
     * initView &  initData
     *
     * @param savedInstanceState the data most recently supplied in .
     */
    void initEventAndData(Bundle savedInstanceState);

    /**
     * replace  findViewById
     *
     * @param resId   layout resId
     * @param <T>   View
     * @return    View
     */
     <T extends View> T $(int resId) ;

}
