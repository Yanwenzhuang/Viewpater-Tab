package com.example.wechat_app.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.example.wechat_app.R;
import com.example.wechat_app.util.L;

public class TabFragment extends Fragment {
    private static final String BUNDLE_KEY_TITLE = "key_title";

    private TextView mTvTitle;
    private String mtitle;

    public static TabFragment newInstance(String title){
        Bundle bundle = new Bundle();
        bundle.putString(BUNDLE_KEY_TITLE,title);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    public interface OnTitleClickListener{
        void onClick(String title);
    }
    private OnTitleClickListener mListener;
    public void setOnTitleClickListener(OnTitleClickListener listener){
        mListener = listener;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if(arguments!=null){
            mtitle = arguments.getString(BUNDLE_KEY_TITLE,"");
        }
        Log.d("aa","1");
        L.d("onCreate,title="+mtitle);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        L.d("onCreateView,title="+mtitle);
        return inflater.inflate(R.layout.fragment_tab,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        L.d("onViewCreated,title="+mtitle);
        super.onViewCreated(view, savedInstanceState);
        mTvTitle = view.findViewById(R.id.fv_title);
        mTvTitle.setText(mtitle);
        mTvTitle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取activity对象
                if(mListener!=null){
                    mListener.onClick("微信 change!");
                }
            }
        });
    }

    @Override
    public void onDestroyView() {
        L.d("onDestroyView,title="+mtitle);
        super.onDestroyView();
    }

    @Override
    public void onDestroy() {
        L.d("onDestroy,title="+mtitle);
        super.onDestroy();
    }


    public void changeTitle(String title){
        if(!isAdded()){
            return;
        }
        mTvTitle.setText(title);
    }


}
