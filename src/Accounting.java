import javax.swing.*;

public class Accounting {
    public void run() {
        Object[] options = {"Student", "Staff", "Finish"};
        int userChoice = JOptionPane.showOptionDialog(null, "Select Student or Staff.", "Accounting App", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
    }

    private void enterStudentInformation() {

    }

    private void enterStaffInformation() {

    }

    private int getValidYear() {

    }

    private int getValidYearsOfService() {

    }
}
