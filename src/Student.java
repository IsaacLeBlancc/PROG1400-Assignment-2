public class Student extends Person {
    private int yearsAttended; // Number of years attended

    // Constructor to initialize student's name, address, and years attended
    public Student(String name, String address, int yearsAttended) {
        super(name, address);
        this.yearsAttended = yearsAttended;
    }

    // Getter for yearsAttended
    public int getYearsAttended() {
        return yearsAttended;
    }

    // Override toString method to provide a string representation of the student
    @Override
    public String toString() {
        return super.toString() + ", year: " + yearsAttended;
    }

    // Method to calculate student fees based on years attended
    public double calculateFees() {
        double baseFee = 3000;
        return baseFee + (100 * (yearsAttended - 1));
    }
}
