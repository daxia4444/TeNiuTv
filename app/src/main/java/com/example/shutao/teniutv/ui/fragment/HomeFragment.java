package com.example.shutao.teniutv.ui.fragment;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;

import com.example.shutao.teniutv.R;
import com.example.shutao.teniutv.adapter.ChannelAdapter;
import com.example.shutao.teniutv.model.entity.Channel;
import com.example.shutao.teniutv.ui.base.BaseFragment;
import com.example.shutao.teniutv.ui.base.UIUtils;
import com.example.shutao.teniutv.ui.widget.ColorTrackTabLayout;
import com.example.shutao.teniutv.ui.widget.StateView;
import com.socks.library.KLog;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;


/**
 * Created by Administrator on 2018/2/18.
 */

public class HomeFragment extends BaseFragment {


    @BindView(R.id.vp_content)
    ViewPager mViewPager;
    @BindView(R.id.tab_channel)
    ColorTrackTabLayout mTabChannel;

    private List<Channel> mSelectedChannels = new ArrayList<>();
    private List<LiveFragment> mChannelFragments = new ArrayList<>();


    @Override
    public void initData() {
        initChannelData();
        initChannelFragments();
    }

    private void initChannelData() {

/*        String[] channels = getResources().getStringArray(R.array.channel);
        String[] channelCodes = getResources().getStringArray(R.array.channel_code);
        //默认添加了全部频道
        for (int i = 0; i < channelCodes.length; i++) {
            String title = channels[i];
            String code = channelCodes[i];
            mSelectedChannels.add(new Channel(title, code));
        }*/


    }


    private void initChannelFragments() {
        KLog.e("initChannelFragments");
        String[] channelCodes = getResources().getStringArray(R.array.channel_code);
        for (Channel channel : mSelectedChannels) {
            LiveFragment newsFragment = new LiveFragment();
            Bundle bundle = new Bundle();
/*            bundle.putString(Constant.CHANNEL_CODE, channel.channelCode);
            bundle.putBoolean(Constant.IS_VIDEO_LIST, channel.channelCode.equals(channelCodes[1]));//是否是视频列表页面,根据判断频道号是否是视频
            newsFragment.setArguments(bundle);*/
            mChannelFragments.add(newsFragment);//添加到集合中
        }
    }

    @Override
    public void initListener() {
        ChannelAdapter channelAdapter = new ChannelAdapter(mChannelFragments, mSelectedChannels, getChildFragmentManager());
        mViewPager.setAdapter(channelAdapter);
        mViewPager.setOffscreenPageLimit(mSelectedChannels.size());

        mTabChannel.setTabPaddingLeftAndRight(UIUtils.dip2Px(10), UIUtils.dip2Px(10));
        mTabChannel.setupWithViewPager(mViewPager);
        mTabChannel.post(new Runnable() {
            @Override
            public void run() {
                //设置最小宽度，使其可以在滑动一部分距离
                ViewGroup slidingTabStrip = (ViewGroup) mTabChannel.getChildAt(0);
                slidingTabStrip.setMinimumWidth(slidingTabStrip.getMeasuredWidth());
            }
        });
        //隐藏指示器
        mTabChannel.setSelectedTabIndicatorHeight(0);

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


    @Override
    protected int provideContentViewId() {
        return R.layout.fragment_home;
    }
}