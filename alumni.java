import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Define a class to store Alumni data
class Alumni {
    private String name;
    private String email;
    private int graduationYear;
    private String department;

    public Alumni(String name, String email, int graduationYear, String department) {
        this.name = name;
        this.email = email;
        this.graduationYear = graduationYear;
        this.department = department;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public int getGraduationYear() {
        return graduationYear;
    }

    public String getDepartment() {
        return department;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Email: " + email + ", Graduation Year: " + graduationYear + ", Department: " + department;
    }
}

// Main class to manage the Alumni database system
public class alumni {
    private static List<Alumni> alumniList = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\nAlumni Database System");
            System.out.println("1. Add Alumni");
            System.out.println("2. View All Alumni");
            System.out.println("3. Search Alumni by Name");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    addAlumni(scanner);
                    break;
                case 2:
                    viewAllAlumni();
                    break;
                case 3:
                    searchAlumni(scanner);
                    break;
                case 4:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 4);

        scanner.close();
    }

    // Method to add a new Alumni to the list
    private static void addAlumni(Scanner scanner) {
        System.out.print("Enter Name: ");
        String name = scanner.nextLine();
        System.out.print("Enter Email: ");
        String email = scanner.nextLine();
        System.out.print("Enter Graduation Year: ");
        int graduationYear = scanner.nextInt();
        scanner.nextLine();  // Consume newline
        System.out.print("Enter Department: ");
        String department = scanner.nextLine();

        Alumni alumni = new Alumni(name, email, graduationYear, department);
        alumniList.add(alumni);
        System.out.println("Alumni added successfully!");
    }

    // Method to view all Alumni in the list
    private static void viewAllAlumni() {
        if (alumniList.isEmpty()) {
            System.out.println("No alumni records found.");
        } else {
            System.out.println("Alumni Records:");
            for (Alumni alumni : alumniList) {
                System.out.println(alumni);
            }
        }
    }

    // Method to search for an Alumni by name
    private static void searchAlumni(Scanner scanner) {
        System.out.print("Enter Name to Search: ");
        String name = scanner.nextLine();
        boolean found = false;

        for (Alumni alumni : alumniList) {
            if (alumni.getName().equalsIgnoreCase(name)) {
                System.out.println(alumni);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No records found with the name: " + name);
        }
    }
}
