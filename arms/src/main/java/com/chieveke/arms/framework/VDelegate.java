package com.chieveke.arms.framework;

import android.view.View;

/**
 * @description: View的代理
 * @author: chieveke
 * @date: 2018/9/28 15:01
 * @version: V1.0
 */
public interface VDelegate {

    void resume();

    void pause();

    void destory();

    void visible(boolean flag, View view);

    void gone(boolean flag, View view);

    void inVisible(View view);

    void toastShort(String msg);

    void toastLong(String msg);

}
