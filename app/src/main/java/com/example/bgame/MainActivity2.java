package com.example.bgame;

import android.content.Intent;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {


private final Random random = new Random();
private Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, submit, next;
private TextView GameNumber, points, question;
private int c1;
private int c2;
private int c3;
private int c4;
private int c5;
private int c6;
private int c7;
private int c8;
private int result;
private int increment = 0;
private int checker = 0;
private int question_counter = 1;
private ImageView life1, life2, life3;
private long backBtn = 0;
private MediaPlayer mediaPlayer;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);

    getting_ID();
    GameMode();
    next.setTextColor(Color.BLACK);
    submit.setTextColor(Color.WHITE);
    next.setEnabled(false);
    submit.setEnabled(true);

    int game_start_number = random.nextInt(20) + 1;

    GameNumber.setText(String.valueOf(game_start_number));
    soundtrack();


}//end onCreate


private void getting_ID() {
    GameNumber = findViewById(R.id.GameNumber);
    next = findViewById(R.id.next);
    btn1 = findViewById(R.id.btn1);
    btn2 = findViewById(R.id.btn2);
    btn3 = findViewById(R.id.btn3);
    btn4 = findViewById(R.id.btn4);
    btn5 = findViewById(R.id.btn5);
    btn6 = findViewById(R.id.btn6);
    btn7 = findViewById(R.id.btn7);
    btn8 = findViewById(R.id.btn8);
    submit = findViewById(R.id.submit);
    life1 = findViewById(R.id.life1);
    life2 = findViewById(R.id.life2);
    life3 = findViewById(R.id.life3);
    points = findViewById(R.id.points);
    question = findViewById(R.id.question_counter);

}//end method

