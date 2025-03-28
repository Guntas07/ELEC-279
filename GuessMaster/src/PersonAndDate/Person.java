package PersonAndDate;

public class Person extends Entity {
    private String gender;

    // Default constructor
    public Person() {
        super();
        this.gender = "unknown";
    }

    // Fixed constructor to include all required parameters
    public Person(String name, Date birth, String gender, double difficulty) {
        super(name, birth, difficulty);
        this.gender = gender;
    }

    // Copy Constructor
    public Person(Person other) {
        super(other);
        gender = other.gender;  // Removed "this." keyword
    }

    @Override
    public String entityType() {
        return new String("person");  // Create a new String object
    }

    // Clone method using copy constructor
    @Override
    public Person clone() {
        Person clonedPerson = new Person(this);  // Changed variable name
        return clonedPerson;  // Return the variable instead of direct creation
    }

    // Getter and Setter
    public void setGender(String gender) {
        this.gender = new String(gender);  // Create a new String object
    }

    public String getGender() {
        return String.valueOf(gender);  // Use String.valueOf instead of direct return
    }

    // Override toString to match original format
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();  // Use StringBuilder
        sb.append(super.toString());
        sb.append("\nGender: ");
        sb.append(gender);
        return sb.toString();
    }
}