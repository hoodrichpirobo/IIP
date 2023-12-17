import java.util.*;

public class JedisII {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in).useLocale(Locale.US);
        char FirstChar;
        String trash = "firstTime";
        double influence = 0, force, TargetX = 0, TargetY = 0, TargetZ = 0, CoordX, CoordY, CoordZ, EucledianDistance;

        while (scan.hasNextLine()) {
            if (!scan.hasNext()) break;
            String line = scan.next();
            FirstChar = line.charAt(0);

            // Check if a new 'mortal' case starts ('t'), output the status of the previous mortal if not first time
            if (FirstChar == 't') {
                if (!trash.equals("firstTime")) {
                    printMortalStatus(TargetX, TargetY, TargetZ, influence);
                }
                trash = scan.next();
                TargetX = scan.nextDouble();
                TargetY = scan.nextDouble();
                TargetZ = scan.nextDouble();
                influence = 0;
                continue;
            }

            // Skip the next three inputs for format alignment
            trash = scan.next();
            trash = scan.next();
            trash = scan.next();

            // Additional input skip for Sith ('s') due to different format (e.g., "sith lord")
            if (FirstChar == 's') trash = scan.next();

            // Read Jedi/Sith coordinates
            CoordX = scan.nextDouble();
            CoordY = scan.nextDouble();
            CoordZ = scan.nextDouble();

            // Read Jedi/Sith force
            force = scan.nextDouble();

            // Calculate Euclidean distance between the mortal and the Jedi/Sith
            double x = CoordX - TargetX;
            double y = CoordY - TargetY;
            double z = CoordZ - TargetZ;
            EucledianDistance = Math.sqrt(x * x + y * y + z * z);

            // Update influence based on Jedi/Sith proximity and force
            // Positive influence for Jedi within range, negative for Sith
            if (FirstChar == 'j') {
                if (EucledianDistance < force) {
                    influence += force;
                }
            } else if (FirstChar == 's') {
                if (EucledianDistance < force) {
                    influence -= force;
                }
            }
        }

        // Output the status of the last mortal after processing all input lines
        printMortalStatus(TargetX, TargetY, TargetZ, influence);
    }

    // Method to print the mortal's status based on the cumulative influence
    public static void printMortalStatus(double TargetX, double TargetY, double TargetZ, double influence) {
        System.out.printf("mortal at (%.2f,%.2f,%.2f)", TargetX, TargetY, TargetZ);
        if (influence > 0) {
            System.out.println(" is protected");
        } else if (influence < 0) {
            System.out.println(" is in danger");
        } else {
            System.out.println(" is in no man's land");
        }
    }
}
