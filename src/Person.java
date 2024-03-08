public abstract class Person {
    private String name;
    private String address;

    // Constructor to initialize name and address
    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Getter for address
    public String getAddress() {
        return address;
    }

    // Override toString method to provide a string representation of the person
    @Override
    public String toString() {
        return "Name: " + name + ", Address: " + address;
    }
}