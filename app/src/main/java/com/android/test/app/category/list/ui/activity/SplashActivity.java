package com.android.test.app.category.list.ui.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.android.test.app.category.list.R;
import com.android.test.app.category.list.process.utils.constants.Constants;
import com.android.test.app.category.list.ui.utils.intents.IntentUtils;


/**
 * Activity Splash Screen
 *
 * @autor Fabian Hoyos
 */
public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         Activity activity=this;
        new Handler().postDelayed(() -> {
            IntentUtils.sendIntent(activity , MainActivity.class);
            finish();
        }, Constants.SPLASH_DELAY);

    }


}