//Code made by Guntas Toor 20409009

package PersonAndDate;

public class Person extends Entity {
    private String gender;

    // Default constructor and other constructors
    public Person() {
        super();
        this.gender = "unknown";
    }

    public Person(String name, Date birth, String gender, double difficulty) {
        super(name, birth, difficulty);
        this.gender = gender;
    }

    public Person(Person other) {
        super(other);
        gender = other.gender;  // Removed "this." keyword
    }

    @Override
    public String entityType() {
        return new String("Person");  // Create a new String object
    }

    // Clone method using copy constructor
    @Override
    public Person clone() {
        Person clonedPerson = new Person(this);  
        return clonedPerson;  
    }

    // Getter and Setter
    public void setGender(String gender) {
        this.gender = new String(gender); 
    }

    public String getGender() {
        return String.valueOf(gender); 
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); 
        sb.append(super.toString());
        sb.append("\nGender: ");
        sb.append(gender);
        return sb.toString();
    }
}