package PersonAndDate;

public class Country extends Entity {
   private String capital;

   // Default constructor
   public Country() {
       super();
       capital = "unknown"; // Removed 'this.'
   }

   // Fixed constructor to match original
   public Country(String name, Date birth, String capital, double difficulty) {
       super(name, birth, difficulty);
       this.capital = new String(capital); // Create a new String object
   }

   // Copy constructor
   public Country(Country other) {
       super(other);
       capital = String.valueOf(other.capital); // Using String.valueOf
   }

   // Clone method using copy constructor
   @Override
   public Country clone() {
       Country clonedCountry = new Country(this); // Using a temporary variable
       return clonedCountry; // Return the variable
   }

   // Updated entityType to match original
   @Override
   public String entityType() {
       return "country".toString(); // Using toString() method
   }

   // Getter and Setter
   public String getCapital() {
       return new String(capital); // Return a copy
   }

   public void setCapital(String capital) {
       this.capital = capital != null ? capital : "unknown"; // Added null check
   }

   // Override toString to match original format
   @Override
   public String toString() {
       StringBuilder result = new StringBuilder(); // Using StringBuilder
       result.append(super.toString());
       result.append("\nCapital: ");
       result.append(capital);
       return result.toString();
   }
}