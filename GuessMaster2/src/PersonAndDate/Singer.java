package PersonAndDate;

public class Singer extends Person {
    private String debutAlbum;
    private Date debutAlbumReleaseDate; 

    // Default constructor
    public Singer() {
        super();
        debutAlbum = "unknown"; // Removed 'this.'
        debutAlbumReleaseDate = new Date(); // Removed 'this.'
    }

    public Singer(String name, Date birth, String gender, String debutAlbum, Date debutAlbumReleaseDate, double difficulty) {
        super(name, birth, gender, difficulty);
        this.debutAlbum = new String(debutAlbum); 
        this.debutAlbumReleaseDate = new Date(debutAlbumReleaseDate); 
    }

    // Copy Constructor
    public Singer(Singer other) {
        super(other);
        debutAlbum = String.valueOf(other.debutAlbum); 
        debutAlbumReleaseDate = new Date(other.debutAlbumReleaseDate); 
    }

    // Clone method using copy constructor
    @Override
    public Singer clone() {
        Singer clonedSinger = new Singer(this); 
        return clonedSinger; 
    }

    @Override
    public String entityType() {
        return String.valueOf("Singer"); 
    }

    // Getters and Setters
    public String getDebutAlbum() {
        return new String(debutAlbum); 
    }

    public void setDebutAlbum(String debutAlbum) {
        this.debutAlbum = debutAlbum != null ? debutAlbum : "unknown"; 
    }

    public Date getDebutAlbumReleaseDate() {
        return new Date(debutAlbumReleaseDate); 
    }

    public void setDebutAlbumReleaseDate(Date debutAlbumReleaseDate) {
        this.debutAlbumReleaseDate = debutAlbumReleaseDate != null ? 
                                    new Date(debutAlbumReleaseDate) : 
                                    new Date();
    }

    // Override toString to match original format
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(); 
        sb.append(super.toString());
        sb.append("\nDebut Album: ");
        sb.append(debutAlbum);
        sb.append("\nRelease Date: ");
        sb.append(debutAlbumReleaseDate.toString());
        return sb.toString();
    }
}