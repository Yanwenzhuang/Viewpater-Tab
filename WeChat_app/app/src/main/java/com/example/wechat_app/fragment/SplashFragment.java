package com.example.wechat_app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.example.wechat_app.R;

public class SplashFragment extends Fragment {
    private static final String BUNDLE_KEY_RES_ID = "bundle_key_res_id";
    private ImageView mImageView;
    private int mResID;

    public static SplashFragment newInstance(int resID){
        Bundle bundle = new Bundle();
        bundle.putInt(BUNDLE_KEY_RES_ID,resID);
        SplashFragment splashFragment = new SplashFragment();
        splashFragment.setArguments(bundle);
        return splashFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if(bundle!=null){
            mResID = bundle.getInt(BUNDLE_KEY_RES_ID);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_splash,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mImageView = view.findViewById(R.id.iv_content);
        mImageView.setImageResource(mResID);
        mImageView.setTag(mResID);
    }
}
