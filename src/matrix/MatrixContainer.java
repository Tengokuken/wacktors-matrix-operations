package matrix;

import java.util.ArrayList;

public class MatrixContainer {
  private static ArrayList<Matrix> matrices = new ArrayList<Matrix>();

  public static void addFile(Matrix matrix) {
    // Add the file to storage
    matrices.add(matrix);
  }

  /**
   * Gets a file that matches given path
   * 
   * @param desiredPath the path to get file to add
   * @return f the wanted file
   *
   */
  public static Matrix getFile(String matrixName) {
    for (Matrix m : matrices) {
      if (m.getMatrixName().equals(matrixName)) {
        return m;
      }
    }

    return null;
  }

  public static void removeFile(String matrixName) {
    // Find the amount of files in the filesystem
    int numFiles = matrices.size();

    // Loop through all the files
    for (int i = 0; i < numFiles; i++) {
      if (matrices.get(i).equals(matrixName))
        matrices.remove(i);
    }
  }

  public static boolean isEmpty() {
    return (matrices.size() == 0);
  }

}
