public class Staff extends Person {
    private int yearsOfService; // Number of years of service

    // Constructor to initialize staff member's name, address, and years of service
    public Staff(String name, String address, int yearOfService) {
        super(name, address);
        this.yearsOfService = yearOfService;
    }

    // Getter for yearsOfService
    public int getYearsOfService() {
        return yearsOfService;
    }

    // Override toString method to provide a string representation of the staff member
    @Override
    public String toString() {
        return super.toString() + ", Years: " + yearsOfService;
    }

    // Method to calculate staff salary based on years of service
    public double calculateSalary() {
        double baseSalary = 50000;
        double stepIncrease = 500;
        return baseSalary + (stepIncrease * yearsOfService);
    }
}
