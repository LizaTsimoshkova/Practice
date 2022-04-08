package com.epam.tat.matrixprocessor;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MatrixProcessorTests extends AbstractTest {

    @Test
    void shouldInverseMatrixTwoOnTwoFractionalValues() {
        double[][] inputMatrix = {{1.1, 0.3}, {-2.03, 3.67}};
        double[][] expectedMatrix = {{0.790, -0.065}, {0.437, 0.237}};
        double[][] actualMatrix = testClass.getInverseMatrix(inputMatrix);
        Assertions.assertTrue(Arrays.deepEquals(actualMatrix, expectedMatrix),
                formMessage(actualMatrix, expectedMatrix));
    }

    @Test
    void shouldMatrixDeterminantTwoOnTwoFractionalValues() {
        double[][] inputMatrix = {{1.1, 0.3}, {-2.03, 3.67}};
        double expectedDeterminant = 4.646;
        double actualDeterminant = testClass.getMatrixDeterminant(inputMatrix);
        Assertions.assertEquals(expectedDeterminant, actualDeterminant,
                formMessage(actualDeterminant, expectedDeterminant));
    }

    @Test
    void shouldMultiplyTwoSquareMatricesTwoOnTwo() {
        double[][] firstMatrix = {{1, 0}, {-2, 3}};
        double[][] secondMatrix = {{-3, 15}, {5, -7}};
        double[][] expectedMatrix = {{-3, 15}, {21, -51}};
        double[][] actualMatrix = testClass.multiplyMatrices(firstMatrix, secondMatrix);
        Assertions.assertTrue(Arrays.deepEquals(actualMatrix, expectedMatrix),
                formMessage(actualMatrix, expectedMatrix));
    }

    @Test
    void shouldMatrixOneRowTwoColumns() {
        double[][] inputMatrix = {{-3, 15}};
        double[][] expectedMatrix = {{-3}, {15}};
        double[][] actualMatrix = testClass.transpose(inputMatrix);
        Assertions.assertTrue(Arrays.deepEquals(actualMatrix, expectedMatrix),
                formMessage(actualMatrix, expectedMatrix));
    }

    @Test
    void shouldTurnMatrixOneRowTwoColumns() {
        double[][] inputMatrix = {{-3, 15}};
        double[][] expectedMatrix = {{-3}, {15}};
        double[][] actualMatrix = testClass.turnClockwise(inputMatrix);
        Assertions.assertTrue(Arrays.deepEquals(actualMatrix, expectedMatrix),
                formMessage(actualMatrix, expectedMatrix));
    }
}
