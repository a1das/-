package com.example.download.adapter;

import android.app.Activity;
import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.example.download.R;

public class PageChange  implements ViewPager.OnPageChangeListener {
    private ImageView indicator = null;
    public int currentIndex = 0;
    private int width;
    private TranslateAnimation transAnima;
    DisplayMetrics dms;
    public PageChange(DisplayMetrics dms,ImageView indicator){
        this.dms=dms;
        width = dms.widthPixels / 2;
        this.indicator = indicator;
    }
    @Override
    public void onPageSelected(int arg0) {
        initAnimation(arg0);
    }

    @Override
    public void onPageScrolled(int arg0, float arg1, int arg2) {
    }

    @Override
    public void onPageScrollStateChanged(int arg0) {
    }
    public void initAnimation(int moveto){
        transAnima = new TranslateAnimation(currentIndex * width, moveto * width, 0, 0);
        transAnima.setFillAfter(true);
        transAnima.setDuration(200);
        indicator.startAnimation(transAnima);
        currentIndex = moveto;
    }
}

