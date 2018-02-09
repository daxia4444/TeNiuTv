package com.example.shutao.teniutv.ui.activity;

import android.content.Intent;

import com.example.shutao.teniutv.R;
import com.example.shutao.teniutv.ui.base.BaseActivity;
import com.example.shutao.teniutv.ui.base.BasePresenter;
import com.example.shutao.teniutv.utils.UIUtils;

import flyn.Eyes;

public class SplashActivity extends BaseActivity {

    @Override
    protected BasePresenter createPresenter() {
        return null;
    }

    @Override
    public boolean enableSlideClose() {
        return false;
    }

    @Override
    protected int provideContentViewId() {
        return R.layout.activity_splash;
    }

    @Override
    public void initView() {
        Eyes.translucentStatusBar(this,false);//
        UIUtils.postTaskDelay(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,MainActivity.class));
                finish();
            }
        },2000);
    }

}
