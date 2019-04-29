package com.example.wechat_app.adapter;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.SparseArray;
import android.view.ViewGroup;
import com.example.wechat_app.fragment.TabFragment;
import java.util.List;

public class TabAdapter extends FragmentPagerAdapter {

    private List<String> mTitle;
    private SparseArray<TabFragment> mFragments;

    public TabAdapter(FragmentManager fm,List<String> mTitle,SparseArray<TabFragment> mFragments) {
        super(fm);
        this.mTitle = mTitle;
        this.mFragments = mFragments;
    }

    @Override
    public Fragment getItem(int i) {
        TabFragment tabFragment = TabFragment.newInstance(mTitle.get(i));
        if(i==0){
            tabFragment.setOnTitleClickListener(new TabFragment.OnTitleClickListener() {
                @Override
                public void onClick(String title) {

                }
            });
        }
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
}
