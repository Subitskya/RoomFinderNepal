package com.example.roomfindernepal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = findViewById(R.id.iv_image);

        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_in);

        imageView.startAnimation(animation);

        Thread thread = new Thread(){
          @Override
          public void run(){
              try{
                  sleep(4000);

                  Intent intent = new Intent(SplashActivity.this, Login_Page.class);
              }
              catch (Exception e){

              }
              super.run();
          }
        };

        }
    }

