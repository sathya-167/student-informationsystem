
import java.util.ArrayList;

public class StudentManager {

    private ArrayList<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
    }

    public ArrayList<Student> getAllStudents() {
        return students;
    }

    public Student findStudent(String key) {
        for (Student s : students) {
            if (s.getStudentId().equalsIgnoreCase(key) ||
                s.getName().equalsIgnoreCase(key)) {
                return s;
            }
        }
        return null;
    }

    public boolean deleteStudent(String studentId) {
        Student s = findStudent(studentId);
        if (s != null) {
            students.remove(s);
            return true;
        }
        return false;
    }
}
