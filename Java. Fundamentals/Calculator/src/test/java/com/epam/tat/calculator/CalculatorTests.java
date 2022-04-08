package com.epam.tat.calculator;

import com.epam.tat.calculator.impl.Calculator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CalculatorTests {
    private ICalculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator(2);
    }

    @Test
    void shouldAddTwoPositiveNumbers() {
        double a = 10.1;
        double b = 6.3;
        double result = calculator.add(a, b);
        double expectedResult = 16.4;
        Assertions.assertEquals(expectedResult, result, "Wrong result of method 'add'");
    }

    @Test
    void shouldDivideTwoPositiveNumbers() {
        double a = 10.1;
        double b = 6.3;
        double result = calculator.divide(a, b);
        double expectedResult = 1.6;
        Assertions.assertEquals(expectedResult, result, "Wrong result of method 'divide'");
    }

    @Test
    void shouldMultiplyTwoPositiveNumbers() {
        double a = 10.1;
        double b = 6.3;
        double result = calculator.multiply(a, b);
        double expectedResult = 63.63;
        Assertions.assertEquals(expectedResult, result, "Wrong result of method 'multiply'");
    }

    @Test
    void shouldSubtractTwoPositiveNumbers() {
        double a = 10.1;
        double b = 6.3;
        double result = calculator.subtract(a, b);
        double expectedResult = 3.8;
        Assertions.assertEquals(expectedResult, result, "Wrong result of method 'subtract'");
    }

    @Test
    void shouldAddTwoPositiveNumbersWithTwoSymbolsPrecision() {
        double a = 10.1;
        double b = 6.354;
        double result = calculator.add(a, b);
        double expectedResult = 16.45;
        Assertions.assertEquals(expectedResult, result, "Wrong result of method 'add'");
    }
}
