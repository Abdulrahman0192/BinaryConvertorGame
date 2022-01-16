package com.example.bgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


Button GameOne, GameTwo;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    GameOne = findViewById(R.id.GameOne);

    GameOne.setOnClickListener(view->{

        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        startActivity(intent);


        finish();

    });

}//end onCreate
}//end class