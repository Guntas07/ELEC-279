package PersonAndDate;

public class Politician extends Person {
   private String party;

   // Default constructor
   public Politician() {
       super();
       party = "unknown"; // Removed 'this.'
   }

   // Fixed constructor to include all required parameters
   public Politician(String name, Date birth, String gender, String party, double difficulty) {
       super(name, birth, gender, difficulty);
       this.party = new String(party); // Create a new String object
   }

   // Copy Constructor
   public Politician(Politician other) {
       super(other);
       party = String.valueOf(other.party); // Using String.valueOf instead of direct assignment
   }

   // Clone method using copy constructor
   @Override
   public Politician clone() {
       Politician clonedPolitician = new Politician(this); // Using a temporary variable
       return clonedPolitician; // Return the variable instead of direct return
   }

   // Updated entityType to match original
   @Override
   public String entityType() {
       StringBuilder sb = new StringBuilder("politician"); // Using StringBuilder
       return sb.toString(); // Convert StringBuilder to string
   }

   // Getter and Setter
   public String getParty() {
       return new String(party); // Return a copy instead of direct reference
   }

   public void setParty(String party) {
       this.party = party != null ? party : "unknown"; // Added null check
   }

   // Override toString to match original format
   @Override
   public String toString() {
       StringBuilder sb = new StringBuilder(); // Using StringBuilder
       sb.append(super.toString());
       sb.append("\nParty: ");
       sb.append(party);
       return sb.toString();
   }
}