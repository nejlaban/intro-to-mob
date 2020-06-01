package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static java.lang.Double.parseDouble;

public class ConverterActivity extends AppCompatActivity {

    TextView bamScreen;
    EditText dollarScreen;
    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        bamScreen = findViewById(R.id.bam);
        dollarScreen = findViewById(R.id.dollar);
        btn = findViewById(R.id.button);
    }

    public void clicked(View view) {
        String dollar;
        dollar = dollarScreen.getText().toString();
        Double d = parseDouble(dollar);

        Double bam = d * 1.76;

        bamScreen.setText(bam.toString());
    }
}
