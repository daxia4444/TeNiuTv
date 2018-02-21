package com.example.shutao.teniutv.ui.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.shutao.teniutv.R;
import com.example.shutao.teniutv.model.entity.Channel;
import com.example.shutao.teniutv.ui.base.BaseFragment;
import com.example.shutao.teniutv.ui.widget.StateView;

import java.util.ArrayList;
import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/2/18.
 */

public class HomeFragment extends BaseFragment {


    private View rootView;
    private List<Channel> mSelectedChannels = new ArrayList<>();

    protected StateView mStateView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if (rootView == null) {
            rootView = inflater.inflate(R.layout.fragment_home, container, false);
            ButterKnife.bind(this, rootView);

            mStateView = StateView.inject(rootView);
            if (mStateView != null) {
           /* mStateView.setLoadingResource(R.layout.page_loading);*/
                mStateView.setRetryResource(R.layout.page_net_error);
            }

        } else {
            ViewGroup parent = (ViewGroup) rootView.getParent();
            if (parent != null) {
                parent.removeView(rootView);

            }

        }

        return rootView;
    }

    private  void initChannelData(){

        String[] channels = getResources().getStringArray(R.array.channel);
        String[] channelCodes = getResources().getStringArray(R.array.channel_code);
        //默认添加了全部频道
        for (int i = 0; i < channelCodes.length; i++) {
            String title = channels[i];
            String code = channelCodes[i];
            mSelectedChannels.add(new Channel(title, code));
        }


    }


    private void initChannelFragments() {
        KLog.e("initChannelFragments");
        String[] channelCodes = getResources().getStringArray(R.array.channel_code);
        for (Channel channel : mSelectedChannels) {
            NewsListFragment newsFragment = new NewsListFragment();
            Bundle bundle = new Bundle();
            bundle.putString(Constant.CHANNEL_CODE, channel.channelCode);
            bundle.putBoolean(Constant.IS_VIDEO_LIST, channel.channelCode.equals(channelCodes[1]));//是否是视频列表页面,根据判断频道号是否是视频
            newsFragment.setArguments(bundle);
            mChannelFragments.add(newsFragment);//添加到集合中
        }
    }


}