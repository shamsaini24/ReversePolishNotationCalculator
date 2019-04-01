package com.example.polishcalculatorwithtests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Calculator calc = new Calculator();
    private TextView display;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.digitDisplay);
    }

    public void onDigit(View view) {
        String number = ((Button) view).getText().toString();
        calc.addNumToBuffer(number);
        updateDisplay(calc.getBuffer());
        Log.d("MyApp", calc.getBuffer());
    }


    private void updateDisplay(String text) {
        boolean bufferIsNotZero = !(calc.getBuffer().equals("0") || calc.getBuffer().equals("0."));

        if (bufferIsNotZero) {
            display.setText(text);
            return;
        }
    }

    public void onClear(View view) {
        Log.d("MyApp", "Cleared " + calc.getBuffer());
        calc.clear();
        display.setText("0.0");
    }

    public void onDecimal(View view) {
        if (calc.decimal() == 1) {
            display.append(".");
        }

        updateDisplay(calc.getBuffer());
        Log.d("MyApp", calc.getBuffer());

    }

    public void onEnter(View view) {
        Log.d("MyApp", "Pushed " + calc.getBuffer() + " to stack.");
        calc.enter();
        display.setText("0.0");
    }


    public void onAdd(View view) {

        double result = calc.add();

        updateDisplay(Double.toString(result));

        Log.d("MyApp", "Pushed " + result + " to stack.");

        Log.d("MyApp", Double.toString(result));
    }

    public void onSubtract(View view) {
        double result = calc.subtract();


        updateDisplay(Double.toString(result));

        Log.d("MyApp", "Pushed " + result + " to stack.");

        Log.d("MyApp", Double.toString(result));
    }

    public void onMultiply(View view) {
        double result = calc.multiply();


        updateDisplay(Double.toString(result));

        Log.d("MyApp", "Pushed " + result + " to stack.");

        Log.d("MyApp", Double.toString(result));
    }

    public void onDivide(View view) {
        double result = calc.divide();

        updateDisplay(Double.toString(result));

        Log.d("MyApp", "Pushed " + result + " to stack.");

        Log.d("MyApp", Double.toString(result));
    }
}