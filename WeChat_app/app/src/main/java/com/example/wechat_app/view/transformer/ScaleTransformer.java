package com.example.wechat_app.view.transformer;

import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.example.wechat_app.util.L;

public class ScaleTransformer implements ViewPager.PageTransformer {
    private final static float MIN_SCALE = 0.75f;
    private final static float MIN_ALPHA = 0.3f;

    @Override
    public void transformPage(@NonNull View view, float v) {
        L.d(view.getTag() + ", pos=" + v);

        // a -> b:
        //    a , position:(0,-1)
        //    b , position:(1,0)
        // b -> a:
        //    b , position:(0,1)
        //    a , position:(-1,0)

        if (v < -1) {    //[,-1)
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
            view.setAlpha(MIN_ALPHA);
        } else if (v <= 1) {   //[-1,1]
            if (v < 0) {   //左边a的页面
                // a->b   position:(0,-1)   [1,0.75f]
                float scaleA = MIN_SCALE + (1 - MIN_SCALE) * (1 + v);
                view.setScaleX(scaleA);
                view.setScaleY(scaleA);
                //透明的[1,0.5f]
                float alphaA = MIN_ALPHA + (1 - MIN_ALPHA) * (1 + v);
                view.setAlpha(alphaA);


            } else {   //右边b的页面
                // a->b   position:(1,0)   [0.75f，1]
                float scaleB = MIN_SCALE + (1 - MIN_SCALE) * (1 - v);
                view.setScaleX(scaleB);
                view.setScaleY(scaleB);
                //[0.5f,1]
                float alphaB = MIN_ALPHA + (1 - MIN_ALPHA) * (1 - v);
                view.setAlpha(alphaB);

            }
        } else {     //(1,]
            view.setScaleX(MIN_SCALE);
            view.setScaleY(MIN_SCALE);
            view.setAlpha(MIN_ALPHA);
        }
    }
}
