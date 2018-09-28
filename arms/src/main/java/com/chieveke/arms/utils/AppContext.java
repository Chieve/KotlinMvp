package com.chieveke.arms.utils;

import android.content.Context;


/**
 * @description: save AppContext
 * @author: chieveke
 * @date: 2018/9/28 15:05
 * @version: V1.0
 */
public class AppContext {
  public static Context mAppContext;


  public static void init(Context context) {
    if (mAppContext == null) {
      mAppContext = context.getApplicationContext();
    } else {
      throw new IllegalStateException("set context duplicate");
    }
  }

  public static Context get() {
    if (mAppContext == null) {
      throw new IllegalStateException("forget init?");
    } else {
      return mAppContext;
    }
  }
}
