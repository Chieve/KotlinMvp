package com.chieveke.arms.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.CheckResult;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;

import com.chieveke.arms.R;
import com.chieveke.arms.framework.ISupportBaseActivity;
import com.trello.rxlifecycle2.LifecycleProvider;
import com.trello.rxlifecycle2.LifecycleTransformer;
import com.trello.rxlifecycle2.RxLifecycle;
import com.trello.rxlifecycle2.android.ActivityEvent;
import com.trello.rxlifecycle2.android.RxLifecycleAndroid;

import io.reactivex.Observable;
import io.reactivex.subjects.BehaviorSubject;
import me.yokeyword.fragmentation.SwipeBackLayout;
import me.yokeyword.fragmentation_swipeback.SwipeBackActivity;

/**
 * @description: BaseActivity by no mvp
 * @author: chieveke
 * @date: 2018/9/28 15:08
 * @version: V1.0
 */
public abstract class BaseActivity extends SwipeBackActivity implements LifecycleProvider<ActivityEvent>,ISupportBaseActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    /**
     * Rewrite RxLife to control the life cycle
     */
    private final BehaviorSubject<ActivityEvent> lifecycleSubject = BehaviorSubject.create();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

//      初始化滑动退出
        initSwipBackActivty();
        lifecycleSubject.onNext(ActivityEvent.CREATE);
        if (getLayoutId() > 0) {
            setContentView(getLayoutId());
        }
        Log.i(TAG,"activity: " + getClass().getSimpleName() + " onCreate()");
        initEventAndData(savedInstanceState);
    }

    private void initSwipBackActivty() {
        getSwipeBackLayout().setEdgeOrientation(SwipeBackLayout.EDGE_LEFT); // EDGE_LEFT(默认),EDGE_ALL
        getSwipeBackLayout().setParallaxOffset(0.3f); // （类iOS）滑动退出视觉差，默认0.3
        setSwipeBackEnable(true); // 是否允许滑动
        getSwipeBackLayout().addSwipeListener(new SwipeBackLayout.OnSwipeListener() {
            @Override
            public void onDragStateChange(int state) {
                // Drag state
            }

            @Override
            public void onEdgeTouch(int edgeFlag) {
                // 触摸的边缘flag
            }

            @Override
            public void onDragScrolled(float scrollPercent) {
                // 滑动百分比
            }
        });
    }

    /**
     * replace  findViewById
     *
     * @param resId   layout resId
     * @param <T>   View
     * @return    View
     */
    @Override
    public  <T extends View> T $(int resId) {
        return (T) super.findViewById(resId);
    }



    @Override
    protected void onDestroy() {
        lifecycleSubject.onNext(ActivityEvent.DESTROY);
        super.onDestroy();
        Log.i(TAG,"activity: " + getClass().getSimpleName() + " onDestroy()");
    }

    /**
     * Reload this Activity  (NoAnim)
     */
    @Override
    public final void reload() {
        reload(false);
    }

    /**
     * Reload this Activity
     *
     * @param isNeedAnim    IsNeed animation for reload
     */
    @Override
    public final void reload(boolean isNeedAnim) {
        if (isNeedAnim) {
            getWindow().setWindowAnimations(R.style.WindowAnimationFadeInOut);
            recreate();
        } else {
            Intent intent = getIntent();
            overridePendingTransition(0, 0);
            intent.addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            finish();
            overridePendingTransition(R.anim.fade_in,0);
            startActivity(intent);
        }
    }

    /**
     * Please try to override this method to avoid copying onBackPress(),
     * To ensure that the onBackPressedSupport() rewind event in the SupportFragment is executed normally
     */
    @Override
    public void onBackPressedSupport() {
        super.onBackPressedSupport();
    }


    /**------------------------             Rxlife start               ------------------------*/

    @Override
    @NonNull
    @CheckResult
    public final Observable<ActivityEvent> lifecycle() {
        return lifecycleSubject.hide();
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindUntilEvent(@NonNull ActivityEvent event) {
        return RxLifecycle.bindUntilEvent(lifecycleSubject, event);
    }

    @Override
    @NonNull
    @CheckResult
    public final <T> LifecycleTransformer<T> bindToLifecycle() {
        return RxLifecycleAndroid.bindActivity(lifecycleSubject);
    }


    @Override
    @CallSuper
    protected void onStart() {
        super.onStart();
        lifecycleSubject.onNext(ActivityEvent.START);
    }

    @Override
    @CallSuper
    protected void onResume() {
        super.onResume();
        lifecycleSubject.onNext(ActivityEvent.RESUME);
    }

    @Override
    @CallSuper
    protected void onPause() {
        lifecycleSubject.onNext(ActivityEvent.PAUSE);
        super.onPause();
    }

    @Override
    @CallSuper
    protected void onStop() {
        lifecycleSubject.onNext(ActivityEvent.STOP);
        super.onStop();
    }

    /**------------------------             Rxlife    end          ------------------------*/
}
