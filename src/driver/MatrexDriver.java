package driver;

import java.util.Scanner;
import matrix.Matrix;
import matrix.MatrixContainer;
import operations.*;

public class MatrexDriver {
  // TODO: theres so much refactoring you can do here its pretty obvious like
  // singleton!!!
  public static void main(String[] args) {
    String input;
    boolean validInput = false;
    Scanner in = new Scanner(System.in);
    while (true) {
      StdOut.displayText(
          "Select an option by entering a number\ncooresponding to the option."
              + "\n 1. Create and manage matrices.\n 2. Add matrices.\n 3. Multiply matrices."
              + "\n 4. Transpose matrices.");
      input = in.nextLine().trim();
      switch (input) {
        // TODO: Error checking and formatting
        case "1":
          validInput = false;
          while (!validInput) {
            // Create and manage matrices
            StdOut.displayText("\nWhat would you like to do?"
                + "\n 1. Create a matrix.\n 2. Delete a matrix."
                + "\n 3. List matrices.\n 4. Return to previous screen.");
            input = in.nextLine().trim();
            switch (input) {
              case "1":
                // Create a matrix
                Matrix.createNamedMatrix();
                break;
              case "2":
                // TODO: Delete a matrix from the list
                break;
              case "3":
                // List all matrices
                MatrixContainer.listMatrices();
                break;
              case "4":
                validInput = true;
                // Return to previous screen
                break;
              default:
                StdOut.displayText("hi try again\n");
                break;
            }
          }
          StdOut.displayText("");
          break;
        case "2":
          // Add matrices
          StdOut.displayText("");
          Multiply multiply = new Multiply();
          multiply.multiply();
          break;
        case "3":
          // Matrix multiplication
          break;
        case "4":
          // Transpose
          break;
        default:
          StdOut.displayText("thats not the right op pls do again\n");
          break;

      }
    }
  }
}
