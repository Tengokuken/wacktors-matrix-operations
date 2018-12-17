package matrix;

import java.util.ArrayList;
// TODO: Make this non-static
public class MatrixContainer {
  private static ArrayList<Matrix> matrices = new ArrayList<Matrix>();

  public static void addMatrix(Matrix matrix) {
    // Add the matrix to storage
    matrices.add(matrix);
  }

  public static Matrix getMatrix(String matrixName) {
    for (Matrix m : matrices) {
      if (m.getMatrixName().equals(matrixName)) {
        return m;
      }
    }
    return null;
  }

  public static void removeMatrix(String matrixName) {
    // Find the amount of matrix in the filesystem
    int numFiles = matrices.size();

    // Loop through all the files
    for (int i = 0; i < numFiles; i++) {
      if (matrices.get(i).getMatrixName().equals(matrixName))
        matrices.remove(i);
    }
  }

  public static boolean isEmpty() {
    return (matrices.size() == 0);
  }
  
  public static void listMatrices() {
    
  }
}
