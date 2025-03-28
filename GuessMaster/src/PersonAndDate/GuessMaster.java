package PersonAndDate;
import java.util.Random;
import java.util.Scanner;

public class GuessMaster {
    private int numOfEntities;
    private Entity[] entities;
    private int totalTickets;
    private int ticketsWon;
    
    // Default constructor
    public GuessMaster() {
        entities = new Entity[1000]; // Increased capacity to match original
        numOfEntities = 0;
        totalTickets = 0;
        ticketsWon = 0;
    }
    
    // Adds an entity - fixed to match original
    public void addEntity(Entity entity) {
        Entity entityCopy = entity.clone(); // Create a temporary variable
        entities[numOfEntities++] = entityCopy; // Use the variable instead of direct assignment
    }
    
    // Fixed playGame method to match original functionality
    public void playGame(Entity entity) {
        StringBuilder welcomeMsg = new StringBuilder("Welcome to the ELEC279 GuessMaster 2.0 Game");
        System.out.println(welcomeMsg.toString());
        
        try (Scanner scanner = new Scanner(System.in)) {
            // First while loop ensures the game continues even after 1 entity is correctly guessed
            boolean continueGame = true;
            while (continueGame) {
                // Once entity is correctly guessed, a new entity is chosen at random
                int randomEntityIndex = genRandomEntityIndex();
                Entity currentEntity = entities[randomEntityIndex].clone(); // Using clone for defensive copying
                
                System.out.println("\n" + String.valueOf(currentEntity.welcome())); 
                StringBuilder promptMsg = new StringBuilder("Guess the birth date (MM/DD/YYYY) of ");
                promptMsg.append(currentEntity.getName());
                promptMsg.append(":");
                System.out.println(promptMsg.toString());
                
                boolean entityGuessed = false;
                while (!entityGuessed) {
                    String userInput = new String(scanner.nextLine().trim());
                    
                    // Check for quit or exit commands
                    if (userInput.equalsIgnoreCase(new String("Quit")) || 
                        userInput.equalsIgnoreCase(new String("Exit"))) {
                        StringBuilder exitMsg = new StringBuilder("Game exited. Thank you for playing! Your total ticket count was ");
                        exitMsg.append(totalTickets);
                        exitMsg.append(".");
                        System.out.println(exitMsg.toString());
                        return;
                    }
                    
                    try {
                        Date userDate = new Date(userInput);
                        Date entityBirth = currentEntity.getBirth(); // Store in variable
                        
                        // Compare user's guess with the entity's birth date
                        if (userDate.equals(entityBirth)) {
                            int awardedTickets = currentEntity.getAwardedTicketNumber();
                            ticketsWon = awardedTickets;
                            totalTickets += ticketsWon;
                            
                            // Print output and ticket info
                            StringBuilder successMsg = new StringBuilder("\nBINGO. You got it!!");
                            System.out.println(successMsg.toString());
                            
                            StringBuilder ticketMsg = new StringBuilder("You won ");
                            ticketMsg.append(ticketsWon);
                            ticketMsg.append(" tickets in this round. \nThe total number of your tickets is ");
                            ticketMsg.append(totalTickets);
                            ticketMsg.append(".");
                            System.out.println(ticketMsg.toString());
                            
                            System.out.println("-----------------------------------------------");
                            System.out.println(String.valueOf(currentEntity.close()));
                            // Break inner while loop if correct
                            entityGuessed = true;
                        }
                        else if (userDate.precedes(entityBirth)) {
                            System.out.println(new String("Incorrect. Try a later date:"));
                        }
                        else {
                            System.out.println(new String("Incorrect. Try an earlier date:"));
                        }
                    }
                    catch (IllegalArgumentException e) {
                        StringBuilder errorMsg = new StringBuilder(e.getMessage());
                        errorMsg.append(".\nPlease try again:");
                        System.out.println(errorMsg.toString());
                    }
                }
            }
        }
    }
    
    // Generate random entity index
    private int genRandomEntityIndex() {
        Random rand = new Random();
        int maxIndex = numOfEntities;
        return rand.nextInt(maxIndex);
    }
    
    // Play game with specific entity
    public void playGame(int entityIndex) {
        Entity entityToPlay = entities[entityIndex];
        playGame(entityToPlay);
    }
    
    // Play game with random entity
    public void playGame() {
        int randomIndex = genRandomEntityIndex();
        playGame(randomIndex);
    }
    
    // Main method to initialize and start the game
    public static void main(String[] args) {
        GuessMaster gm = new GuessMaster();
        
        // Create and add entities
        Politician churchill = new Politician(
                "Winston Churchill",
                new Date("November", 30, 1874),
                "Male",
                "Conservative",
                0.25);
                
        Singer dion = new Singer(
                "Celine Dion",
                new Date("March", 30, 1961),
                "Female",
                "La voix du bon Dieu",
                new Date("November", 6, 1981),
                0.5);
                
        Person creator = new Person(
                "Creator",
                new Date("July", 17, 2005),
                "Male",
                1.0);
                
        Country usa = new Country(
                "United States",
                new Date("July", 4, 1776),
                "Washington D.C.",
                0.1);
        
        // Add entities to game
        gm.addEntity(churchill);
        gm.addEntity(dion);
        gm.addEntity(creator);
        gm.addEntity(usa);
        
        // Start the game
        gm.playGame();
    }
}