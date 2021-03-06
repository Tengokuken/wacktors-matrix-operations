package matrix;

import java.util.Scanner;
import driver.StdOut;

// TODO: Make this work with StdIn, this shouldnt be taking in input
// TODO: This only works for integers for now. Make it work for other things in
// the future
// TODO: The adding matrix thing
public class Matrix {
  private int[] matDims = new int[2];
  private int[][] matrix;
  // TODO: Optional. Only used for saving matrices, should do something about
  // that. Maybe use a builder.
  private String matrixName;

  private Matrix(int rows, int cols) {
    matDims[0] = rows;
    matDims[1] = cols;
    matrix = new int[rows][cols];
  }

  public String getMatrixName() {
    return matrixName;
  }

  public void setMatrixName(String name) {
    this.matrixName = name;
  }

  public int getMatrixVal(int i, int j) {
    return matrix[i][j];
  }

  public void setMatrixVal(int value, int i, int j) {
    this.matrix[i][j] = value;
  }

  // TODO For the next two functions have it loop
  public static void createNamedMatrix() {
    String matName;
    Matrix matrix = null;
    Scanner in = new Scanner(System.in);
    StdOut.displayText("\nGive the matrix a variable name.");
    matName = in.nextLine().trim();
    // Check if a matrix with that same name already exists and create it if
    // there isn't an existing one with that name
    if (MatrixContainer.getMatrix(matName) == null) {
      matrix = Matrix.createMatrix();
      matrix.setMatrixName(matName);
      matrix.populateMatrix();
      StdOut.displayText("\nCreated a " + matrix.getDims(0) + "x"
          + matrix.getDims(1) + " matrix named " + matName + ".");
    } else
      StdOut.displayText("\nThere already exists a matrix with that name.\n");
  }
  
  public static Matrix createMatrix() {
    Matrix matrix = createTempMatrix();
    // Add the matrix to matrix container
    MatrixContainer.addMatrix(matrix);
    StdOut.displayText("");
    return matrix;
  }

  public static Matrix createTempMatrix() {
    Matrix matrix = null;
    String input;
    boolean validInput = false;
    Scanner in = new Scanner(System.in);
    // Count number of spaces, max 2.
    StdOut.displayText("\nEnter dimensions of your matrix. "
        + "\nLeave a space between numbers.");
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

  public static Matrix createTempMatrix(int rows, int cols) {
    Matrix matrix = new Matrix(rows, cols);
    StdOut.displayText("");
    return matrix;
  }

  public static void saveMatrix(Matrix matrix) {
    String matName;
    Scanner in = new Scanner(System.in);
    StdOut.displayText("\nGive the matrix a variable name.");
    matName = in.nextLine().trim();
    // Check if a matrix with that same name already exists and create it if
    // there isn't an existing one with that name
    if (MatrixContainer.getMatrix(matName) == null) {
      matrix.setMatrixName(matName);
      StdOut.displayText("\nSaved a " + matrix.getDims(0) + "x"
          + matrix.getDims(1) + " matrix named " + matName + ".");
      MatrixContainer.addMatrix(matrix);
    } else
      StdOut.displayText("\nThere already exists a matrix with that name.\n");
  }


  public int getDims(int n) {
    return matDims[n];
  }

  public void populateMatrix() {
    String input;
    Scanner in = new Scanner(System.in);
    StdOut.displayText(
        "Enter each row of your matrix. " + "\nPress enter after each row.");
    // TODO: Check for columns
    for (int i = 0; i < matDims[0]; i++) {
      input = in.nextLine().trim();
      String[] temp = input.split(" ");
      // Populate the array
      for (int j = 0; j < matDims[1]; j++) {
        setMatrixVal(Integer.parseInt(temp[j]), i, j);
      }
    }
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
      for (int col = 0; col < matrix[row].length; col++) {
        // Append <col> to <matrix> along with 1 whitespace character.
        printedMatrix += matrix[row][col];
        // If the value added was not the last entry in the row, add a comma
        // followed by a 1 space.
        if (matrix[row].length - col > 1) {
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

  @Override
  public String toString() {
    return ("A " + this.matDims[0] + "x" + this.matDims[1] + " matrix with"
        + " the variable name " + this.matrixName);
  }
}
