package com.example.celsiusafarenheit;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;


public class MainActivity extends AppCompatActivity {

    private Button mCelsiusConvertButton;
    private Button mFahrenheitConvertButton;
    private EditText mAnswer;
    private TextView mTextResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Asigna id con los botones
        mCelsiusConvertButton = findViewById(R.id.convertCtoF_button);
        mFahrenheitConvertButton = findViewById(R.id.convertFtoC_button);
        mTextResult = findViewById(R.id.textViewConv);

        //Funcion para mostrar resultados en Celsius cuando se presiona su boton
        mCelsiusConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DecimalFormat dformat = new DecimalFormat();
                dformat.setMaximumFractionDigits(2);
                //Asigna id del textview y lo pasa de string a numero
                mAnswer = findViewById(R.id.editText);
                final double temperature = Double.parseDouble(mAnswer.getText().toString());
                double msgFahrenheit;
                msgFahrenheit = (int) (temperature * 1.8) + 32;
                mTextResult.setText(dformat.format(msgFahrenheit) + "°F");
            }


        });

        //Funcion para mostrar resultados en Fahrenheit cuando se presiona su boton
        mFahrenheitConvertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                DecimalFormat dformat = new DecimalFormat();
                dformat.setMaximumFractionDigits(2);
                //Asigna id del textview y lo pasa de string a numero
                mAnswer = findViewById(R.id.editText);
                final double temperature = Double.parseDouble(mAnswer.getText().toString());
                double msgCelsius;
                msgCelsius = (int)(temperature - 32) / 1.8;
                mTextResult.setText(dformat.format(msgCelsius) + "°C");
            }


        });
    }
}
