package com.chieveke.arms.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;

import javax.inject.Qualifier;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * @description: TODO 请描述该类职责
 * @author: chieveke
 * @date: 2018/9/28 14:59
 * @version: V1.0
 */
@Qualifier
@Documented
@Retention(RUNTIME)
public @interface ContextLife {
    String value() default "Application";
}
