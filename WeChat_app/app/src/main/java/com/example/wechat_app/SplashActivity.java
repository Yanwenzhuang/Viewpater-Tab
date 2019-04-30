package com.example.wechat_app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;

import com.example.wechat_app.R;
import com.example.wechat_app.fragment.SplashFragment;
import com.example.wechat_app.fragment.TabFragment;
import com.example.wechat_app.util.L;
import com.example.wechat_app.view.TabView;
import com.example.wechat_app.view.transformer.ScaleTransformer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private ViewPager vp_main;
    private int[] mResID = new int[]{
            R.drawable.port01,
            R.drawable.port02,
            R.drawable.port03,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        vp_main = findViewById(R.id.main_viewpager);
        vp_main.setAdapter(new FragmentStatePagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return SplashFragment.newInstance(mResID[i]);
            }

            @Override
            public int getCount() {
                return mResID.length;
            }
        });
        vp_main.setPageTransformer(false,new ScaleTransformer());
    }


}
