1.Fragment.newInstance();

2.通信：
(1)Activity -> Fragment : 拿到Fragment的对象进行操作
(2)Fragment -> Activity : 换个思路...
fragment对外提供自己的核心事件回调，activity自己选择是否监听，响应。

3.屏幕旋转之后，onCreate会重新执行，getItem没有执行；

为什么会这样？

设置屏幕不旋转：清单文件  android:screenOrientation="portrait"

4.tab 自定义控件
 (1)纯绘制
 (2)组合形式
   inflate(context,R.layout.tab_view,this);
   
5.tab 变色
  0~1  -> tab

6.FragmentPagerAdapter与FragmentStatePagerAdapter的区别；
(1)FragmentPagerAdapter onDestoryView   onCreateView   (Fragment 没有被销毁 )                  
(2)FragmentStatePagerAdapter onDestoryView onDestory onCreate OnCreateView ( Fragment 被销毁了)

7.ViewPager切换动效
   核心API:setPageTransformer
  Banner切换效果
   android:clipChildren = "false";  
   setPageMargin(20);

