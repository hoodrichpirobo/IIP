import java.util.*;

public class EquationSystems {
    // Entry point of the program.
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Continuously read input until there's none left.
        while (scanner.hasNext()) {
            int matrixSize = scanner.nextInt(); // Size of the matrix (n in an n x n matrix).
            // Initialize the upper triangular matrix from input.
            double[][] upperTriangularMatrix = initializeMatrix(scanner, matrixSize);
            // Read the constant terms of the equations.
            double[] constantTerms = readVector(scanner, matrixSize);
            // Solve the upper triangular matrix system.
            double[] solutions = solveUpperTriangularMatrix(upperTriangularMatrix, constantTerms);
            // Print the solutions to the system of equations.
            printSolutions(matrixSize, solutions);
        }
    }

    // Initializes an upper triangular matrix with the given size.
    private static double[][] initializeMatrix(Scanner scanner, int size) {
        double[][] matrix = new double[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                // Fill the matrix with input, enforcing upper triangular structure (0s below diagonal).
                matrix[i][j] = (i > j) ? 0 : scanner.nextInt();
            }
        }
        return matrix;
    }

    // Reads a vector (array) of doubles from input.
    private static double[] readVector(Scanner scanner, int size) {
        double[] vector = new double[size];
        for (int i = 0; i < size; i++) {
            // Read each element of the vector.
            vector[i] = scanner.nextInt();
        }
        return vector;
    }

    // Solves a system of linear equations represented by an upper triangular matrix.
    private static double[] solveUpperTriangularMatrix(double[][] matrix, double[] vector) {
        int size = vector.length;
        double[] solution = new double[size];
        // Start from the bottom row and work upwards.
        for (int i = size - 1; i >= 0; i--) {
            double sum = 0;
            // Sum the known values for the current variable.
            for (int j = 0; j < size - i - 1; j++) {
                sum += matrix[i][size - j - 1] * solution[size - j - 1];
            }
            // Calculate the solution for the current variable.
            solution[i] = (vector[i] - sum) / matrix[i][i];
        }
        return solution;
    }

    // Prints the solutions to the system of equations.
    private static void printSolutions(int size, double[] solutions) {
        System.out.printf("%d: ", size);
        for (int i = 0; i < size; i++) {
            // Print each solution with 5 decimal places, separated by spaces or ending with a newline.
            System.out.printf("%.5f%s", solutions[i], (i == size - 1) ? "\n" : " ");
        }
    }
}
