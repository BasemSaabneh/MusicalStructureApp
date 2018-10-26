package com.devschema.sh4d0w.musicalstructureapp;

import android.content.Context;
import android.text.Layout;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

public class Animations {

    private View view;
    private Context context;
    private Animation animation;
    private float animFrom = 0.0f, animTo = 1.0f;
    private long animDuration = 1200;

    public Animations(Context context, View view) {
        this.context = context;
        this.view = view;
    }

    public void getAnimationsSlow() {
        animation = new AlphaAnimation(animFrom, animTo);
        animation.setFillAfter(true);
        animation.setDuration(animDuration);
        view.startAnimation(animation);
        animation = AnimationUtils.loadAnimation(context,R.anim.move_down_slow);
        view.startAnimation(animation);
    }

    public void getAnimationsSlide() {
        animation = new AlphaAnimation(animFrom, animTo);
        animation.setFillAfter(true);
        animation.setDuration(animDuration);
        view.startAnimation(animation);
        animation = AnimationUtils.loadAnimation(context,R.anim.move_slide_right);
        view.startAnimation(animation);
    }
}
