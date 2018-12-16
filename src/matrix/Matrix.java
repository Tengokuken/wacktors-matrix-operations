package matrix;

import java.util.Scanner;
import driver.StdOut;

// TODO: Make this work with StdIn, this shouldnt be taking in input
// TODO: This only works for integers for now. Make it work for other things in
// the future
public class Matrix {
  private int[] matDims = new int[2];
  private int[][] matrix;

  private Matrix(int rows, int cols) {
    matDims[0] = rows;
    matDims[1] = cols;
    matrix = new int[rows][cols];
  }

  public static Matrix enterMatrixDimensions() {
    Matrix matrix = null;
    String input;
    boolean validInput = false;
    Scanner in = new Scanner(System.in);
    // Count number of spaces, max 2.
    while (!validInput) {
      input = in.nextLine().trim();
      input = input.replaceAll(" +", " ");
      if (input.length() - input.replaceAll(" ", "").length() != 1)
        StdOut.displayText("Incorrect number of dims.");
      else {
        validInput = true;
        String[] temp = input.split(" ");
        // Create the matrix with these dimensions.
        matrix =
            new Matrix(Integer.parseInt(temp[0]), Integer.parseInt(temp[1]));
      }
    }
    StdOut.displayText("");
    return matrix;
  }

  public static Matrix enterMatrixDimensions(int rows, int cols) {
    Matrix matrix = new Matrix(rows, cols);

    StdOut.displayText("");
    return matrix;
  }

  public int getDims(int n) {
    return matDims[n];
  }

  public void populateMatrix() {
    String input;
    Scanner in = new Scanner(System.in);
    // TODO: Check for columns
    for (int i = 0; i < matDims[0]; i++) {
      input = in.nextLine().trim();
      String[] temp = input.split(" ");
      // Populate the array
      for (int j = 0; j < matDims[1]; j++) {
        setMatrixVal(Integer.parseInt(temp[j]), i, j);
      }
    }
    // Add a newline
    StdOut.displayText("");
  }

  public int getMatrixVal(int i, int j) {
    return matrix[i][j];
  }

  public void setMatrixVal(int value, int i, int j) {
    matrix[i][j] = value;
  }

  public void printMatrix() {
    // Print the matrix
    // TODO: Use temp solution. Use iterator instead.
    // Store all the values in each row and store them in a string.
    String printedMatrix = "";
    // Go over each row in the matrix and store the contents.
    for (int row = 0; row < matrix.length; row++) {
      // Add a "[" character to signify the beginning of the row.
      printedMatrix += "[";
      // Go over each column in each row and store its contents.
      for (int col = 0; col < matrix.length; col++) {
        // Append <col> to <matrix> along with 1 whitespace character.
        printedMatrix += matrix[row][col];
        // If the value added was not the last entry in the row, add a comma
        // followed by a 1 space.
        if (matrix.length - col > 1) {
          printedMatrix += ", ";
        }
      }
      // Add a "]" character to signify the end of the row.
      printedMatrix += "]";
      // After the row is finished, append a newline character.
      printedMatrix += "\n";
    }
    // Print the representation of the matrix.
    StdOut.displayText("Resultant matrix is: \n" + printedMatrix + "\n");
  }
}
