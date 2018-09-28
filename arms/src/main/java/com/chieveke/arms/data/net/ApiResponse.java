
package com.chieveke.arms.data.net;

/**
 * @description:  A wrapper class that responds to the results.
 * @author: chieveke
 * @date: 2018/9/28 15:10
 * @version: V1.0
 */
public interface ApiResponse<T> {

    /**
     *  isSuccess and   Data of type
     *
     * @return
     */
    boolean isSuccess();

    /**
     *  is authentication failure
     *
     * @return
     */
    boolean checkReLogin();

    /**
     *  Data
     *
     * @return
     */
    T getData();
}
