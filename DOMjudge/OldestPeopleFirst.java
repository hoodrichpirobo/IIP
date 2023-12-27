import java.util.*;

// Class to sort people based on their age with the oldest first.
public class OldestPeopleFirst{

    // Constants for the maximum number of entries and reference date.
    private static final int MAX_ENTRIES = 200;
    private static final int REFERENCE_YEAR = 2020;
    private static final int REFERENCE_MONTH = 2;
    private static final int REFERENCE_DAY = 20;

    public static void main(String[] args) {
        // Initialize scanner for input and list for storing contacts.
        Scanner scanner = new Scanner(System.in);
        List<Contact> contacts = new ArrayList<>();

        // Loop to read contact details until the maximum entries are reached or no more data.
        while (scanner.hasNext() && contacts.size() < MAX_ENTRIES) {
            // Read and trim inputs for each contact detail.
            String lastName = scanner.nextLine().trim();
            String firstName = scanner.nextLine().trim();
            String phone = scanner.nextLine().trim();
            String email = scanner.nextLine().trim();
            String birthDate = formatBirthDate(scanner.nextLine().trim());
            int age = calculateAge(birthDate);

            // Add new contact to the list.
            contacts.add(new Contact(lastName, firstName, email, phone, birthDate, age));
        }

        // Sort the contacts based on birthdate to get the oldest people first.
        Collections.sort(contacts, Comparator.comparing(Contact::getBirthDate));

        // Print out all contacts.
        contacts.forEach(System.out::println);
    }

    // Method to format the birthdate into a standardized format (YYYY-MM-DD).
    private static String formatBirthDate(String birthDate) {
        String[] parts = birthDate.split("\\s+");
        return String.join("-", parts);
    }

    // Method to calculate age based on birthdate and reference date.
    private static int calculateAge(String birthDate) {
        String[] parts = birthDate.split("-");
        int yearOfBirth = Integer.parseInt(parts[0]);
        int monthOfBirth = Integer.parseInt(parts[1]);
        int dayOfBirth = Integer.parseInt(parts[2]);

        // Calculate initial age.
        int age = REFERENCE_YEAR - yearOfBirth;
        // Adjust age if birthday hasn't occurred yet in the reference year.
        if (monthOfBirth > REFERENCE_MONTH || (monthOfBirth == REFERENCE_MONTH && dayOfBirth > REFERENCE_DAY)) {
            age--;
        }
        return age;
    }

    // Inner class to represent contact details.
    private static class Contact {
        String lastName;
        String firstName;
        String email;
        String phone;
        String birthDate;
        int age;

        // Constructor to initialize contact details.
        public Contact(String lastName, String firstName, String email, String phone, String birthDate, int age) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.email = email;
            this.phone = phone;
            this.birthDate = birthDate;
            this.age = age;
        }

        // Getter for birthdate, used in sorting.
        public String getBirthDate() {
            return birthDate;
        }

        // Overridden toString method for formatted contact information.
        @Override
        public String toString() {
            return String.format("%-40s %-30s %-12s %s age %2d", lastName + ", " + firstName, email, phone, birthDate, age);
        }
    }
}
