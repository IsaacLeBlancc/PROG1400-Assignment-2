import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Accounting accounting = new Accounting();
        ArrayList<Student> students = new ArrayList<>();
        ArrayList<Staff> staffList = new ArrayList<>();
        accounting.run(students, staffList);
    }
}