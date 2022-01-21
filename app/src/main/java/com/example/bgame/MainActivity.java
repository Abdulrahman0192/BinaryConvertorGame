package com.example.bgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

private Button GameOne;
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

    twitter_account.setOnClickListener(view->{

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://twitter.com/d7om37"));

        startActivity(intent);
        finish();


    });

    instagram_account.setOnClickListener(view->{

        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://instagram.com/d7om37"));

        startActivity(intent);
        finish();


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
}//end class