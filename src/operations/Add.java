package operations;

import java.util.Scanner;
import driver.StdOut;
import matrix.Matrix;
import matrix.MatrixContainer;

public class Add {
  public void add() {
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
      // Check if they are able to add.
      // TODO: Check if they are like the same using a new thing maybe
      if (mat1.getDims(0) == mat2.getDims(0)
          && mat1.getDims(0) == mat2.getDims(0)) {
        // TODO: Think of a better solution for first and second bc i don't like
        // having this here
        mat1.populateMatrix();
        mat2.populateMatrix();
        int rows = mat1.getDims(0);
        int cols = mat1.getDims(1);
        // Create a new matrix with the same dimeensions.
        Matrix sumMatrix = Matrix.createTempMatrix(rows, cols);
        // Add the entries in the matrices and set that to the new matrix.
        for (int i = 0; i < rows; i++) {
          for (int j = 0; j < cols; j++) {
            int sumVals = mat1.getMatrixVal(i, j) + mat2.getMatrixVal(i, j);
            sumMatrix.setMatrixVal(sumVals, i, j);
          }
        }
        sumMatrix.printMatrix();
        // Ask to save the result matrix
        while (!validInput) {
          StdOut.displayText("Would you like to save this matrix? (Y/N)");
          input = in.nextLine().toUpperCase().trim();
          if (input.equals("Y")) {
            validInput = true;
            Matrix.saveMatrix(sumMatrix);
          } else if (input.equals("N")) {
            validInput = true;
          } else {
            StdOut.displayText("Please enter Y or N.");
          }
        }
      }
    }
  }
}
