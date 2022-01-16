package com.example.bgame;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity2 extends AppCompatActivity {


public Button btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, submit, next;
public TextView GameNumber;
public int c1, c2, c3, c4, c5, c6, c7, c8, result;
public int Number;
public TextView counter;
public int increment = 0;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main2);
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
    counter = findViewById(R.id.counter);


    Random random = new Random();

    Number = random.nextInt(255) + 1;
    GameNumber.setText(Number+"");

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

        result = c1 + c2 + c3 + c4 + c5 + c6 + c7 + c8;

        int convert = Integer.parseInt(GameNumber.getText().toString().trim());

        if (submit.isPressed() && result == convert) {

            Toast.makeText(this, "True", Toast.LENGTH_SHORT).show();


        } else {

            Toast.makeText(this, "False", Toast.LENGTH_SHORT).show();
        }//end else
        GameMode();

    });

}//end onCreate

public void GameMode() {
    if (increment >= 9) {

        Intent intent = new Intent(MainActivity2.this, MainActivity.class);

        startActivity(intent);

        finish();

    }//end if

    else {

        next.setEnabled(true);
        submit.setEnabled(false);


        next.setOnClickListener(view->{

            if (next.isPressed()) {

                increment++;

                counter.setText(increment + "");

                submit.setEnabled(true);
                next.setEnabled(false);

                GameNumber.setText(Number+"");


                Random random1 = new Random();

                Number = random1.nextInt(255) + 1;
                GameNumber.setText(Number+"");

            }//end if


        });

    }//end else

}//end method


}//end class