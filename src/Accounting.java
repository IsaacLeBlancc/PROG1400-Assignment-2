import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Accounting {
    public void run(ArrayList<Student> students, ArrayList<Staff> staffList) {
        Object[] options = {"Student", "Staff", "Finish"};
        int choice = JOptionPane.showOptionDialog(null, "Select Student or Staff.", "Accounting App", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        while (choice != 2) {
            if (choice == 0) {
                enterStudentInformation();
            } else if (choice == 1) {
                enterStaffInformation();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid option", "Error", JOptionPane.ERROR_MESSAGE);
            }

            choice = JOptionPane.showOptionDialog(null, "Select Student or Staff.", "Accounting App", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }

        if (choice == 2) {
            runFinancialProcess(students, staffList);
        }
    }

    private void enterStudentInformation() {
        String name = JOptionPane.showInputDialog("Enter student name:");
        String address = JOptionPane.showInputDialog("Enter student address:");
        int year = getValidYear();

        Student student = new Student(name, address, year);
    }

    private void enterStaffInformation() {
        String name = JOptionPane.showInputDialog("Enter staff name:");
        String address = JOptionPane.showInputDialog("Enter staff address:");
        int yearsOfService = getValidYearsOfService();

        Staff staff = new Staff(name, address, yearsOfService);
    }

    private int getValidYear() {
        int year;
        while (true) {
            try {
                year = Integer.parseInt(JOptionPane.showInputDialog("Enter student year (1-4):"));
                if (year < 1 || year > 4) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 4.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return year;
    }

    private int getValidYearsOfService() {
        int yearsOfService;
        while (true) {
            try {
                yearsOfService = Integer.parseInt(JOptionPane.showInputDialog("Enter years of service:"));
                if (yearsOfService <= 0 || yearsOfService >= 30) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 29.", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        return yearsOfService;
    }

    private void runFinancialProcess(ArrayList<Student> students, ArrayList<Staff> staffList) {
        String studentDetails = "Students: [Total: " + students.size() + "]\n";
        double totalStudentFees = 0;

        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            double fee = student.calculateFees() / 2; // Invoice for half the fee amount
            totalStudentFees += fee;
            studentDetails += (i + 1) + ". name = " + student.getName() + ", address = " + student.getAddress() + ", year = " + student.getYearsAttended() + ", fee = $" + String.format("%.2f", fee) + "\n";
        }

        String staffDetails = "Staff:[Total: " + staffList.size() + "]\n";
        double totalStaffSalaries = 0;

        for (int i = 0; i < staffList.size(); i++) {
            Staff staff = staffList.get(i);
            double salary = staff.calculateSalary() / 26; // Bi-weekly payment
            totalStaffSalaries += salary;
            staffDetails += (i + 1) + ". name = " + staff.getName() + ", address = " + staff.getAddress() + ", years = " + staff.getYearsOfService() + ", fee = $" + String.format("%.2f", salary) + "\n";
        }
    }
}
