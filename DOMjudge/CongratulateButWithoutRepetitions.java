import java.util.*;

public class CongratulateButWithoutRepetitions {

    private static final int REFERENCE_YEAR = 2020;
    private static final int REFERENCE_MONTH = 2;
    private static final int REFERENCE_DAY = 20;
    private static final List<Month> MONTHS = initializeMonths();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numberOfContacts = Integer.parseInt(scanner.nextLine().trim());
        Set<Contact> contacts = new HashSet<>();

        while (numberOfContacts-- > 0) {
            String lastName = scanner.nextLine().trim();
            String firstName = scanner.nextLine().trim();
            String phone = scanner.nextLine().trim();
            String email = scanner.nextLine().trim();
            String birthDate = formatBirthDate(scanner.nextLine().trim());

            contacts.add(new Contact(lastName, firstName, email, phone, birthDate));
        }

        List<String> months = new ArrayList<>();
        while (scanner.hasNext()) {
            months.add(scanner.nextLine().trim());
        }

        for (String monthName : months) {
            printContactsForMonth(monthName, contacts);
        }
        scanner.close();
    }

    private static List<Month> initializeMonths() {
        List<Month> months = new ArrayList<>();
        months.add(new Month("January", 1));
        months.add(new Month("February", 2));
        months.add(new Month("March", 3));
        months.add(new Month("April", 4));
        months.add(new Month("May", 5));
        months.add(new Month("June", 6));
        months.add(new Month("July", 7));
        months.add(new Month("August", 8));
        months.add(new Month("September", 9));
        months.add(new Month("October", 10));
        months.add(new Month("November", 11));
        months.add(new Month("December", 12));
        return months;
    }

    private static void printContactsForMonth(String monthName, Set<Contact> contacts) {
        Month month = MONTHS.stream().filter(m -> m.getName().equalsIgnoreCase(monthName)).findFirst().orElse(null);
        if (month == null) {
            System.out.println("Invalid month: " + monthName);
            return;
        }

        List<Contact> filteredContacts = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getBirthMonth().equals(month.getNumber())) {
                filteredContacts.add(contact);
            }
        }

        // Sort contacts by birth month and then from youngest to oldest
        filteredContacts.sort(Comparator.comparing(Contact::getBirthMonth)
                .thenComparing(Contact::getBirthYear, Comparator.reverseOrder())
                .thenComparing(Contact::getBirthDay));

        if (filteredContacts.isEmpty()) {
            System.out.println("# No birth days for month " + monthName);
        } else {
            System.out.println("# ----------------------------------------");
            System.out.println("# Birth days for month " + monthName);
            for (Contact contact : filteredContacts) {
                System.out.println(contact);
            }
            System.out.println("# ----------------------------------------");
        }
    }

    private static String formatBirthDate(String birthDate) {
        String[] parts = birthDate.trim().split("\\s+");
        return String.join("-", parts);
    }

    private static class Month {
        private final String name;
        private final int number;

        public Month(String name, int number) {
            this.name = name;
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public int getNumber() {
            return number;
        }
    }

    private static class Contact {
        String lastName;
        String firstName;
        String email;
        String phone;
        Birthday birthday;

        public Contact(String lastName, String firstName, String email, String phone, String birthDateString) {
            this.lastName = lastName;
            this.firstName = firstName;
            this.email = email;
            this.phone = phone;
            this.birthday = new Birthday(birthDateString);
        }

        public Integer getBirthMonth() {
            return birthday.getMonth();
        }

        public Integer getBirthYear() {
            return birthday.getYear();
        }

        public Integer getBirthDay() {
            return birthday.getDay();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Contact contact = (Contact) o;
            return lastName.equals(contact.lastName) &&
                    firstName.equals(contact.firstName) &&
                    email.equals(contact.email) &&
                    phone.equals(contact.phone) &&
                    birthday.equals(contact.birthday);
        }

        @Override
        public int hashCode() {
            return Objects.hash(lastName, firstName, email, phone, birthday);
        }

        @Override
        public String toString() {
            return String.format("%-40s %-30s %-12s %s age %2d", lastName + ", " + firstName, email, phone, birthday, calculateAge(birthday.toString()));
        }
    }

    private static class Birthday {
        private final int year;
        private final int month;
        private final int day;

        public Birthday(String birthDateString) {
            String[] parts = birthDateString.split("-");
            this.year = Integer.parseInt(parts[0]);
            this.month = Integer.parseInt(parts[1]);
            this.day = Integer.parseInt(parts[2]);
        }

        public int getYear() {
            return year;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Birthday birthday = (Birthday) o;
            return year == birthday.year &&
                    month == birthday.month &&
                    day == birthday.day;
        }

        @Override
        public int hashCode() {
            return Objects.hash(year, month, day);
        }

        @Override
        public String toString() {
            return String.format("%d-%02d-%02d", year, month, day);
        }
    }

    private static int calculateAge(String birthDate) {
        String[] parts = birthDate.split("-");
        int yearOfBirth = Integer.parseInt(parts[0]);
        int monthOfBirth = Integer.parseInt(parts[1]);
        int dayOfBirth = Integer.parseInt(parts[2]);

        int age = REFERENCE_YEAR - yearOfBirth;
        if (monthOfBirth > REFERENCE_MONTH || (monthOfBirth == REFERENCE_MONTH && dayOfBirth > REFERENCE_DAY)) {
            age--;
        }
        return age;
    }
}

