package com.example.shutao.teniutv.ui.activity;

import android.os.Bundle;
import android.app.Activity;

import com.example.shutao.teniutv.R;
import com.example.shutao.teniutv.ui.base.BaseFragment;
import com.example.shutao.teniutv.ui.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {

    private List<BaseFragment> mFragments;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mFragments = new ArrayList<>(4);
        mFragments.add(new HomeFragment());


    }

/*
    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
*/

}
