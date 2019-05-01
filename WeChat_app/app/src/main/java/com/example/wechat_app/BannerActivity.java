package com.example.wechat_app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

import com.example.wechat_app.fragment.SplashFragment;
import com.example.wechat_app.view.transformer.RotateTranformer;
import com.example.wechat_app.view.transformer.ScaleTransformer;

public class BannerActivity extends AppCompatActivity {

    private ViewPager vp_main;
    private int[] mResID = new int[]{
            R.drawable.port01,
            R.drawable.port02,
            R.drawable.port03,
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner);
        vp_main = findViewById(R.id.main_viewpager);
        vp_main.setOffscreenPageLimit(2);
        vp_main.setPageMargin(40); //use  dp
        vp_main.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return mResID.length;
            }

            @Override
            public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
                return view == o;
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                View view = new View(container.getContext());
                view.setBackgroundResource(mResID[position]);
                ViewGroup.LayoutParams lp = new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                container.addView(view);
                return view;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                container.removeView((View)object);
//                super.destroyItem(container, position, object);
            }
        });
        vp_main.setPageTransformer(true,new RotateTranformer());
    }

}
