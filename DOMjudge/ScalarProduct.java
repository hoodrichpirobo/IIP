import java.util.*;

// Defines a class named ScalarProduct.
public class ScalarProduct{
    // Main method - entry point of the program.
    public static void main(String[] args){
        // Create a new Scanner object to read input from the console.
        Scanner scan = new Scanner(System.in);

        // Continuously read data until there's no more input.
        while(scan.hasNext()){
            // Read the next integer which represents the number of elements in each vector.
            int N = scan.nextInt();
            // Initialize two arrays to hold the elements of vectors a and b.
            int[] a = new int[N], b = new int[N];

            // Loop to read vector a elements from the input.
            for(int i = 0; i < a.length; i++){
                int ai = scan.nextInt(); // Read the next integer for vector a.
                a[i] = ai; // Assign it to the array.
            }

            // Loop to read vector b elements from the input.
            for(int i = 0; i < b.length; i++){
                int bi = scan.nextInt(); // Read the next integer for vector b.
                b[i] = bi; // Assign it to the array.
            }

            // Calculate and print the scalar product of vectors a and b.
            System.out.println(product(a,b));
        }
    }

    // Method to calculate the scalar product of two vectors.
    public static int product(int[] a, int[] b){
        int v = 0; // Initialize the scalar product sum to 0.
        // Iterate over each element of the vectors.
        for(int i = 0; i < a.length; i++){
            // Multiply corresponding elements and add to the total sum.
            v += a[i]*b[i];
        }
        // Return the calculated scalar product.
        return v;
    }
}
