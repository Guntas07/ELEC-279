package Lab4;

public class Invoice implements Comparable<Invoice>, Payable {
    private String companyName;
    private Double amount;

    public Invoice() {
        companyName = "No Name";
        amount = 0.0;
    }

    public Invoice(String theName, Double theAmount) {
        if (theName == null || theAmount < 0) {
            System.out.println("Fatal Error creating Invoice.");
            System.exit(0);
        }
        companyName = theName;
        amount = theAmount;
    }

    public int compareTo(Invoice bill) {
        return this.amount.compareTo(bill.amount);
    }

    public Double amountToPay() {
        return amount;
    }

    public void printPayment() {
        System.out.println("Payment information for an invoice. Company name: " + companyName + "; payment: " + amount);
    }
    
    // Added toString method
    public String toString() {
        return (companyName + " " + amount);
    }
}