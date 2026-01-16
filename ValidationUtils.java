import java.util.Scanner;

public class ValidationUtils {

    public static int readPositiveInt(Scanner sc, String message) {
        while (true) {
            try {
                System.out.print(message);
                int value = Integer.parseInt(sc.nextLine());
                if (value > 0)
                    return value;
                System.out.println("❌ Must be a positive number.");
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid number.");
            }
        }
    }

    public static double readValidGrade(Scanner sc) {
        while (true) {
            try {
                System.out.print("Grade (0–100): ");
                double grade = Double.parseDouble(sc.nextLine());
                if (grade >= 0 && grade <= 100)
                    return grade;
                System.out.println("❌ Grade must be between 0 and 100.");
            } catch (NumberFormatException e) {
                System.out.println("❌ Invalid grade.");
            }
        }
    }
}
