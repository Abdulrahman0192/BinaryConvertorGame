package com.BinaryToDecimal.bgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private LinearLayout GameOne;
private View shine;
private TextView points;
private int result = 0, getData = 0;
private ImageView twitter_account, instagram_account;
private long onBackState = 0;



@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    getting_ID();
    social_media();
    handling_animation();
    Intent intent = getIntent();
    getData = intent.getIntExtra("points", 0);

    loadData();
    GameOne.setOnClickListener(view->{

        Intent intent1 = new Intent(MainActivity.this, MainActivity2.class);

        startActivity(intent1);


        finish();

    });

    if (getData > result) {

        UpdateData(getData);

    }//end if


}//end onCreate

private void getting_ID() {

    GameOne = findViewById(R.id.GameOne);
    points = findViewById(R.id.points);
    twitter_account = findViewById(R.id.twitter_account);
    instagram_account = findViewById(R.id.instagram_account);
    shine = findViewById(R.id.shine);


}//end method


private void loadData() {

    SharedPreferences sharedPreferences = getSharedPreferences("GAME_POINTS", MODE_PRIVATE);
    result = sharedPreferences.getInt("Highest_score", 0);
    points.setText("Highest score: " + result);

}//end method

private void UpdateData(int holder) {
    result = holder;
    points.setText("Highest score: " + result);
    SharedPreferences sharedPreferences = getSharedPreferences("GAME_POINTS", MODE_PRIVATE);

    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt("Highest_score", result);

    editor.apply();


}//end method

private void social_media() {

    Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);

    twitter_account.setOnClickListener(view->{


        twitter_account.startAnimation(animation);

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/d7om37"));

        startActivity(intent);


    });

    instagram_account.setOnClickListener(view->{

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/d7om37"));

        instagram_account.startAnimation(animation);

        startActivity(intent);


    });

}//end method

@Override
public void onBackPressed() {

    long t = System.currentTimeMillis();

    if (t - onBackState > 2000) {

        Toast.makeText(this, "Click again to exit", Toast.LENGTH_SHORT).show();

        onBackState = t;

    }//end if

    else {

        finish();

    }//end else

}//end method



private void handling_animation() {

    Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.left_right);
    shine.startAnimation(animation);
    animation.setAnimationListener(new Animation.AnimationListener() {
        @Override
        public void onAnimationStart(Animation animation) {

        }//end method

        @Override
        public void onAnimationEnd(Animation animation) {
            shine.startAnimation(animation);
        }//end method

        @Override
        public void onAnimationRepeat(Animation animation) {

        }//end method
    });


}//end method

}//end class