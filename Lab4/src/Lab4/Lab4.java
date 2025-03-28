package Lab4;
import java.util.Arrays;
import java.util.Date;

public class Lab4 {
    public static void main(String[] args) {
        // Part 1
        HourlyEmployee[] staff = new HourlyEmployee[5];
        Date theDate = new Date(2005-1900,1,1);
        for(int i = 0; i < 5; i++){
            theDate.setYear(2005+i-1900);
            staff[i] = new HourlyEmployee("Alice" + (5-i),(Date)theDate.clone(), 15.0, 10+i*4.0);
        }
        
       
        
        Arrays.sort(staff);
        
        System.out.println("\nSorted employee array:");
        for(HourlyEmployee temp : staff){
            System.out.println(temp.toString());
        }
        
        // Part 2
        Invoice[] bills = new Invoice[5];
        for(int i = 0; i < 5; i++){
            bills[i] = new Invoice("Company" + (5-i), 300.0 - 50.0*i);
        }
        
        
        Arrays.sort(bills);
        
        System.out.println("\nSorted invoice array:");
        for(Invoice temp : bills){
            System.out.println(temp.toString());
        }
        
        // Part 3
        System.out.println("\nPrint payment for all invoices:");
        for(Payable temp : bills){
            temp.printPayment();
        }
        
        // Part 4
        Payable[] pending = new Payable[10];
        
        System.arraycopy(bills, 0, pending, 0, 5);
        System.arraycopy(staff, 0, pending, 5, 5);
        
        System.out.println("\nPrint payment for all payable objects:");
        for(Payable temp : pending){
            temp.printPayment();
        }
    }
}