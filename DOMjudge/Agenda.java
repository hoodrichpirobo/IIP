import java.util.*;

public class Agenda {

    // Constants for the maximum number of entries and the current year.
    private static final int MAX_ENTRIES = 200;
    private static final int CURRENT_YEAR = 2020;

    // Main method where the program execution begins.
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Scanner object to read input.
        String[] agendaEntries = new String[MAX_ENTRIES]; // Array to store agenda entries.
        int entryCount = 0; // Counter for the number of entries.

        // Loop to read input until there's no more input.
        while (scanner.hasNext()) {
            String fullName = getFullName(scanner); // Get the full name from the user.
            String phone = scanner.nextLine().trim(); // Read and trim the phone number.
            String email = scanner.nextLine().trim(); // Read and trim the email.
            String birthDate = formatBirthDate(scanner.nextLine().trim()); // Format the birth date.
            int age = calculateAge(birthDate); // Calculate the age from the birth date.

            // Format the entry and add it to the agenda array.
            String formattedEntry = formatEntry(fullName, email, phone, birthDate, age);
            agendaEntries[entryCount++] = formattedEntry;
        }

        // Sort the agenda entries and print them.
        String[] sortedAgenda = sortAgenda(agendaEntries, entryCount);
        printAgenda(sortedAgenda);
    }

    // Method to get the full name by reading two lines and concatenating them.
    private static String getFullName(Scanner scanner) {
        String firstName = scanner.nextLine().trim(); // Read and trim the first name.
        String lastName = scanner.nextLine().trim(); // Read and trim the last name.
        return firstName + ", " + lastName; // Return the full name in "first, last" format.
    }

    // Method to format the birth date by replacing double spaces with a hyphen.
    private static String formatBirthDate(String birthDate) {
        return birthDate.replace("  ", "-");
    }

    // Method to calculate the age based on the birth date and the current year.
    private static int calculateAge(String birthDate) {
        // Extract year, month, and day from the birth date string.
        int yearOfBirth = Integer.parseInt(birthDate.substring(0, 4));
        int monthOfBirth = Integer.parseInt(birthDate.substring(6, 7));
        int dayOfBirth = Integer.parseInt(birthDate.substring(9, 10));

        // Calculate age based on the current date and birth date.
        if (monthOfBirth > 2 || (monthOfBirth == 2 && dayOfBirth > 20)) {
            return CURRENT_YEAR - 1 - yearOfBirth;
        } else {
            return CURRENT_YEAR - yearOfBirth;
        }
    }

    // Method to format a single agenda entry with specified width for each field.
    private static String formatEntry(String fullName, String email, String phone, String birthDate, int age) {
        return String.format("%-40s  %-30s %-12s %s  age    %s", fullName, email, phone, birthDate, age);
    }

    // Method to sort the agenda based on the provided entries and their count.
    private static String[] sortAgenda(String[] agenda, int count) {
        String[] sortedAgenda = Arrays.copyOf(agenda, count); // Copy the agenda up to the number of entries.
        Arrays.sort(sortedAgenda); // Sort the array.
        return sortedAgenda; // Return the sorted array.
    }

    // Method to print all entries in the agenda.
    private static void printAgenda(String[] agenda) {
        for (int i = 0; i < agenda.length; i++) {
            System.out.println(agenda[i]); // Print each agenda entry.
        }
    }
}
