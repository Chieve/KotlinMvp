package com.chieveke.androidframework.feature.modle.dao;

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/26 18:08
 * @version: V1.0
 */

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.chieveke.androidframework.feature.modle.bean.UserEntity;

@Dao
public interface UserDao {
    //-----------------------insert---------------------- // OnConflictStrategy.REPLACE表示如果已经有数据，那么就覆盖掉
    // 数据的判断通过主键进行匹配，也就是uid，非整个user对象 //返回Long数据表示，插入条目的主键值（id）
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    Long insertUser(UserEntity user);
//
//    //同上
    @Query("SELECT * FROM UserEntity WHERE id = :id")
    UserEntity findById(String id);
}
