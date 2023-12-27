import java.util.*;

public class MatrixProduct{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        while(scan.hasNext()){
            int rows = scan.nextInt();
            int columns = scan.nextInt();
            int[][] a = readMatrix(rows, columns, scan);

            rows = scan.nextInt();
            columns = scan.nextInt();
            int[][] b = readMatrix(rows, columns, scan);

            // Check if matrices can be multiplied (columns of 'a' should equal rows of 'b').
            if (b.length != a[0].length){
                System.out.println("Number of columns of first matrix is not equal to the number of rows of the second one!");
            }else{
                // If they can be multiplied, calculate the product.
                int[][] result = multiplyMatrices(a,b);
                // Print the resulting matrix.
                System.out.println(print(result));
            }

        }
        scan.close();
    }

    public static int[][] readMatrix(int rows, int columns, Scanner scan){
        int[][] matrix = new int[rows][columns];

        // Reading matrix values from user input.
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                matrix[i][j] = scan.nextInt();
            }
        }

        return matrix;
    }

    public static int[][] multiplyMatrices(int[][] a, int[][] b){
        // Resultant matrix of size a's rows by b's columns.
        int[][] result = new int[a.length][b[0].length];

        // Iterate through each row of the first matrix 'a'.
        for(int i = 0; i < a.length; i++){
            // For each row of 'a', iterate through each column of the second matrix 'b'.
            for(int j = 0; j < b[0].length; j++){
                // For each element in the resultant matrix, compute the sum of products.
                for(int k = 0; k < a[0].length; k++){
                    // Multiply the elements and add to the current sum for the cell [i][j].
                    result[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        return result;
    }

    public static String print(int[][] result){
        // Building a string to represent the matrix.
        String out = result.length + " " + result[0].length;
        for(int i = 0; i < result.length; i++){
            out += "\n";
            for(int j = 0; j < result[0].length; j++){
                // Formatting each cell with proper spacing.
                if (j == 0){
                    out += String.format(" %5d  ", result[i][j]);
                }else if (j == result[0].length - 1){
                    out += String.format("%5d ", result[i][j]);
                }else{
                    out += String.format("%5d  ", result[i][j]);
                }
            }           
        }
        return out;
    }
}
