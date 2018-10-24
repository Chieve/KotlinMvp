package com.chieveke.androidframework.feature.view;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.chieveke.androidframework.R;
import com.chieveke.arms.base.BaseActivity;

public class WelcomeActivity extends BaseActivity {


    @Override
    public int getLayoutId() {
        return R.layout.activity_welcome;
    }

    @Override
    public void initEventAndData(Bundle savedInstanceState) {
        Handler handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                Intent intent = new Intent();
                switch (msg.what) {
                    case 0:
//                        if (!pref.isLogin()) {// 未登录
//                            intent.setClass(WelcomeActivity.this, LoginDemoActivity.class);
//                            startActivity(intent);
//                        }
//                        else {
                            intent.setClass(WelcomeActivity.this, LoginActivity.class);
                            startActivity(intent);
//                        }
                        WelcomeActivity.this.finish();
                        break;
                }

//                finish();
                return true;
            }
        });

        handler.sendEmptyMessageDelayed(0, 1500);
    }
}
