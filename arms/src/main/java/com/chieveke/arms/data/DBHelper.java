package com.chieveke.arms.data;

import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.chieveke.arms.data.cache.ICache;


/**
 * 创建者     邓浩宸
 * 创建时间   2018/3/27 16:38
 * 描述	      room数据库帮助类
 */

public class DBHelper {

    ICache iCache;
    public Context context;

    public DBHelper(Context context, ICache iCache) {
        //Map used to store db
        this.context = context;
        this.iCache=iCache;
    }

    @SuppressWarnings("unchecked")
    public <S extends RoomDatabase> S getApi(Class<S> serviceClass, String dbName) {
        if (iCache.contains(dbName)) {
            return (S) iCache.get(dbName);
        } else {
            Object obj = Room.databaseBuilder(context, serviceClass, dbName).build();
            iCache.put(dbName, obj);
            return (S) obj;
        }
    }

}