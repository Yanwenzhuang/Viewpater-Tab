package com.example.wechat_app.view.transformer;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

public class RotateTranformer implements ViewPager.PageTransformer {
    private final static int MAX_ROTATE = 15;

    // a -> b:
    //    a , position:(0,-1)
    //    b , position:(1,0)
    // b -> a:
    //    b , position:(0,1)
    //    a , position:(-1,0)
    @Override
    public void transformPage(@NonNull View view, float v) {
        if (v < -1) {
            view.setRotation(-MAX_ROTATE);
            view.setPivotX(view.getWidth());
            view.setPivotY(view.getHeight());
        } else if (v <= 1) {
            if (v < 0) {
                view.setPivotY(view.getHeight());
                //0.5w , w
                view.setPivotX(0.5f * view.getWidth() + 0.5f * (-v));
                //0  -max
                view.setRotation(MAX_ROTATE * v);
            } else {
                view.setPivotY(view.getHeight());
                //0 , 0.5w
                view.setPivotX(view.getWidth() * 0.5f * (1 - v));
                //max  0
                view.setRotation(MAX_ROTATE * v);
            }
        } else {
            view.setRotation(MAX_ROTATE);
            view.setPivotX(0);
            view.setPivotY(view.getHeight());
        }
    }
}
