package com.example.zgfei.interpolatorapp;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button button;
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        button = (Button) findViewById(R.id.bt_start);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                setInterpolatorCustomer(imageView.getTranslationY(), 500);
//                setInterpolatorOne(imageView.getTranslationY(), 500);

//                testOne();
//                testTwo();
//                testThree();
//                testFour();
//                testFive();
//                testSix();
                testSeven();
            }
        });

        imageView = (ImageView) findViewById(R.id.iv_main);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "click me", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 使用系统自带的 Interpolator
     * 这里列举几个
     *
     * @param start
     * @param end
     */
    private void setInterpolatorOne(float start, float end) {
        final ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationY", start, end);
        animator.setDuration(3000);
//        animator.setInterpolator(new DecelerateInterpolator());
//        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        animator.setInterpolator(new AccelerateInterpolator());
        animator.addListener(listener);
        animator.start();
    }

    /**
     * 自定义 Interpolator
     *
     * @param start
     * @param end
     */
    private void setInterpolatorCustomer(float start, float end) {
        ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "translationY", start, end);
        animator.setDuration(3000);
        animator.setInterpolator(new NewOvershootInterpolator());
        animator.start();
    }

    private Animator.AnimatorListener listener = new Animator.AnimatorListener() {

        @Override
        public void onAnimationStart(Animator animation) {
            Log.e("==start==", "====");
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            Log.e("==end==", "====");
        }

        @Override
        public void onAnimationCancel(Animator animation) {
            Log.e("==cancel==", "====");
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
            Log.e("==repet==", "====");
        }
    };

    //============= ViewPropertyAnimator ==========

    /**
     * 透明度
     */
    private void testOne() {
        ViewPropertyAnimator animate = imageView.animate();
        animate.setDuration(2000);
        animate.alpha(0f);
        animate.start();

        // 等同于上面
//        imageView.animate().setDuration(2000).alpha(0f);
    }

    private void testTwo() {
        imageView.animate().x(500).y(500).setDuration(2000);
    }

    private void testThree() {
        imageView.animate().setDuration(2000).x(600).y(600).setInterpolator(new AccelerateInterpolator());
    }

    private void testFour() {
        imageView.animate().setDuration(2000).rotation(360);
    }

    private void testFive() {
        final ObjectAnimator animator = ObjectAnimator.ofFloat(imageView, "rotation", 0f, 180f);
        animator.setDuration(3000);
        animator.start();
    }

    private void testSix() {
        imageView.animate().x(400).y(400).scaleX(1.5f).scaleY(1.5f).setDuration(2000);
    }

    private void testSeven() {
        imageView.animate().translationX(500).translationY(500).setDuration(2000);
    }
}
