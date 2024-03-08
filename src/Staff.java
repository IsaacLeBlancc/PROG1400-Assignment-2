public class Staff extends Person {
    private int yearsOfService;

    public Staff(String name, String address, int yearOfService) {
        super(name, address);
        this.yearsOfService = yearOfService;
    }

    public int getYearsOfService() {
        return yearsOfService;
    }

    @Override
    public String toString() {
        return super.toString() + ", Years: " + yearsOfService;
    }
}
