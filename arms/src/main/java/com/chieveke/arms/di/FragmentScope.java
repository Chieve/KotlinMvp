package com.chieveke.arms.di;

import java.lang.annotation.Retention;

import javax.inject.Scope;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @description: TODO 请描述该类职责
 * @author: chieveke
 * @date: 2018/9/28 15:00
 * @version: V1.0
 */
@Scope
@Retention(RUNTIME)
public @interface FragmentScope {
}
