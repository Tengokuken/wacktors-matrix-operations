package driver;

import java.util.Scanner;
import operations.*;

public class MatrexDriver {
  // TODO: theres so much refactoring you can do here its pretty obvious like singleton!!!
  public static void main(String[] args) {
    String input;
    boolean validInput = false;
    Scanner in = new Scanner(System.in);
    while(!validInput) {
      StdOut.displayText("What matrix operations would you like to do?");
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
