package com.chieveke.androidframework.feature.modle.bean;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

/**
 * @description:
 * @author: chieveke
 * @date: 2018/9/26 14:26
 * @version: V1.0
 */
@Entity(tableName = "UserEntity")
public class UserEntity {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "uid")
    private int uid;

    @NonNull
    @ColumnInfo(name = "id")
    private String id;
    //字段映射具体的数据表字段名
    @ColumnInfo(name = "name")
    private String name;

    @ColumnInfo(name = "age")
    private String age;

    //必须指定一个构造方法，room框架需要。并且只能指定一个 //，如果有其他构造方法，则其他的构造方法必须添加@Ignore注解
    public UserEntity() { }
    //其他构造方法要添加@Ignore注解
    @Ignore
    public UserEntity(String id,String name,String age){
        this.id = id;
        this.name =name;
        this.age = age;
    }

    @NonNull
    public String getId() {
        return id;
    }

    public void setId(@NonNull String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public int getUid() {
        return uid;
    }

    public void setUid(int uid) {
        this.uid = uid;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
