//Code made by Guntas Toor 20409009

package PersonAndDate;
import java.util.Scanner;

public class Date {
    private String month;
    private int day;
    private int year;

    public Date() {
        month = "January";
        day = 1;
        year = 1000;
    }

    public Date(String monthString, int day, int year) {
        setDate(monthString, day, year);
    }

    public Date(int monthInt, int day, int year) {
        setDate(monthInt, day, year);
    }

    public Date(int year) {
        setDate(1, 1, year);
    }

    // Date constructor 
    public Date(String strDate) {
        try {
            String[] dateParts = strDate.split("/");
            
            //Check if user inputed 3 things
            if (dateParts.length != 3) {
                throw new IllegalArgumentException("Invalid input format. The expected format is MM/DD/YYYY, with month/day/year");
            }
            
            int monthInt = Integer.parseInt(dateParts[0]);
            int day = Integer.parseInt(dateParts[1]);
            int year = Integer.parseInt(dateParts[2]);
            
            if (!dateOK(monthInt, day, year)) {
                throw new IllegalArgumentException("Invalid date format. The expected format is MM/DD/YYYY");
            }
            
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid date format. Dates should be only be numerical");
        }
    }

    // Copy constructor
    public Date(Date aDate) {
        if (aDate == null) {
             System.out.println("Error.");
             System.exit(0);
        }

        month = aDate.month;
        day = aDate.day;
        year = aDate.year;
    }

    //Set date functions with integer and string inputs for month
    public void setDate(int monthInt, int day, int year) {
        if (dateOK(monthInt, day, year)) {
            this.month = monthString(monthInt);
            this.day = day;
            this.year = year;
        }
        else {
            System.out.println("Error");
            System.exit(0);
        }
    }

    public void setDate(String monthString, int day, int year) {
        if (dateOK(monthString, day, year)) {
            this.month = monthString;
            this.day = day;
            this.year = year;
        }
        else {
            System.out.println("Error");
            System.exit(0);
        }
    }

    //Returns the string of the date
    public String toString() {
        return (month + " " + day + ", " + year);
    }

    //Functions to compare user input and other date
    public boolean equals(Date otherDate) {
        return ((month.equals(otherDate.month))
                && (day == otherDate.day) && (year == otherDate.year));
    }

    public boolean precedes(Date otherDate) {
        return ((year < otherDate.year) ||
           (year == otherDate.year && getMonth() < otherDate.getMonth()) ||
           (year == otherDate.year && month.equals(otherDate.month)
                                       && day < otherDate.day));
    }

    
    public boolean dateOK(int monthInt, int dayInt, int yearInt) {
        return ((monthInt >= 1) && (monthInt <= 12) &&
                (dayInt >= 1) && (dayInt <= 31) &&
                (yearInt >= 1000) && (yearInt <= 9999));
    }

    private boolean dateOK(String monthString, int dayInt, int yearInt) {
        return (monthOK(monthString) &&
                (dayInt >= 1) && (dayInt <= 31) &&
                (yearInt >= 1000) && (yearInt <= 9999));
    }

    private boolean monthOK(String month) {
        return (month.equals("January") || month.equals("February") ||
                month.equals("March") || month.equals("April") ||
                month.equals("May") || month.equals("June") ||
                month.equals("July") || month.equals("August") ||
                month.equals("September") || month.equals("October") ||
                month.equals("November") || month.equals("December"));
    }

    public int getMonth() {
        if (month.equals("January"))
            return 1;
        else if (month.equals("February"))
            return 2;
        else if (month.equalsIgnoreCase("March"))
            return 3;
        else if (month.equalsIgnoreCase("April"))
            return 4;
        else if (month.equalsIgnoreCase("May"))
            return 5;
        else if (month.equalsIgnoreCase("June"))
            return 6;
        else if (month.equalsIgnoreCase("July"))
            return 7;
        else if (month.equalsIgnoreCase("August"))
            return 8;
        else if (month.equalsIgnoreCase("September"))
            return 9;
        else if (month.equalsIgnoreCase("October"))
            return 10;
        else if (month.equalsIgnoreCase("November"))
            return 11;
        else if (month.equalsIgnoreCase("December"))
            return 12;
        else {
            System.out.println("Fatal Error");
            System.exit(0);
            return 0;
        }
    }

    private String monthString(int monthNumber) {
        switch (monthNumber) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default:
                System.out.println("Error");
                System.exit(0);
                return "Error";
        }
    }
}