private void GameMode() {

    btn1.setOnClickListener(view->{

        if (btn1.isPressed() && btn1.getText().toString().equals("0")) {

            btn1.setText("1");
            c1 = 1;

            submit.setEnabled(true);

        }//end if

        else if (btn1.isPressed() && btn1.getText().toString().equals("1")) {

            btn1.setText("0");
            c1 = 0;

        }//end else if

    });

    btn2.setOnClickListener(view->{

        if (btn2.isPressed() && btn2.getText().toString().equals("0")) {

            btn2.setText("1");
            c2 = 2;
            submit.setEnabled(true);

        }//end if

        else if (btn2.isPressed() && btn2.getText().toString().equals("1")) {

            btn2.setText("0");
            c2 = 0;

        }//end else if

    });

    btn3.setOnClickListener(view->{

        if (btn3.isPressed() && btn3.getText().toString().equals("0")) {

            btn3.setText("1");
            c3 = 4;
            submit.setEnabled(true);

        }//end if

        else if (btn3.isPressed() && btn3.getText().toString().equals("1")) {

            btn3.setText("0");
            c3 = 0;
        }//end else if

    });

    btn4.setOnClickListener(view->{

        if (btn4.isPressed() && btn4.getText().toString().equals("0")) {

            btn4.setText("1");
            c4 = 8;
            submit.setEnabled(true);

        }//end if

        else if (btn4.isPressed() && btn4.getText().toString().equals("1")) {

            btn4.setText("0");
            c4 = 0;

        }//end else if

    });

    btn5.setOnClickListener(view->{

        if (btn5.isPressed() && btn5.getText().toString().equals("0")) {

            btn5.setText("1");
            c5 = 16;
            submit.setEnabled(true);

        }//end if

        else if (btn5.isPressed() && btn5.getText().toString().equals("1")) {

            btn5.setText("0");
            c5 = 0;
        }//end else if

    });

    btn6.setOnClickListener(view->{

        if (btn6.isPressed() && btn6.getText().toString().equals("0")) {

            btn6.setText("1");
            c6 = 32;
            submit.setEnabled(true);

        }//end if

        else if (btn6.isPressed() && btn6.getText().toString().equals("1")) {

            btn6.setText("0");
            c6 = 0;
        }//end else if

    });

    btn7.setOnClickListener(view->{

        if (btn7.isPressed() && btn7.getText().toString().equals("0")) {

            btn7.setText("1");
            c7 = 64;
            submit.setEnabled(true);
        }//end if

        else if (btn7.isPressed() && btn7.getText().toString().equals("1")) {

            btn7.setText("0");
            c7 = 0;
        }//end else if

    });

    btn8.setOnClickListener(view->{

        if (btn8.isPressed() && btn8.getText().toString().equals("0")) {

            btn8.setText("1");
            c8 = 128;
            submit.setEnabled(true);

        }//end if

        else if (btn8.isPressed() && btn8.getText().toString().equals("1")) {

            btn8.setText("0");
            c8 = 0;
        }//end else if

    });


    submit.setOnClickListener(view->{

        if (submit.isPressed() && btn1.getText().toString().equals("0") && btn2.getText().toString().equals("0") && btn3.getText().toString().equals("0") && btn4.getText().toString().equals("0")
                && btn5.getText().toString().equals("0") && btn6.getText().toString().equals("0") && btn7.getText().toString().equals("0") && btn8.getText().toString().equals("0")) {

            Toast.makeText(this, "There is no answer yet!!", Toast.LENGTH_SHORT).show();

        }//end if

        else {

            result = c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8;

            int convert = Integer.parseInt(GameNumber.getText().toString().trim());

            if (submit.isPressed() && result == convert) {

                Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();

                increment += 10;

                points.setText(String.valueOf(increment));

            } else {

                Toast.makeText(this, "False", Toast.LENGTH_SHORT).show();
                checker++;
                if (checker == 1) {

                    life1.setColorFilter(Color.RED);

                }//end if

                else if (checker == 2) {

                    life2.setColorFilter(Color.RED);

                }//end else

                else {

                    life3.setColorFilter(Color.RED);

                    new Thread(new Runnable() {
                        public void run() {
                            try {
                                Thread.sleep(900);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                            intent.putExtra("points", increment);
                            startActivity(intent);
                            mediaPlayer.stop();
                            finish();
                        }
                    }).start();

                }//end else


            }//end else
            GameEngine();

        }//end else

    });


}//end method

private void GameEngine() {

    next.setEnabled(true);
    submit.setEnabled(false);
    next.setTextColor(Color.WHITE);
    submit.setTextColor(Color.BLACK);
    next.setOnClickListener(view->{

        if (next.isPressed()) {

            Random random1 = new Random();

            int updater = random1.nextInt(20) + 1;

            question_counter++;
            question.setText("Question " + question_counter);

            GameNumber.setText(updater + "");

            next.setEnabled(false);
            submit.setEnabled(true);
            next.setTextColor(Color.BLACK);
            submit.setTextColor(Color.WHITE);

            btn1.setText("0");
            btn2.setText("0");
            btn3.setText("0");
            btn4.setText("0");
            btn5.setText("0");
            btn6.setText("0");
            btn7.setText("0");
            btn8.setText("0");
            c1 = 0;
            c2 = 0;
            c3 = 0;
            c4 = 0;
            c5 = 0;
            c6 = 0;
            c7 = 0;
            c8 = 0;


        }//end if

    });

}//end method

@Override
public void onBackPressed() {

    long time = System.currentTimeMillis();

    if (time - backBtn > 2000) {

        backBtn = time;

        Toast.makeText(this, "Click again to return", Toast.LENGTH_SHORT).show();

    }//end if

    else {
        Intent intent = new Intent(MainActivity2.this, MainActivity.class);
        startActivity(intent);
        mediaPlayer.stop();
        finish();

    }//end else


}//end method

private void soundtrack() {

    mediaPlayer = MediaPlayer.create(MainActivity2.this, R.raw.background_sound);
    mediaPlayer.setLooping(true);
    mediaPlayer.start();

}//end method

}//end class