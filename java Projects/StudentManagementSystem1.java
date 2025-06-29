import java.util.*;

class Student {
    int roll;
    String name;
    float marks;

    public Student(int roll, String name, float marks) {
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }

    public void display() {
        System.out.println("Roll: " + roll + ", Name: " + name + ", Marks: " + marks);
    }
}

public class StudentManagementSystem1 {
    static ArrayList<Student> studentList = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    // ANSI escape codes for color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_WHITE_TEXT = "\u001B[37m";
    public static final String ANSI_GREEN_TEXT = "\u001B[32m";
    public static final String ANSI_RED_TEXT = "\u001B[31m";

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println(ANSI_BLUE_BACKGROUND + ANSI_WHITE_TEXT + "\n=== Student Management System ===" + ANSI_RESET);
            System.out.println("1. Add Student");
            System.out.println("2. Display All Students");
            System.out.println("3. Search by Roll Number");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1: addStudent(); break;
                case 2: displayStudents(); break;
                case 3: searchStudent(); break;
                case 4: deleteStudent(); break;
                case 5:
                    System.out.println(ANSI_GREEN_TEXT + "Exiting... Thank you!" + ANSI_RESET);
                    break;
                default:
                    System.out.println(ANSI_RED_TEXT + "Invalid choice!" + ANSI_RESET);
            }
        } while (choice != 5);
    }

    public static void addStudent() {
        System.out.print("Enter roll number: ");
        int roll = sc.nextInt();
        sc.nextLine(); // Clear newline
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter marks: ");
        float marks = sc.nextFloat();

        studentList.add(new Student(roll, name, marks));
        System.out.println(ANSI_GREEN_TEXT + "Student added successfully!" + ANSI_RESET);
    }

    public static void displayStudents() {
        if (studentList.isEmpty()) {
            System.out.println(ANSI_RED_TEXT + "No students to display." + ANSI_RESET);
        } else {
            System.out.println(ANSI_BLUE_BACKGROUND + ANSI_WHITE_TEXT + "--- All Students ---" + ANSI_RESET);
            for (Student s : studentList) {
                s.display();
            }
        }
    }

    public static void searchStudent() {
        System.out.print("Enter roll number to search: ");
        int roll = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.roll == roll) {
                System.out.println(ANSI_GREEN_TEXT + "Student Found:" + ANSI_RESET);
                s.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(ANSI_RED_TEXT + "Student with roll number " + roll + " not found." + ANSI_RESET);
        }
    }

    public static void deleteStudent() {
        System.out.print("Enter roll number to delete: ");
        int roll = sc.nextInt();
        Iterator<Student> iterator = studentList.iterator();
        boolean found = false;

        while (iterator.hasNext()) {
            Student s = iterator.next();
            if (s.roll == roll) {
                iterator.remove();
                System.out.println(ANSI_GREEN_TEXT + "Student deleted successfully." + ANSI_RESET);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(ANSI_RED_TEXT + "Student not found." + ANSI_RESET);
        }
    }
}
