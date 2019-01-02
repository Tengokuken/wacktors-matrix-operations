package operations;

import java.util.Scanner;
import driver.StdOut;
import matrix.*;

public class Multiply {

  public void multiply() {
    Scanner in = new Scanner(System.in);
    // Create the first array
    Matrix mat1 = Matrix.createMatrix();
    // Create the second array
    // TODO: I probably can do the check earlier, before creasting the matrix.
    // But if I change it up, it may not future proof it.
    Matrix mat2 = Matrix.createMatrix();
    // Check if the matrices can be multiplied by their dimensions.
    // TODO: Check if they are like the same using a new thing
    if (canMultiply(mat1.getDims(1), mat2.getDims(0))) {
      // TODO: Think of a better solution for first and second bc i don't like
      // having this here
      mat1.populateMatrix();
      mat2.populateMatrix();

      // Create a result matrix with the correct parameters
      Matrix multMat =
          Matrix.createMatrix(mat1.getDims(0), mat2.getDims(1));
      int sum = 0;
      // Matrix multiply matrix 1 and matrix 2
      for (int i = 0; i < mat1.getDims(0); i++) {
        for (int j = 0; j < mat2.getDims(1); j++) {
          for (int k = 0; k < mat1.getDims(1); k++)
            // Find the sum of the ith row of mat1 and the jth col of mat2
            sum += mat1.getMatrixVal(i, k) * mat2.getMatrixVal(k, j);
          multMat.setMatrixVal(sum, i, j);
          sum = 0;
        }
      }
      multMat.printMatrix();
    } else
      // Print an error about the incorrect dimensions.
      StdOut.displayText("Cannot multiply an " + mat1.getDims(0) + "x"
          + mat1.getDims(1) + " with an " + mat2.getDims(0) + "x"
          + mat2.getDims(1) + "matrix.");
    // TODO: save the matrix as its own 
  }

  public boolean canMultiply(int colsMat1, int rowsMat2) {
    return colsMat1 == rowsMat2;
  }
}
