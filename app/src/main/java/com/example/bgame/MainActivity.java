package com.example.bgame;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


Button GameOne;

TextView points;
int result = 0;

int getData = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    Intent intent = getIntent();
    getData = intent.getIntExtra("points", 0);
    GameOne = findViewById(R.id.GameOne);
    points = findViewById(R.id.points);
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

public void loadData() {

    SharedPreferences sharedPreferences = getSharedPreferences("GAME_POINTS", MODE_PRIVATE);
    result = sharedPreferences.getInt("Highest_score", 0);
    points.setText("Highest score: " + result);

}//end method

public void UpdateData(int holder) {
    result = holder;
    points.setText("Highest score: " + result);
    SharedPreferences sharedPreferences = getSharedPreferences("GAME_POINTS", MODE_PRIVATE);

    SharedPreferences.Editor editor = sharedPreferences.edit();
    editor.putInt("Highest_score",result);

    editor.apply();


}//end method


}//end class