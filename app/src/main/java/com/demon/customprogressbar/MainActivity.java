package com.demon.customprogressbar;

import android.app.Activity;
import android.os.Bundle;

import com.demon.customprogressbar.widget.NumberProgressBar;
import com.demon.customprogressbar.widget.RingProgressBar;

public class MainActivity extends Activity {
    private NumberProgressBar numberProgressBar;
    private int mProgress = 0;
    private RingProgressBar roundProgressBar1, roundProgressBar2, roundProgressBar3, roundProgressBar4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        numberProgressBar = findViewById(R.id.numberProgressBar);
        roundProgressBar1 = findViewById(R.id.ringProgressBar1);
        roundProgressBar2 = findViewById(R.id.ringProgressBar2);
        roundProgressBar3 = findViewById(R.id.ringProgressBar3);
        roundProgressBar4 = findViewById(R.id.ringProgressBar4);
        //模拟进度
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgress < 100) {
                    mProgress += 1;
                    numberProgressBar.setProgress(mProgress);
                    roundProgressBar1.setProgress(mProgress);
                    roundProgressBar2.setProgress(mProgress);
                    roundProgressBar3.setProgress(mProgress);
                    roundProgressBar4.setProgress(mProgress);
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
