import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
    private static final StudentDAO dao = new StudentDAO();

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n=== FINAL STUDENT MANAGEMENT SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Update Marks");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice;
            try {
                choice = Integer.parseInt(sc.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a number from 1 to 5.");
                continue;
            }

            try {
                switch (choice) {
                    case 1 -> addStudent();
                    case 2 -> viewStudents();
                    case 3 -> updateMarks();
                    case 4 -> deleteStudent();
                    case 5 -> {
                        System.out.println("Thank you!");
                        sc.close();
                        return;
                    }
                    default -> System.out.println("Invalid choice.");
                }
            } catch (SQLException e) {
                System.out.println("Database error: " + e.getMessage());
            }
        }
    }

    private static void addStudent() throws SQLException {
        int id = readInt("Enter Student ID: ");

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine().trim();

        if (name.isBlank()) {
            System.out.println("Name cannot be empty.");
            return;
        }

        double marks = readMarks();
        dao.addStudent(new Student(id, name, marks));
    }

    private static void viewStudents() throws SQLException {
        List<Student> students = dao.getAllStudents();

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student student : students) {
            student.displayDetails();
            System.out.println("--------------------");
        }
    }

    private static void updateMarks() throws SQLException {
        int id = readInt("Enter Student ID: ");
        double marks = readMarks();

        if (dao.updateMarks(id, marks)) {
            System.out.println("Marks updated successfully!");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    private static void deleteStudent() throws SQLException {
        int id = readInt("Enter Student ID to delete: ");

        if (dao.deleteStudent(id)) {
            System.out.println("Student deleted successfully!");
        } else {
            System.out.println("Student ID not found.");
        }
    }

    private static int readInt(String message) {
        while (true) {
            System.out.print(message);
            try {
                int value = Integer.parseInt(sc.nextLine().trim());
                if (value > 0) {
                    return value;
                }
            } catch (NumberFormatException e) {
                // Show validation message below.
            }
            System.out.println("Enter a valid positive ID.");
        }
    }

    private static double readMarks() {
        while (true) {
            System.out.print("Enter Marks (0-100): ");
            try {
                double marks = Double.parseDouble(sc.nextLine().trim());
                if (Double.isFinite(marks) && marks >= 0 && marks <= 100) {
                    return marks;
                }
            } catch (NumberFormatException e) {
                // Show validation message below.
            }
            System.out.println("Marks must be a number from 0 to 100.");
        }
    }
}