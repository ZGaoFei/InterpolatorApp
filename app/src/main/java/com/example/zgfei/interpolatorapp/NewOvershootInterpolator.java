package com.example.zgfei.interpolatorapp;


import android.view.animation.Interpolator;

public class NewOvershootInterpolator implements Interpolator {
    private final float mTension;

    public NewOvershootInterpolator() {
        mTension = 0.3f;
    }

    public NewOvershootInterpolator(float tension) {
        mTension = tension;
    }

    @Override
    public float getInterpolation(float input) {
        return (float) (Math.pow(2, -10 * input) * Math.sin((input - mTension / 4) * (2 * Math.PI) / mTension) + 1);
    }
}
