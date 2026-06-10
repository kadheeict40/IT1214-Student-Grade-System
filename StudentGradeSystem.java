import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeSystem {

    static ArrayList<Student> students = new ArrayList<>();

    public static void addStudent(Scanner sc) {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        System.out.print("Enter Student Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();
        sc.nextLine();

        students.add(new Student(id, name, marks));
        System.out.println("Student added successfully!");
    }

    public static void displayStudents() {
        if (students.isEmpty()) {
            System.out.println("No student records found.");
            return;
        }

        System.out.println("\nStudent Records:");
        for (Student s : students) {
            s.displayStudent();
        }
    }

    public static void searchStudent(Scanner sc) {
        System.out.print("Enter Student ID to search: ");
        String id = sc.nextLine();

        for (Student s : students) {
            if (s.getStudentId().equals(id)) {
                System.out.println("Student Found:");
                s.displayStudent();
                return;
            }
        }

        System.out.println("Student not found.");
    }

    public static void calculateAverage() {
        if (students.isEmpty()) {
            System.out.println("No records available.");
            return;
        }

        double total = 0;

        for (Student s : students) {
            total += s.getMarks();
        }

        double average = total / students.size();

        System.out.println("Average Marks: " + average);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n===== Student Grade Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search Student by ID");
            System.out.println("4. Calculate Average Marks");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    calculateAverage();
                    break;

                case 5:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }

        } while (choice != 5);

        sc.close();
    }
}