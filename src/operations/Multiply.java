package operations;

import java.util.Scanner;
import driver.StdOut;
import matrix.*;

public class Multiply {
  public void multiply() {
    String input;
    boolean validInput = false;
    Scanner in = new Scanner(System.in);
    // Create the first array
    StdOut.displayText("Enter dimensions of the first matrix."
        + "\nLeave a space between numbers.");
    MatrixDims mat1Dims = new MatrixDims();
    // Create the first array
    Matrix mat1 = new Matrix(mat1Dims.getDims(0), mat1Dims.getDims(1));
    StdOut.displayText("Enter dimensions of the second matrix."
        + "\nLeave a space between numbers.");
    // TODO: Error checking; matDims[1] and [2] should be the same
    // Create the second array
    MatrixDims mat2Dims = new MatrixDims();
    // Create the first array
    Matrix mat2 = new Matrix(mat2Dims.getDims(0), mat2Dims.getDims(1));
    // TODO: Think of a better solution for first and second bc i don't like having this here
    StdOut.displayText("Enter each row of the first matrix. "
        + "Press enter after each row.");
    mat1.populateMatrix(mat1Dims);
    StdOut.displayText("Enter each row of the second matrix. "
        + "Press enter after each row.");
    mat2.populateMatrix(mat2Dims);
    // Create a result matrix with the correct parameters
    Matrix multMat = new Matrix(mat1Dims.getDims(0), mat2Dims.getDims(1));
    int sum = 0;
    // Matrix multiply matrix 1 and matrix 2
    for (int i = 0; i < mat1Dims.getDims(0); i++) {
      for (int j = 0; j < mat2Dims.getDims(1); j++) {
        for (int k = 0; k < mat1Dims.getDims(1); k++)
          // Find the sum of the ith row of mat1 and the jth col of mat2
          sum += mat1.getMatrixVal(i, k) * mat2.getMatrixVal(k, j);
        multMat.setMatrixVal(sum, i, j);
        sum = 0;
      }
    }
    multMat.printMatrix();
  }
}
