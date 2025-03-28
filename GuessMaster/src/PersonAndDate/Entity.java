package PersonAndDate;

abstract class Entity implements Cloneable {
    
    private String name;
    private Date birth;
    private Double difficulty;
    
    // Default constructor
    public Entity() {
        this.name = "ELEC292";
        this.birth = new Date();
        this.difficulty = 0.5;
    }
    
    // Parameterized constructor
    public Entity(String name, Date birth, Double difficulty) {
        this.name = name;
        this.birth = new Date(birth); // Creating a new instance to ensure encapsulation
        this.difficulty = difficulty;
    }
    
    // Copy constructor
    public Entity(Entity anotherEntity) {
        if (anotherEntity == null) {
            throw new IllegalArgumentException("Invalid entity: Cannot copy null object.");
        }
        
        this.name = anotherEntity.name;
        this.birth = new Date(anotherEntity.birth);
        this.difficulty = anotherEntity.difficulty;
    }

    // Abstract methods to be implemented by subclasses
    public abstract String entityType();
    public abstract Entity clone();
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public Date getBirth() {
        return new Date(birth); // Returns a copy to prevent direct modification
    }
    
    public void setBirth(Date birth) {
        this.birth = new Date(birth);
    }
    
    public Double getDifficulty() {
        return difficulty;
    }
    
    public void setDifficulty(Double difficulty) {
        this.difficulty = difficulty;
    }
    
    public int getAwardedTicketNumber() {
        return (int) (difficulty * 100);
    }

    public boolean equals(Entity otherEntity) {
        if (otherEntity == null) {
            return false;
        }
        return this.name.equals(otherEntity.name) && this.birth.equals(otherEntity.birth);
    }
    
    @Override
    public String toString() {
        return "Name: " + name + "\nBorn at: " + birth.toString();
    }
    
    public String welcome() {
        return "Welcome! This entity belongs to the category of: " + entityType();
    }
    
    public String close() {
        return "Great job! Here are the details of the entity you identified: \n" + this.toString();
    }
}
