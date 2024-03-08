public class Student extends Person {
    private int yearsAttended;

    public Student(String name, String address, int yearsAttended) {
        super(name, address);
        this.yearsAttended = yearsAttended;
    }

    public int getYearsAttended() {
        return yearsAttended;
    }

    @Override
    public String toString() {
        return super.toString() + ", year: " + yearsAttended;
    }

    public double calculateFees() {
        double baseFee = 3000;
        return baseFee + (100 * (yearsAttended - 1));
    }
}
