package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button addition;
    private Button subtraction;
    private Button multiplication;
    private Button division;
    private TextView info;
    private TextView result;

    private final char ADDITION = '+';
    private final char SUBTRACTION = '-';
    private final char MULTIPLICATION = '*';
    private final char DIVISION = '/';

    private double value1 = Double.NaN;    // not a number, auto number
    private double value2;  // second number is obtained from info

    private char ACTION;

    private final char EQUALS = '=';

    private Button equals;

    private Button clear;


// onCreate is the first function that is called when activity runs
// so in it I call written setupUIViews() method

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "1");
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "2");
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "3");
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "4");
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "5");
            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "6");
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "7");
            }
        });

        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "8");
            }
        });

        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "9");
            }
        });


        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                info.setText(info.getText().toString() + "0");
            }
        });

        addition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computation();
                ACTION = ADDITION;
                result.setText(String.valueOf(value1) + "+");
                info.setText(null);
            }
        });

        subtraction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computation();
                ACTION = SUBTRACTION;
                result.setText(String.valueOf(value1) + "-");
                info.setText(null);    //whenever any of operators is pressed, we need to clear the info
            }
        });

        multiplication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computation();
                ACTION = MULTIPLICATION;
                result.setText(String.valueOf(value1) + "*");
                info.setText(null);
            }
        });

        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computation();
                ACTION = DIVISION;
                result.setText(String.valueOf(value1) + "/");
                info.setText(null);
            }
        });

        equals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                computation();
                ACTION = EQUALS;
                result.setText(result.getText().toString() + String.valueOf(value2) + "=" + String.valueOf(value1));

                info.setText(null);            }
        });

        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(info.getText().length() > 0) {
                    CharSequence name = info.getText().toString();
                    info.setText(name.subSequence(0, name.length() - 1));
                } else {
                    value1 = Double.NaN;
                    value2 = Double.NaN;
                    info.setText(null);
                    result.setText(null);
                }
            }
        });

    }

    //  associating each of these variables with ids from xml layout

    protected void setupUIViews() {
        one = (Button)findViewById(R.id.bt1);
        two = (Button)findViewById(R.id.bt2);
        three = (Button)findViewById(R.id.bt3);
        four = (Button)findViewById(R.id.bt4);
        five = (Button)findViewById(R.id.bt5);
        six = (Button)findViewById(R.id.bt6);
        seven = (Button)findViewById(R.id.bt7);
        eight = (Button)findViewById(R.id.bt8);
        nine = (Button)findViewById(R.id.bt9);
        zero = (Button)findViewById(R.id.bt0);
        addition = (Button)findViewById(R.id.btAddition);
        subtraction = (Button)findViewById(R.id.btSubtraction);
        multiplication = (Button)findViewById(R.id.btMultiplication);
        division = (Button)findViewById(R.id.btDivision);
        info = (TextView)findViewById(R.id.TextViewControl);
        result = (TextView)findViewById(R.id.TextViewResult);

        equals = (Button)findViewById(R.id.btEquals);

        clear = (Button)findViewById(R.id.btClear);

    }

    private void computation() {
        if(!Double.isNaN(value1)) {
            value2 = Double.parseDouble(info.getText().toString());

            switch(ACTION) {
                case ADDITION:
                    value1 += value2;
                    break;
                case SUBTRACTION:
                    value1 -= value2;
                    break;
                case MULTIPLICATION:
                    value1 *= value2;
                    break;
                case DIVISION:
                    value1 /= value2;
                    break;
                case EQUALS :
                    break;
            }
        }
        else {
            value1 = Double.parseDouble(info.getText().toString());
        }
    }
}
