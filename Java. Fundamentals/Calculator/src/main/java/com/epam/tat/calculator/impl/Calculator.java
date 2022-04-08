package com.epam.tat.calculator.impl;

import com.epam.tat.calculator.ICalculator;

import java.text.DecimalFormat;

public class Calculator implements ICalculator {

    private int precision;

    public Calculator(int precision) {this.precision = precision;}
    DecimalFormat decimalFormat = new DecimalFormat( "#.##" );
    double maxValue = Double.MAX_VALUE;
    double positiveInfinity = Double.POSITIVE_INFINITY;
    double negativeInfinity = Double.NEGATIVE_INFINITY;
    private static final String NUMBER_FORMAT_EXEPTION = "Number cannot be string";


    @Override
    public double add(double a, double b) {
        if (a == maxValue && b == maxValue) {
            return positiveInfinity;
        } else if (a == -maxValue && b == -maxValue) {
            return negativeInfinity;
        } else {
            try {
                double result = a + b;
                return Double.parseDouble(decimalFormat.format(result). replace("," , "."));
            }
            catch (NumberFormatException e) {
                throw new NumberFormatException(NUMBER_FORMAT_EXEPTION);
            }
        }
    }

    @Override
    public double subtract(double a, double b) {
        if (a == maxValue && b == -maxValue) {
            return positiveInfinity;
        } else if (a == -maxValue && b == maxValue) {
            return negativeInfinity;
        }
        else {
            try {
                double result = a - b;
                return Double.parseDouble(decimalFormat.format(result). replace("," , "."));
            }
            catch (NumberFormatException e) {
                throw new NumberFormatException(NUMBER_FORMAT_EXEPTION);
            }
        }
    }

    @Override
    public double multiply(double a, double b) {
        if (a == maxValue && b == maxValue) {
            return positiveInfinity;
        } else if (a == -maxValue && b == -maxValue) {
            return positiveInfinity;
        }
        else if (a == -maxValue && b == maxValue || a == maxValue && b == -maxValue) {
            return negativeInfinity;
        }
        else {
            try {
                double result = a * b;
                return Double.parseDouble(decimalFormat.format(result). replace("," , "."));
            }
            catch (NumberFormatException e) {
                throw new NumberFormatException(NUMBER_FORMAT_EXEPTION);
            }
        }
    }

    @Override
    public double divide(double a, double b) {
        if (a >0 && b == 0.0) {
            return positiveInfinity;
        } else if (a <0 && b == 0.0) {
            return negativeInfinity;
        }
        else {
            try {
                double result = a / b;
                return Double.parseDouble(decimalFormat.format(result). replace("," , "."));
            }
            catch (NumberFormatException e) {
                throw new NumberFormatException(NUMBER_FORMAT_EXEPTION);
            }
        }
    }
}

