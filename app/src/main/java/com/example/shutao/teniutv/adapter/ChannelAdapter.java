package com.example.shutao.teniutv.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.example.shutao.teniutv.model.entity.Channel;
import com.example.shutao.teniutv.ui.fragment.LiveFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shutao on 2018/2/24.
 */

public class ChannelAdapter extends FragmentStatePagerAdapter {

    private List<LiveFragment> mFragments;
    private List<Channel> mChannels;

    public ChannelAdapter(List<LiveFragment> fragmentList, List<Channel> channelList, FragmentManager fm) {
        super(fm);
        mFragments = fragmentList != null ? fragmentList : new ArrayList<LiveFragment>();
        mChannels = channelList != null ? channelList : new ArrayList<Channel>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mChannels.get(position).title;
    }
}
