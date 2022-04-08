package com.epam.tat.matrixprocessor.impl;

import com.epam.tat.matrixprocessor.IMatrixProcessor;
import com.epam.tat.matrixprocessor.exception.MatrixProcessorException;
import org.apache.commons.math3.util.Precision;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * Function Description:
 * Complete the functions below. All methods must work with matrices of the double type.
 *
 * Constraints:
 * 0 < m < 10
 * 0 < n < 10
 * where m - number of rows in matrix
 * where n - number of columns in matrix
 *
 * In case of incorrect input values or inability to perform a calculation, the method should throw an appropriate
 * exception.
 *
 */
public class MatrixProcessor implements IMatrixProcessor {
	private static final String MATRIX_NULL = "Matrix is null";
	private static final String MATRIX_LENGTH = "Matrix length is 0";
	private static final String MATRIX_WRONG = "Matrix is wrong";
	public double[][] round (double[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				matrix[i][j] = BigDecimal.valueOf(matrix[i][j]).setScale(3, RoundingMode.HALF_UP).doubleValue();
			}
		}
		return matrix;
	}


	private double [][] getMinor (double [][] matrix, int row, int column) {
		double [][] newMatrix = new double[matrix.length-1][matrix.length-1];
		int newI;
		int newJ = 0;
		for (int i = 0; i < matrix.length; i++) {
			newI = 0;
			if (i == row) {
				continue;
			}
			for (int j = 0; j < matrix.length; j++) {
				if (j == column) {
					continue;
				}
				newMatrix[newI][newJ] = matrix[i][j];
				newI++;
			}
			newJ++;
		}
		return newMatrix;
	}


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

	@Override
	public double[][] transpose(double[][] matrix) {
		if (matrix == null) {
			throw new MatrixProcessorException(MATRIX_NULL);
		}
		if (matrix.length == 0) {
			throw new MatrixProcessorException(MATRIX_LENGTH);
		}
		if (matrix.length >= 10 || matrix[0].length >= 10) {
			throw new MatrixProcessorException(MATRIX_WRONG);
		}
		double[][] transposeMatrix = new double[matrix[0].length][matrix.length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				transposeMatrix[j][i] = matrix[i][j];
			}
		}
		return transposeMatrix;
	}

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
	@Override
	public double[][] turnClockwise(double[][] matrix) {
		if (matrix == null) {
			throw new MatrixProcessorException(MATRIX_NULL);
		}
		if (matrix.length == 0) {
			throw new MatrixProcessorException(MATRIX_LENGTH);
		}
		if (matrix.length >= 10 || matrix[0].length >= 10) {
			throw new MatrixProcessorException(MATRIX_WRONG);
		}
			double[][] rotatedMatrix = new double[matrix[0].length][matrix.length];
			for (int i = 0; i < matrix.length; i++) {
				for (int j = 0; j < matrix[i].length; j++) {
					rotatedMatrix[j][matrix.length - i - 1] = matrix[i][j];
				}
			}
		return rotatedMatrix;
	}

	/**
	 * This method multiplies matrix firstMatrix by matrix secondMatrix
	 *
	 * See {https://en.wikipedia.org/wiki/Matrix_multiplication}
	 *
	 * @param firstMatrix  - first matrix to multiply
	 * @param secondMatrix - second matrix to multiply
	 * @return result matrix
	 */
	@Override
	public double[][] multiplyMatrices(double[][] firstMatrix, double[][] secondMatrix) {
		if (firstMatrix == null || secondMatrix == null ) {
			throw new MatrixProcessorException(MATRIX_NULL);
		}
		if (firstMatrix.length == 0 || secondMatrix.length == 0) {
			throw new MatrixProcessorException(MATRIX_LENGTH);
		}
		if (firstMatrix.length >= 10 || firstMatrix[0].length >= 10
				|| secondMatrix.length >= 10 || secondMatrix[0].length >= 10) {
			throw new MatrixProcessorException(MATRIX_WRONG);
		}
		if (firstMatrix[0].length != secondMatrix.length) {
			throw new MatrixProcessorException("Matrix is not compatible");
		}

		double[][] resultMatrix = new double[firstMatrix.length][secondMatrix[0].length];
		for (int i = 0; i < resultMatrix.length; i++) {
			for (int j = 0; j < resultMatrix[i].length; j++) {
				for (int k = 0; k < firstMatrix[0].length; k++) {
					resultMatrix[i][j] = resultMatrix[i][j] + firstMatrix[i][k] * secondMatrix[k][j];
				}
			}
		}
		return round(resultMatrix);
	}

	/**
	 * This method returns the inverse of the matrix
	 *
	 * See {https://en.wikipedia.org/wiki/Invertible_matrix}
	 *
	 * @param matrix - input matrix
	 * @return inverse matrix for input matrix
	 */
	@Override
	public double[][] getInverseMatrix(double[][] matrix) {
		if (matrix == null) {
			throw new MatrixProcessorException(MATRIX_NULL);
		}
		if (matrix.length == 0) {
			throw new MatrixProcessorException(MATRIX_LENGTH);
		}
		if (matrix.length >= 10 || matrix[0].length >= 10) {
			throw new MatrixProcessorException(MATRIX_WRONG);
		}
		if (matrix.length != matrix[0].length) {
			throw new MatrixProcessorException("Matrix is not square");
		}
		double determinate = getMatrixDeterminant(matrix);
		if (determinate == 0) {
			throw new MatrixProcessorException("Determinant is 0");
		}
		double[][] minorMatrix;
		minorMatrix = new double[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (i % 2 == 0 && j % 2 == 0 || i % 2 != 0 && j % 2 != 0 ) {
					minorMatrix[i][j] = getMatrixDeterminant(getMinor(matrix, i, j));
				} else {
					minorMatrix[i][j] = -getMatrixDeterminant(getMinor(matrix, i, j));
				}
			}
		}
		double[][] transposeMinorMatrix = transpose(minorMatrix);
		double[][] inverseMatrix = new double[matrix.length][matrix[0].length];
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				inverseMatrix[i][j]= transposeMinorMatrix[i][j] * 1 / determinate;
				}
			}
		return round (inverseMatrix);

	}


	/**
	 * This method returns the determinant of the matrix
	 *
	 * See {https://en.wikipedia.org/wiki/Determinant}
	 *
	 * @param matrix - input matrix
	 * @return determinant of input matrix
	 */
	@Override
	public double getMatrixDeterminant(double[][] matrix) {
		if (matrix == null) {
			throw new MatrixProcessorException(MATRIX_NULL);
		}
		if (matrix.length == 0) {
			throw new MatrixProcessorException(MATRIX_LENGTH);
		}
		if (matrix.length >= 10 || matrix[0].length >= 10) {
			throw new MatrixProcessorException(MATRIX_WRONG);
		}
		if (matrix.length != matrix[0].length) {
			throw new MatrixProcessorException("Matrix is not square");
		}
		if (matrix.length == 1) {
			return Precision.round(matrix[0][0], 3);
		}
		double determinate = 0;
		for (int j = 0; j < matrix[0].length; j++) {
			if (j % 2 == 0) {
				determinate += matrix[0][j] * getMatrixDeterminant(getMinor(matrix,0, j));
			}
			else {
				determinate += -matrix[0][j] * getMatrixDeterminant(getMinor(matrix, 0, j));
			}

		}
		return Precision.round(determinate, 3);
	}
}
