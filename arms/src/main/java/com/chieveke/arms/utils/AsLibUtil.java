package com.chieveke.arms.utils;

import android.app.Application;
import android.content.res.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/28 15:07
 * @version: V1.0
 */
public class AsLibUtil {


    private static List<ApplicationLike> mChildApplicationList = new ArrayList<>();

    public static void addAsLIbChild(ApplicationLike applicationAsLibrary){
        if (applicationAsLibrary!=null)
        mChildApplicationList.add(applicationAsLibrary);
    }

    public static void  doCreateAsLibrary(Application application){
        for (ApplicationLike app : mChildApplicationList) {
            if (app!=null)
            app.onCreateAsLibrary(application);
        }
    }

    public static void onLowMemoryAsLibrary(Application application) {
        for (ApplicationLike app : mChildApplicationList) {
            if (app!=null)
                app.onLowMemoryAsLibrary(application);
        }
    }

    public static void onTrimMemoryAsLibrary(Application application, int level) {
        for (ApplicationLike app : mChildApplicationList) {
            if (app!=null)
                app.onTrimMemoryAsLibrary(application,level);
        }
    }

    public static void onTerminate(Application application) {
        for (ApplicationLike app : mChildApplicationList) {
            if (app!=null)
                app.onTerminate(application);
        }
    }

    public static void onConfigurationChanged(Application application, Configuration newConfig) {
        for (ApplicationLike app : mChildApplicationList) {
            if (app!=null)
                app.onConfigurationChanged(application,newConfig);
        }
    }
}
