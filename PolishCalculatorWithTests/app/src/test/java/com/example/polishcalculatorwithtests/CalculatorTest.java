package com.example.polishcalculatorwithtests;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import org.apache.tools.ant.Main;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class CalculatorTest {

    @Test
    public void addition_isCorrect() {
        Calculator calc = new Calculator();
        calc.addNumToBuffer("6");
        calc.enter();
        calc.addNumToBuffer("4");
        assertThat(calc.add(), is(equalTo(10d)));

        calc.clear();

        calc.addNumToBuffer("1");
        assertThat(calc.add(), is(equalTo(Double.NaN)));

    }

    @Test
    public void subtraction_isCorrect() {
        Calculator calc = new Calculator();
        calc.addNumToBuffer("6");
        calc.enter();
        calc.addNumToBuffer("4");
        assertThat(calc.subtract(), is(equalTo(2d)));

        calc.clear();

        calc.addNumToBuffer("1");
        assertThat(calc.subtract(), is(equalTo(Double.NaN)));

    }

    @Test
    public void multiplication_isCorrect() {
        Calculator calc = new Calculator();
        calc.addNumToBuffer("6");
        calc.enter();
        calc.addNumToBuffer("4");
        assertThat(calc.add(), is(equalTo(24d)));

        calc.clear();

        calc.addNumToBuffer("1");
        assertThat(calc.add(), is(equalTo(Double.NaN)));

    }

    @Test
    public void division_isCorrect() {
        Calculator calc = new Calculator();
        calc.addNumToBuffer("1");
        calc.enter();
        calc.addNumToBuffer("5");
        assertThat(calc.divide(), is(equalTo(0.2d)));

        calc.clear();

        calc.addNumToBuffer("5");
        calc.enter();
        assertThat(calc.divide(), is(equalTo(Double.POSITIVE_INFINITY)));
    }

    @Test
    public void clear() {
        Calculator calc = new Calculator();
        calc.clear();
        assertThat(calc.getBuffer(), (is(equalTo("0"))));
        assertThat(calc.getStack().get(0), (is(equalTo(0d))));
    }

    @Test
    public void enter_WithNoInput() {
        Calculator calc = new Calculator();
        calc.enter();
        assertThat(calc.getBuffer(), (is(equalTo("0"))));
        assertThat(calc.getStack().get(0), (is(equalTo(0d))));
    }

    @Test
    public void sixSixThreeTwoSubtractAddMultiply() {
        Calculator calc = new Calculator();
        calc.addNumToBuffer("6");
        calc.enter();
        calc.addNumToBuffer("6");
        calc.enter();
        calc.addNumToBuffer("3");
        calc.enter();
        calc.addNumToBuffer("2");
        assertThat(calc.subtract(), (is(equalTo(1d))));
        assertThat(calc.add(), (is(equalTo(7d))));
        assertThat(calc.multiply(), (is(equalTo(42d))));

    }
}



