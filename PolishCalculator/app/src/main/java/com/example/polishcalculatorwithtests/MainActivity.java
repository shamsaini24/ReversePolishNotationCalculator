package com.example.polishcalculatorwithtests;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private TextView display;
    private String buffer = "0";
    private ArrayList<Double> stack = new ArrayList<>(1);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        display = findViewById(R.id.digitDisplay);
    }

    public void onDigit(View view) {
        String number = ((Button) view).getText().toString();
        addNumToBuffer(number);
        updateDisplay(buffer);
        Log.d("MyApp", buffer);

    }

    private void addNumToBuffer(String data) {
        if (buffer.equals("0") || buffer.isEmpty()) {
            buffer = data;
        } else {
            buffer += data;
        }
    }

    private void updateDisplay(String text) {
        if (text.matches("([A-Z a-z])\\w+") || !((buffer.equals("0") || buffer.equals("0.")))) {
            display.setText(text);
            return;
        }
    }

    public void onClear(View view) {
        Log.d("MyApp", "Cleared " + buffer);
        buffer = "0";
        display.setText("0.0");
        stack.clear();

    }

    public void onDecimal(View view) {

        if (buffer.contains(".")) {
            return;
        } else if (buffer.startsWith("0") || buffer.isEmpty()) {
            buffer += ".";
        } else {
            buffer += ".";
            display.append(".");
        }
        updateDisplay(buffer);
        Log.d("MyApp", buffer);

    }

    public void onEnter(View view) {
        Log.d("MyApp", "Pushed " + buffer + " to stack.");

        stack.add(0, Double.parseDouble(buffer));

        Log.d("MyApp", stack.toString());

        buffer = "0";
        display.setText("0.0");
    }


    public void onAdd(View view) {
        double operand1;
        double operand2;
        double result;

        if (!buffer.isEmpty()) {
            stack.add(0, Double.parseDouble(buffer));
        }

        if (stack.size() < 2) {
            updateDisplay(getString(R.string.Error));
            return;
        }
        operand1 = stack.get(1);
        operand2 = stack.get(0);
        result = operand1 + operand2;
        stack.remove(1);
        stack.remove(0);

        buffer = "";//removes the display issue, may need to change updateDisplay logic
        stack.add(0, result);
        updateDisplay(stack.get(0).toString());

        Log.d("MyApp", "Pushed " + result + " to stack.");

        Log.d("MyApp", stack.toString());
    }

    public void onSubtract(View view) {
        double operand1;
        double operand2;
        double result;

        if (!buffer.isEmpty()) {
            stack.add(0, Double.parseDouble(buffer));
        }

        if (stack.size() < 2) {
            updateDisplay(getString(R.string.Error));
            return;
        }

        operand1 = stack.get(1);
        operand2 = stack.get(0);
        result = operand1 - operand2;
        stack.remove(1);
        stack.remove(0);

        buffer = "";//removes the display issue, may need to change updateDisplay logic
        stack.add(0, result);
        updateDisplay(stack.get(0).toString());

        Log.d("MyApp", "Pushed " + result + " to stack.");

        Log.d("MyApp", stack.toString());
    }

    public void onMultiply(View view) {
        double operand1;
        double operand2;
        double result;

        if (!buffer.isEmpty()) {
            stack.add(0, Double.parseDouble(buffer));
        }

        if (stack.size() < 2) {
            updateDisplay("Error");
            return;
        }

        operand1 = stack.get(0);
        operand2 = stack.get(1);
        result = operand1 * operand2;
        stack.remove(1);
        stack.remove(0);

        buffer = "";//removes the display issue, may need to change updateDisplay logic
        stack.add(0, result);
        updateDisplay(stack.get(0).toString());

        Log.d("MyApp", "Pushed " + result + " to stack.");

        Log.d("MyApp", stack.toString());
    }

    public void onDivide(View view) {
        double operand1;
        double operand2;
        double result;

        if (!buffer.isEmpty()) {
            stack.add(0, Double.parseDouble(buffer));
        }

        if (stack.size() < 2) {
            updateDisplay("Error");
            return;
        }

        operand1 = stack.get(1);
        operand2 = stack.get(0);
        result = operand1 / operand2;
        stack.remove(1);
        stack.remove(0);

        buffer = "";//removes the display issue, may need to change updateDisplay logic
        stack.add(0, result);
        updateDisplay(stack.get(0).toString());

        Log.d("MyApp", "Pushed " + result + " to stack.");

        Log.d("MyApp", stack.toString());
    }
}