package operations;

import driver.StdOut;
import matrix.*;
import java.util.Scanner;

public class Multiply {

  public void multiply() {
    String input;
    boolean validInput = false;
    Scanner in = new Scanner(System.in);
    // Check if there are any premade matrices. If so, ask if the user would
    // like to use them.
    if (MatrixContainer.matrices.isEmpty()) {
      StdOut.displayText("You have no existing matrices.");
      // Create the first array
      Matrix mat1 = Matrix.createTempMatrix();
      // Create the second array
      // TODO: I probably can do the check earlier, before creasting the matrix.
      // But if I change it up, it may not future proof it.
      Matrix mat2 = Matrix.createTempMatrix();
      // Check if the matrices can be multiplied by their dimensions.
      // TODO: Check if they are like the same using a new thing
      if (canMultiply(mat1.getDims(1), mat2.getDims(0))) {
        // TODO: Think of a better solution for first and second bc i don't
        // like having this here
        mat1.populateMatrix();
        mat2.populateMatrix();
        // Create a result matrix with the correct parameters
        Matrix multMat = Matrix.createTempMatrix(mat1.getDims(0), mat2.getDims(1));
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
        // Ask to save the result matrix
        while (!validInput) {
          StdOut.displayText("Would you like to save this matrix? (Y/N)");
          input = in.nextLine().toUpperCase().trim();
          if (input.equals("Y")) {
            validInput = true;
            Matrix.saveMatrix(multMat);
          } else if (input.equals("N")) {
            validInput = true;
          } else {
            StdOut.displayText("Please enter Y or N.");
          }
        }
      } else
        // Print an error about the incorrect dimensions.
        StdOut.displayText("Cannot multiply an " + mat1.getDims(0) + "x"
            + mat1.getDims(1) + " with an " + mat2.getDims(0) + "x"
            + mat2.getDims(1) + "matrix.");
      // TODO: save the matrix as its own. Make it a function for operations
    }
  }

  public boolean canMultiply(int colsMat1, int rowsMat2) {
    return colsMat1 == rowsMat2;
  }
}
