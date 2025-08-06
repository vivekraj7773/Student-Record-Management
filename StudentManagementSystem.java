import java.util.ArrayList;
import java.util.Scanner;

class Student {
    private int id;
    private String name;
    private double marks;

    public Student(int id, String name, double marks) {
        this.id = id;
        this.name = name;
        this.marks = marks;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getMarks() {
        return marks;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }

    public void display() {
        System.out.println("ID: " + id + ", Name: " + name + ", Marks: " + marks);
    }
}


public class StudentManagementSystem {

    private static ArrayList<Student> studentList = new ArrayList<>();
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;

        do {
            System.out.println("\n--- Student Record Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View All Students");
            System.out.println("3. Update Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    addStudent();
                    break;
                case 2:
                    viewStudents();
                    break;
                case 3:
                    updateStudent();
                    break;
                case 4:
                    deleteStudent();
                    break;
                case 5:
                    System.out.println("Exiting... Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        } while (choice != 5);
    }

 
    public static void addStudent() {
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine(); 
        System.out.print("Enter Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        Student s = new Student(id, name, marks);
        studentList.add(s);
        System.out.println("Student added successfully!");
    }


    public static void viewStudents() {
        if (studentList.isEmpty()) {
            System.out.println("No students found.");
        } else {
            System.out.println("Student Records:");
            for (Student s : studentList) {
                s.display();
            }
        }
    }


    public static void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        boolean found = false;

        for (Student s : studentList) {
            if (s.getId() == id) {
                sc.nextLine(); 
                System.out.print("Enter new name: ");
                String name = sc.nextLine();
                System.out.print("Enter new marks: ");
                double marks = sc.nextDouble();

                s.setName(name);
                s.setMarks(marks);
                System.out.println("Student record updated.");
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Student not found.");
        }
    }

    public static void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        boolean removed = false;

        for (int i = 0; i < studentList.size(); i++) {
            if (studentList.get(i).getId() == id) {
                studentList.remove(i);
                System.out.println("Student deleted successfully.");
                removed = true;
                break;
            }
        }

        if (!removed) {
            System.out.println("Student not found.");
        }
    }
}