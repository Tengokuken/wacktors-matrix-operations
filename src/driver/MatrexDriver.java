package driver;

import java.util.Scanner;
import operations.*;

public class MatrexDriver {
  // TODO: theres so much refactoring you can do here its pretty obvious like
  // singleton!!!
  public static void main(String[] args) {
    String input;
    boolean validInput = false;
    Scanner in = new Scanner(System.in);
    while (!validInput) {
      StdOut.displayText(
          "Select an option by entering a number\ncooresponding to the option."
              + "\n 1. Set matrices.\n 2. Add matrices.\n 3. Multiply matrices."
              + " \n 4. Transpose matrices.");
      input = in.nextLine().trim();
      switch (input) {
        // TODO: Eroor checking and formatting
        case "1":
          // Set matrices
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
          StdOut.displayText("thats not the right op pls do again");
          break;

      }
    }
  }
}
