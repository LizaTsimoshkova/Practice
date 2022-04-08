package com.epam.tat.matrixprocessor;

/**
 * Function Description:
 * Complete the functions below. All methods must work with matrices of the double type.
 * <p>
 * Constraints:
 * 0 < m < 10
 * 0 < n < 10
 * where m - number of rows in matrix
 * where n - number of columns in matrix
 * <p>
 * In case of incorrect input values or inability to perform a calculation, the method should throw an appropriate
 * exception.
 * <p>
 */
public interface IMatrixProcessor {

    /**
     * Matrix transpose is an operation on a matrix where its rows become columns with the same numbers.
     * Ex.:
     * |1 2|			|1 3 5|
     * |3 4|   ====>	|2 4 6|
     * |5 6|
     *
     * @param matrix - matrix for transposition
     * @return the transposed matrix
     */
    double[][] transpose(double[][] matrix);

    /**
     * The method flips the matrix clockwise.
     * Ex.:
     * * |1 2|			|5 3 1|
     * * |3 4|   ====>	|6 4 2|
     * * |5 6|
     *
     * @param matrix - rotation matrix
     * @return rotated matrix
     */
    double[][] turnClockwise(double[][] matrix);

    /**
     * This method multiplies matrix firstMatrix by matrix secondMatrix
     * <p>
     * See {https://en.wikipedia.org/wiki/Matrix_multiplication}
     *
     * @param firstMatrix  - first matrix to multiply
     * @param secondMatrix - second matrix to multiply
     * @return result matrix
     */
    double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix);

    /**
     * This method returns the inverse of the matrix
     * <p>
     * See {https://en.wikipedia.org/wiki/Invertible_matrix}
     *
     * @param matrix - input matrix
     * @return inverse matrix for input matrix
     */
    double[][] getInverseMatrix(double[][] matrix);

    /**
     * This method returns the determinant of the matrix
     * <p>
     * See {https://en.wikipedia.org/wiki/Determinant}
     *
     * @param matrix - input matrix
     * @return determinant of input matrix
     */
    double getMatrixDeterminant(double[][] matrix);
}
