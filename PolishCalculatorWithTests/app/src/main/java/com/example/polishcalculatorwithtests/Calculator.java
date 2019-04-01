package com.example.polishcalculatorwithtests;


import android.util.Log;

import java.util.ArrayList;


public class Calculator implements CalculatorInterface {

    private String buffer = "0";
    private ArrayList<Double> stack = new ArrayList<>(1);

    @Override
    public double add() {
        double operand1;
        double operand2;
        double result;

        if (!buffer.isEmpty()) {
            stack.add(0, Double.parseDouble(buffer));
        }

        if (stack.size() < 2) {
            return Double.NaN;
        }
        operand1 = stack.get(1);
        operand2 = stack.get(0);
        result = operand1 + operand2;
        stack.remove(1);
        stack.remove(0);

        buffer = "";//removes the display issue, may need to change updateDisplay logic
        stack.add(0, result);
        return result;
    }

    @Override
    public double subtract() {

        double operand1;
        double operand2;
        double result;

        if (!buffer.isEmpty()) {
            stack.add(0, Double.parseDouble(buffer));
        }

        if (stack.size() < 2) {
            return Double.NaN;
        }
        operand1 = stack.get(1);
        operand2 = stack.get(0);
        result = operand1 - operand2;
        stack.remove(1);
        stack.remove(0);

        buffer = "";//removes the display issue, may need to change updateDisplay logic
        stack.add(0, result);
        return result;
    }

    @Override
    public double multiply() {

        double operand1;
        double operand2;
        double result;

        if (!buffer.isEmpty()) {
            stack.add(0, Double.parseDouble(buffer));
        }

        if (stack.size() < 2) {
            return Double.NaN;
        }

        operand1 = stack.get(0);
        operand2 = stack.get(1);
        result = operand1 * operand2;
        stack.remove(1);
        stack.remove(0);

        buffer = "";//removes the display issue, may need to change updateDisplay logic
        stack.add(0, result);
        return result;
    }

    @Override
    public double divide() {
        double operand1;
        double operand2;
        double result;

        if (!buffer.isEmpty()) {
            stack.add(0, Double.parseDouble(buffer));
        }

        if (stack.size() < 2) {
            return Double.NaN;
        }

        operand1 = stack.get(1);
        operand2 = stack.get(0);
        result = operand1 / operand2;
        stack.remove(1);
        stack.remove(0);

        buffer = "";//removes the display issue, may need to change updateDisplay logic
        stack.add(0, result);
        return result;
    }

    public void addNumToBuffer(String data) {
        if (buffer.equals("0") || buffer.isEmpty()) {
            buffer = data;
        } else {
            buffer += data;
        }
    }

    @Override
    public int decimal() {
        if (buffer.contains(".")) {
            return 0;
        } else if (buffer.startsWith("0") || buffer.isEmpty()) {
            buffer += ".";
            return 0;
        } else {
            buffer += ".";
            return 1;
        }
    }

    @Override
    public void clear() {
        stack.clear();
        buffer = "0";
    }

    @Override
    public void enter() {
        stack.add(0, Double.parseDouble(buffer));

        Log.d("MyApp", stack.toString());

        buffer = "0";
    }

    public String getBuffer() {
        return buffer;
    }

    public ArrayList<Double> getStack() {
        return stack;
    }
}
