package PersonAndDate;

public class Singer extends Person {
    private String debutAlbum;
    private Date debutAlbumReleaseDate; // Changed to use the custom Date class instead of java.util.Date

    // Default constructor
    public Singer() {
        super();
        debutAlbum = "unknown"; // Removed 'this.'
        debutAlbumReleaseDate = new Date(); // Removed 'this.'
    }

    // Fixed constructor to include all required parameters
    public Singer(String name, Date birth, String gender, String debutAlbum, Date debutAlbumReleaseDate, double difficulty) {
        super(name, birth, gender, difficulty);
        this.debutAlbum = new String(debutAlbum); // Create a new String object
        // Ensure we use the copy constructor as in the original code
        this.debutAlbumReleaseDate = new Date(debutAlbumReleaseDate); 
    }

    // Copy Constructor
    public Singer(Singer other) {
        super(other);
        debutAlbum = String.valueOf(other.debutAlbum); // Using String.valueOf
        // Ensure we use the copy constructor as in the original code
        debutAlbumReleaseDate = new Date(other.debutAlbumReleaseDate); 
    }

    // Clone method using copy constructor
    @Override
    public Singer clone() {
        Singer clonedSinger = new Singer(this); // Create a temporary variable
        return clonedSinger; // Return the variable
    }

    // Updated entityType to match original
    @Override
    public String entityType() {
        return String.valueOf("singer"); // Using String.valueOf
    }

    // Getters and Setters
    public String getDebutAlbum() {
        return new String(debutAlbum); // Return a new String copy
    }

    public void setDebutAlbum(String debutAlbum) {
        this.debutAlbum = debutAlbum != null ? debutAlbum : "unknown"; // Added null check
    }

    public Date getDebutAlbumReleaseDate() {
        // Return a copy using the Date copy constructor as in the original code
        return new Date(debutAlbumReleaseDate); 
    }

    public void setDebutAlbumReleaseDate(Date debutAlbumReleaseDate) {
        // Use the Date copy constructor as in the original code
        this.debutAlbumReleaseDate = debutAlbumReleaseDate != null ? 
                                    new Date(debutAlbumReleaseDate) : 
                                    new Date(); // Added null check
    }

    // Override toString to match original format
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); // Using StringBuilder
        sb.append(super.toString());
        sb.append("\nDebut Album: ");
        sb.append(debutAlbum);
        sb.append("\nRelease Date: ");
        sb.append(debutAlbumReleaseDate.toString());
        return sb.toString();
    }
}