package driver;

import java.util.Scanner;
import operations.*;

public class MatrexDriver {
  // TODO: theres so much refactoring you can do here its pretty obvious like singleton!!!
  public static void main(String[] args) {
    StdOut.displayText("What matrix operations would you like to do?");
    String input;
    boolean validInput = false;
    Scanner in = new Scanner(System.in);
    while(!validInput) {
      input = in.nextLine().trim();
      if (input.equals("multiply")) {
        StdOut.displayText("");
        Multiply multiply = new Multiply();
        multiply.multiply();
      } else
        StdOut.displayText("thats not the right op pls do again");
    }

  }
}
