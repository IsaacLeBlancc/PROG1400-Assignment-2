import javax.swing.JOptionPane;
import java.util.ArrayList;

public class Accounting {
    //Function to run all the other functions and when to run them
    public void run(ArrayList<Student> students, ArrayList<Staff> staffList) {
        //Creating an array that holds the 3 different buttons for the first box
        Object[] options = {"Student", "Staff", "Finish"};
        //Show the different options to the user with the question
        int choice = JOptionPane.showOptionDialog(null, "Select Student or Staff.", "Accounting App", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);

        //loop that will run untill the finish button is pressed
        while (choice != 2) {
            //if statement to check when the first option is chosen, If yes then run the enterStudentInformation function
            if (choice == 0) {
                enterStudentInformation(students);
            //if statement to check when the second option is chosen, If yes then run the enterStaffInformation function
            } else if (choice == 1) {
                enterStaffInformation(staffList);
            }
            //reshow the options page to continue the loop with a new answer, or the same answer.
            choice = JOptionPane.showOptionDialog(null, "Select Student or Staff.", "Accounting App", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options, options[0]);
        }

        //If statement to check when the finish button has been pressed. If so it runs the runFinancialProcess function to show all the results.
        //Doesn't really need an if statement, but doesn't hurt to be safe.
        if (choice == 2) {
            runFinancialProcess(students, staffList);
        }
    }

    //function to ask for all the students info by calling to the student class
    private void enterStudentInformation(ArrayList<Student> students) {
        //Get the info from the user and save it to variables
        String name = JOptionPane.showInputDialog("Enter student name:");
        String address = JOptionPane.showInputDialog("Enter student address:");
        int year = getValidYear();

        //Create the new student using the student class with the info inputted
        Student student = new Student(name, address, year);
        //Add the student to an object for later use.
        students.add(student);
    }

    //function to ask for all the staffs info by calling to the staff class
    private void enterStaffInformation(ArrayList<Staff> staffList) {
        //Get the info from the user and save it to variables
        String name = JOptionPane.showInputDialog("Enter staff name:");
        String address = JOptionPane.showInputDialog("Enter staff address:");
        int yearsOfService = getValidYearsOfService();

        //Create the new staff using the staff class with the info inputted
        Staff staff = new Staff(name, address, yearsOfService);
        //Add the staff to an object for later use.
        staffList.add(staff);
    }

    //Function to make sure the inputed year is a valid option
    private int getValidYear() {
        //assign a blank variable to use later on
        int year;
        //While loop that runs untill a valid input is given
        while (true) {
            try {
                //Ask the user for the year/years
                year = Integer.parseInt(JOptionPane.showInputDialog("Enter student year (1-4):"));
                //If statement to make sure it's a valid input
                if (year < 1 || year > 4) {
                    throw new IllegalArgumentException();
                }
                break;
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please enter a valid number.", "Message", JOptionPane.ERROR_MESSAGE);
            } catch (IllegalArgumentException e) {
                JOptionPane.showMessageDialog(null, "Please enter a number between 1 and 4.", "Message", JOptionPane.ERROR_MESSAGE);
            }
        }
        //Return the inputed year back to the user.
        return year;
    }

    //Function to make sure the inputed year is a valid option
    private int getValidYearsOfService() {
        //assign a blank variable to use later on
        int yearsOfService;
        //While loop that runs untill a valid input is given
        while (true) {
            try {
                //Ask the user for the year/years
                yearsOfService = Integer.parseInt(JOptionPane.showInputDialog("Enter years of service:"));
                //If statement to make sure it's a valid input
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
        //Return the inputed year back to the user.
        return yearsOfService;
    }

    ///Function to run the results showing all the staff and students and financial info
    private void runFinancialProcess(ArrayList<Student> students, ArrayList<Staff> staffList) {
        //Create variables needed for later
        String studentDetails = "Students: [Total: " + students.size() + "]\n";
        double totalStudentFees = 0;
        String staffDetails = "Staff:[Total: " + staffList.size() + "]\n";
        double totalStaffSalaries = 0;

        //go over every student and calculate fees
        for (int i = 0; i < students.size(); i++) {
            Student student = students.get(i);
            double fee = student.calculateFees() / 2;
            totalStudentFees += fee;
            studentDetails += (i + 1) + ". name = " + student.getName() + ", address = " + student.getAddress() + ", year = " + student.getYearsAttended() + ", fee = $" + String.format("%.2f", fee) + "\n";
        }

        //go over every staff and calculate salaries
        for (int i = 0; i < staffList.size(); i++) {
            Staff staff = staffList.get(i);
            double salary = staff.calculateSalary() / 26;
            totalStaffSalaries += salary;
            staffDetails += (i + 1) + ". name = " + staff.getName() + ", address = " + staff.getAddress() + ", years = " + staff.getYearsOfService() + ", fee = $" + String.format("%.2f", salary) + "\n";
        }

        //Calculate total, outgoing, and incoming
        double totalOutgoing = totalStudentFees;
        double totalIncoming = totalStaffSalaries;
        double total = totalIncoming - totalOutgoing;

        //Set up the string for the result message
        String results = studentDetails + staffDetails +
                "\nResults:\n" +
                "Outgoing: $" + String.format("%.2f", totalOutgoing) + "\n" +
                "Incoming: $" + String.format("%.2f", totalIncoming) + "\n" +
                "Total: $" + String.format("%.2f", total);

        //Shows the result message
        JOptionPane.showMessageDialog(null, results, "Financial Results", JOptionPane.INFORMATION_MESSAGE);
    }
}