package com.chieveke.arms.framework;

/**
 * @description: BaseActivity support
 * @author: chieveke
 * @date: 2018/9/28 15:07
 * @version: V1.0
 */
public interface ISupportBaseActivity extends  ISupportBaseView {

    /**
     * Reload this Activity  (NoAnim)
     */
    void reload();

    /**
     * Reload this Activity
     *
     * @param isNeedAnim IsNeed animation for reload
     */
    void reload(boolean isNeedAnim);


}
