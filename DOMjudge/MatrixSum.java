import java.util.*;

public class MatrixSum {
    // Main method to start the program
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        // Continuously read input until there's none left
        while (scan.hasNext()) {
            // Read the dimensions for the first matrix
            int rows = scan.nextInt();
            int columns = scan.nextInt();
            // Read the first matrix
            int[][] a = readMatrix(rows, columns, scan);

            // Read the dimensions for the second matrix
            rows = scan.nextInt();
            columns = scan.nextInt();
            // Read the second matrix
            int[][] b = readMatrix(rows, columns, scan);

            // Check if the matrices are of the same dimensions
            if (b.length != a.length || b[0].length != a[0].length) {
                System.out.println("Impossible to add two matrices of different dimensions!");
            } else {
                // Add the matrices
                int[][] result = addMatrices(a, b);
                // Print the result
                System.out.print(print(result));
            }

        }
        // Close the scanner to prevent resource leaks
        scan.close();
    }

    // Method to read a matrix of a given size
    public static int[][] readMatrix(int rows, int columns, Scanner scan) {
        int[][] matrix = new int[rows][columns];

        // Fill the matrix with input values
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = scan.nextInt();
            }
        }

        return matrix;
    }

    // Method to add two matrices
    public static int[][] addMatrices(int[][] a, int[][] b) {
        // Initialize the sum matrix with the same dimensions
        int[][] sum = new int[a.length][a[0].length];
        // Calculate the sum of corresponding elements
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                sum[i][j] = a[i][j] + b[i][j];
            }
        }
        return sum;
    }

    // Method to format and print the matrix
    public static String print(int[][] result) {
        // Start with the dimensions of the matrix
        String out = result.length + " " + result[0].length;
        // Append each row and column to the output
        for (int i = 0; i < result.length; i++) {
            out += "\n";
            for (int j = 0; j < result[0].length; j++) {
                // Format each matrix element for aligned output
                if (j == 0) {
                    out += String.format(" %4d  ", result[i][j]);
                } else if (j == result[0].length - 1) {
                    out += String.format("%4d ", result[i][j]);
                } else {
                    out += String.format("%4d  ", result[i][j]);
                }
            }
        }
        return out;
    }
}
