import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    addStudent(sc);
                    break;

                case 2:
                    viewStudents();
                    break;

                case 3:
                    searchStudent(sc);
                    break;

                case 4:
                    deleteStudent(sc);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    return;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }

    static void addStudent(Scanner sc) {

        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        students.add(new Student(id, name, course));

        System.out.println("Student Added Successfully!");
    }

    static void viewStudents() {

        if (students.isEmpty()) {
            System.out.println("No students found.");
            return;
        }

        for (Student s : students) {
            s.displayStudent();
        }
    }

    static void searchStudent(Scanner sc) {

        System.out.print("Enter Student ID: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {
                s.displayStudent();
                return;
            }
        }

        System.out.println("Student Not Found.");
    }

    static void deleteStudent(Scanner sc) {

        System.out.print("Enter Student ID to Delete: ");
        int id = sc.nextInt();

        for (Student s : students) {

            if (s.getId() == id) {
                students.remove(s);
                System.out.println("Student Deleted Successfully!");
                return;
            }
        }

        System.out.println("Student Not Found.");
    }
}