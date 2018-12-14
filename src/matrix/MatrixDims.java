package matrix;

import java.util.Scanner;
import driver.StdOut;

public class MatrixDims {
  private int[] matDims = new int[2];

  public MatrixDims() {
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
        // Populate the array
        for (int i = 0; i < 2; i++) {
          matDims[i] = Integer.parseInt(temp[i]);
        }
      }
    }
    StdOut.displayText("");
  }
  
  public int getDims(int n) {
    return matDims[n];
  }
}
