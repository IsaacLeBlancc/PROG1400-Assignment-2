import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        // Initialize Accounting object
        Accounting accounting = new Accounting();
        // Create lists to store students and staff
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Staff> staffList = new ArrayList<>();
        // Run the application
        accounting.run(students, staffList);
    }
}

//Code IS DONE!