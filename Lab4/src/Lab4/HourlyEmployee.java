package Lab4;

import java.util.Date;

public class HourlyEmployee extends Employee implements Cloneable, Comparable<HourlyEmployee>, Payable {
    private double wageRate;
    private double hours;

    public HourlyEmployee() {
        super();
        wageRate = 0;
        hours = 0;
    }

    public HourlyEmployee(String theName, Date theDate, double theWageRate, double theHours) {
        super(theName, theDate);
        if ((theWageRate >= 0) && (theHours >= 0)) {
            wageRate = theWageRate;
            hours = theHours;
        } else {
            System.out.println("Fatal Error: creating an illegal hourly employee.");
            System.exit(0);
        }
    }

    public int compareTo(HourlyEmployee anotherWorker) {
        return this.getName().compareTo(anotherWorker.getName());
    }

    public Double amountToPay() {
        return wageRate * hours;
    }

    public void printPayment() {
        System.out.println("Payment information for an hourly employee. Employee name: " + getName() + "; payment: " + amountToPay());
    }
}