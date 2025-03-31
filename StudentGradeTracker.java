import java.util.ArrayList;
import java.util.Scanner;

class Student {
    String name;
    int id;
    ArrayList<Double> grades;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.grades = new ArrayList<>();
    }

    public void addGrade(double grade) {
        grades.add(grade);
        System.out.println("Grade added successfully for " + name);
    }

    public void viewGrades() {
        System.out.println("Grades for " + name + " (ID: " + id + "): " + grades);
    }

    public double calculateAverage() {
        if (grades.isEmpty()) return 0;
        double sum = 0;
        for (double grade : grades) {
            sum += grade;
        }
        return sum / grades.size();
    }
}

public class StudentGradeTracker {
    static ArrayList<Student> students = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nStudent Grade Tracker");
            System.out.println("1. Add Student");
            System.out.println("2. Add Grade");
            System.out.println("3. View Grades");
            System.out.println("4. Calculate Average Grade");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter student name: ");
                    scanner.nextLine(); // Consume newline
                    String name = scanner.nextLine();
                    System.out.print("Enter student ID: ");
                    int id = scanner.nextInt();
                    students.add(new Student(name, id));
                    System.out.println("Student added successfully.");
                    break;
                case 2:
                    System.out.print("Enter student ID: ");
                    int studentId = scanner.nextInt();
                    System.out.print("Enter grade: ");
                    double grade = scanner.nextDouble();
                    addGrade(studentId, grade);
                    break;
                case 3:
                    System.out.print("Enter student ID: ");
                    int viewId = scanner.nextInt();
                    viewGrades(viewId);
                    break;
                case 4:
                    System.out.print("Enter student ID: ");
                    int avgId = scanner.nextInt();
                    calculateAverage(avgId);
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

    public static void addGrade(int studentId, double grade) {
        for (Student student : students) {
            if (student.id == studentId) {
                student.addGrade(grade);
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void viewGrades(int studentId) {
        for (Student student : students) {
            if (student.id == studentId) {
                student.viewGrades();
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public static void calculateAverage(int studentId) {
        for (Student student : students) {
            if (student.id == studentId) {
                double avg = student.calculateAverage();
                System.out.println("Average grade for " + student.name + " (ID: " + student.id + ") is " + avg);
                return;
            }
        }
        System.out.println("Student not found.");
    }
}
