package com.example.shutao.teniutv.ui.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shutao.teniutv.R;
import com.example.shutao.teniutv.ui.widget.StateView;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/18.
 */

public abstract class BaseFragment extends Fragment {

    private View rootView;

    protected StateView mStateView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = inflater.inflate(provideContentViewId(), container, false);
            ButterKnife.bind(this, rootView);

            mStateView = StateView.inject(getStateViewRoot());
            if (mStateView != null) {
                mStateView.setLoadingResource(R.layout.page_loading);
                mStateView.setRetryResource(R.layout.page_net_error);
            }

            initView(rootView);
            initData();
            initListener();
        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);
            }
        }
        return rootView;
    }

    public View getStateViewRoot() {
        return rootView;
    }


    public void initView(View rootView) {
    }

    /**
     * 初始化数据
     */
    public void initData() {

    }

    /**
     * 设置listener的操作
     */
    public void initListener() {

    }

    protected abstract int provideContentViewId();

}
