import java.util.*;

// Class to calculate statistical measures.
public class Statistics{
    // Main method that acts as the point of entry for the program.
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in); // Scanner object to read input.
        // Initializing statistical measures to zero.
        double mean = 0, variance = 0, deviation = 0, min = 0, max = 0, median = 0, mode = 0;

        // Continuously read data until there's no more input.
        while(scan.hasNext()){
            int N = scan.nextInt(); // Number of elements in the dataset.
            int[] set = new int[N]; // Array to store the data.

            scan.nextLine(); // Consume the remaining newline character.

            // Reading data into the array.
            for(int i = 0; i < N; i++){
                int x = scan.nextInt();
                set[i] = x;
            }

            // Calculating statistical measures.
            mean = average(set); 
            variance = variance(set, mean);
            deviation = deviation(variance);
            Arrays.sort(set); // Sorting the array for median and mode calculations.
            min = min(set);
            max = max(set);
            median = median(set);
            mode = 1.0*mode(set);

            // Outputting the calculated statistics.
            System.out.println(print(mean,variance,deviation,min,max,median,mode));
        }

    }

    // Method to calculate average.
    public static double average(int[] set){
        double mean = 0;
        for(int i = 0; i < set.length; i++){
            mean += set[i];
        }
        return mean/set.length; // Returns the mean.
    }

    // Method to calculate variance.
    public static double variance(int[] set, double mean){
        double variance = 0;
        for(int i = 0; i < set.length; i++){
            variance += Math.pow(set[i] - mean, 2);
        }
        return variance/(set.length - 1); // Returns the variance using sample variance formula.
    }

    // Method to calculate standard deviation.
    public static double deviation(double variance){
        return Math.sqrt(variance); // Returns the standard deviation.
    }

    // Method to find the minimum value.
    public static int min(int[] set){
        return set[0]; // Returns the first element as the minimum (array is sorted).
    }

    // Method to find the maximum value.
    public static int max(int[] set){
        return set[set.length-1]; // Returns the last element as the maximum (array is sorted).
    }

    // Method to calculate median.
    public static double median(int[] set){
        if(set.length%2!=0){
            // For odd number of elements, return the middle element.
            return 1.0*set[(set.length-1)/2];
        }
        // For even number of elements, return the average of the two middle elements.
        int i = set.length/2;
        return 1.0*(set[i]+set[i-1])/2;
    }

    // Method to find the mode.
    public static int mode(int[] set){
        int mode = set[0]; // Current mode.
        int modeCount = 1; // Count of the current mode.
        int currentCount = 1; // Count of the current number.

        // Iterate through the array to find the mode.
        for(int i = 1; i < set.length; i++){
            if(set[i] == set[i-1]){
                currentCount++;
            } else{
                currentCount = 1; // Reset count for a new number.
            }

            // Update mode and modeCount if currentCount is greater.
            if(currentCount > modeCount){
                modeCount = currentCount;
                mode = set[i];
            }
        }
        return mode; // Return the mode.
    }

    // Method to format and print the statistical measures.
    public static String print(double average, double variance, double deviation, double min, double max, double median, double mode){
        String out = "average: " +  String.format("%.3f", average) + "\n" +
                     "variance: " + String.format("%.3f", variance) + "\n" +
                     "standard deviation: " + String.format("%.3f", deviation) + "\n" +
                     "min and max: " + String.format("%.3f", min) + " " + String.format("%.3f", max) + "\n" +
                     "median: " + String.format("%.3f", median) + "\n" +
                     "mode: " + String.format("%.3f", mode);
        return out; // Returns formatted string.
    }

}            
