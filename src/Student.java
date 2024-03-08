public class Student extends Person {
    private int yearsAttended;

    public Student(String name, String address, int yearsAttended) {
        super(name, address);
        this.yearsAttended = yearsAttended;
    }
}
