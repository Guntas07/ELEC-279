package PersonAndDate;

public class Politician extends Person {
   private String party;

   // Default constructor
   public Politician() {
       super();
       party = "unknown";
   }

   public Politician(String name, Date birth, String gender, String party, double difficulty) {
       super(name, birth, gender, difficulty);
       this.party = new String(party); 
   }

   // Copy Constructor
   public Politician(Politician other) {
       super(other);
       party = String.valueOf(other.party); 
   }

   // Clone method using copy constructor
   @Override
   public Politician clone() {
       Politician clonedPolitician = new Politician(this); 
       return clonedPolitician; 
   }

   @Override
   public String entityType() {
       StringBuilder sb = new StringBuilder("Politician"); 
       return sb.toString();
   }

   // Getter and Setter
   public String getParty() {
       return new String(party); 
   }

   public void setParty(String party) {
       this.party = party != null ? party : "unknown";
   }

   @Override
   public String toString() {
       StringBuilder sb = new StringBuilder(); 
       sb.append(super.toString());
       sb.append("\nParty: ");
       sb.append(party);
       return sb.toString();
   }
}