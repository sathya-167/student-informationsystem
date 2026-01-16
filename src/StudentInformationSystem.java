import java.util.Scanner;

public class StudentInformationSystem {

    private static Scanner sc = new Scanner(System.in);
    private static StudentManager manager = new StudentManager();

    public static void main(String[] args) {

        boolean running = true;

        while (running) {
            System.out.println("\n=== STUDENT INFORMATION SYSTEM ===");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Search Student");
            System.out.println("4. Update Student");
            System.out.println("5. Delete Student");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            String choice = sc.nextLine();

            switch (choice) {
                case "1": addStudent(); break;
                case "2": viewStudents(); break;
                case "3": searchStudent(); break;
                case "4": updateStudent(); break;
                case "5": deleteStudent(); break;
                case "6":
                    running = false;
                    System.out.println("👋 Exiting system...");
                    break;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }

    private static void addStudent() {
        System.out.print("Student ID: ");
        String id = sc.nextLine();

        System.out.print("Name: ");
        String name = sc.nextLine();

        int age = ValidationUtils.readPositiveInt(sc, "Age: ");
        double grade = ValidationUtils.readValidGrade(sc);

        System.out.print("Contact: ");
        String contact = sc.nextLine();

        manager.addStudent(new Student(id, name, age, grade, contact));
        System.out.println("✅ Student added successfully!");
    }

    private static void viewStudents() {
        if (manager.getAllStudents().isEmpty()) {
            System.out.println("⚠ No students found.");
            return;
        }

        System.out.printf("%-10s %-20s %-5s %-7s %-15s%n",
                "ID", "Name", "Age", "Grade", "Contact");
        System.out.println("-".repeat(60));

        for (Student s : manager.getAllStudents()) {
            System.out.printf("%-10s %-20s %-5d %-7.2f %-15s%n",
                    s.getStudentId(), s.getName(),
                    s.getAge(), s.getGrade(), s.getContact());
        }
    }

    private static void searchStudent() {
        System.out.print("Enter Student ID or Name: ");
        String key = sc.nextLine();

        Student s = manager.findStudent(key);
        if (s != null) {
            System.out.println("✔ Student Found");
            System.out.println("ID: " + s.getStudentId());
            System.out.println("Name: " + s.getName());
            System.out.println("Age: " + s.getAge());
            System.out.println("Grade: " + s.getGrade());
            System.out.println("Contact: " + s.getContact());
        } else {
            System.out.println("❌ Student not found.");
        }
    }

    private static void updateStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        Student s = manager.findStudent(id);
        if (s == null) {
            System.out.println("❌ Student not found.");
            return;
        }

        System.out.print("New Name: ");
        s.setName(sc.nextLine());

        s.setAge(ValidationUtils.readPositiveInt(sc, "New Age: "));
        s.setGrade(ValidationUtils.readValidGrade(sc));

        System.out.print("New Contact: ");
        s.setContact(sc.nextLine());

        System.out.println("✅ Student updated successfully!");
    }

    private static void deleteStudent() {
        System.out.print("Enter Student ID: ");
        String id = sc.nextLine();

        if (manager.deleteStudent(id))
            System.out.println("🗑 Student deleted.");
        else
            System.out.println("❌ Student not found.");
    }
}
