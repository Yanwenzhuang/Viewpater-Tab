package com.example.wechat_app;

import android.os.PersistableBundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.example.wechat_app.adapter.TabAdapter;
import com.example.wechat_app.fragment.TabFragment;
import com.example.wechat_app.util.L;
import com.example.wechat_app.view.TabView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    final List<String> mTitle = new ArrayList<>(Arrays.asList("微信","通信录","发现","我"));
    private ViewPager vp_main;
    private TabView mTabWechat;
    private TabView mTabFriends;
    private TabView mTabFind;
    private TabView mTabMine;
    private SparseArray<TabFragment> mFragments = new SparseArray<>();
    private List<TabView> mTabs = new ArrayList<>();
    private static final String BUNDLE_KEY_POS = "bundle_key_pos";
    private int mCurTabPos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(savedInstanceState!=null){
            mCurTabPos = savedInstanceState.getInt(BUNDLE_KEY_POS,0);
        }

        initViews();
        initViewPagerAdapter();
        initEvent();

    }

    //初始化view
    public void initViews(){
        vp_main = findViewById(R.id.main_viewpager);
        mTabWechat = findViewById(R.id.tab_wechat);
        mTabFriends = findViewById(R.id.tab_friends);
        mTabFind = findViewById(R.id.tab_find);
        mTabMine = findViewById(R.id.tab_mine);

        mTabWechat.setIconAndTitle(R.drawable.wechat,R.drawable.wechat_select,"微信");
        mTabFriends.setIconAndTitle(R.drawable.friends,R.drawable.friends_select,"通信录");
        mTabFind.setIconAndTitle(R.drawable.find,R.drawable.find_select,"发现");
        mTabMine.setIconAndTitle(R.drawable.mine,R.drawable.mine_select,"我");

        mTabs.add(mTabWechat);
        mTabs.add(mTabFriends);
        mTabs.add(mTabFind);
        mTabs.add(mTabMine);
        setCurrentTab(mCurTabPos);
    }

    public void initViewPagerAdapter(){
        vp_main.setOffscreenPageLimit(mTitle.size());
        vp_main.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                TabFragment tabFragment = TabFragment.newInstance(mTitle.get(i));
                return tabFragment;
            }

            @Override
            public int getCount() {
                return mTitle.size();
            }

            @NonNull
            @Override
            public Object instantiateItem(@NonNull ViewGroup container, int position) {
                TabFragment tabFragment = (TabFragment) super.instantiateItem(container, position);
                mFragments.put(position,tabFragment);
                return tabFragment;
            }

            @Override
            public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
                mFragments.remove(position);
                super.destroyItem(container, position, object);
            }
        });
        vp_main.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

                if(v>0) {
                    TabView left = mTabs.get(i);
                    TabView right = mTabs.get(i + 1);
                    left.setProgress(1 - v);
                    right.setProgress(v);
                }

            }

            @Override
            public void onPageSelected(int i) {
                L.d("onPageSelected ="+i);
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });
    }

    //给每一个tab设置监听
    private void initEvent(){
        for (int i=0;i<mTabs.size();i++){
            TabView tabView = mTabs.get(i);
            final int finalI = i;
            tabView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    vp_main.setCurrentItem(finalI,false);
                    setCurrentTab(finalI);
                }
            });
        }
    }

    //将选中的tab设置为选中颜色
    public void setCurrentTab(int pos){
        for(int i=0;i<mTabs.size();i++){
            TabView tabView = mTabs.get(i);
            if(i==pos){
                tabView.setProgress(1);
            }else {
                tabView.setProgress(0);
            }
        }
    }

    //保留被销毁activity的信息
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(BUNDLE_KEY_POS,vp_main.getCurrentItem());
        super.onSaveInstanceState(outState);
    }
}
