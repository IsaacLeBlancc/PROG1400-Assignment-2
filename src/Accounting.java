import javax.swing.JOptionPane;

public class Accounting {
    public void run() {
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
            runFinancialProcess();
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

                }
                break;
            } catch () {

            } catch () {

            }
        }
        return year;
    }

    private int getValidYearsOfService() {

    }

    private void runFinancialProcess() {
        // Perform financial calculations here
        // Output the results in a JOptionPane or any other desired way
    }
}
