package packageLab2;

import java.util.Arrays;

public class Stock {
	private int day;
	private int month;
	private int year;
	private String name;
	private int[] values = new int[7];
	
	public Stock() {
		day = 1;
		month = 1;
		year = 1;
		name = "";
	}
	
	public Stock(
			int dayIn,
			int monthIn,
			int yearIn,
			String nameIn,
			int[] valIn
			) {
		boolean isValidDate = setDate(dayIn, monthIn, yearIn);
		boolean isValidValues = validateValues(valIn);
		
		if (isValidDate && isValidValues) {
            day = dayIn;
            month = monthIn;
            year = yearIn;
            name = nameIn;
            values = valIn.clone(); // Use clone to avoid reference issues
        } else {
            // Set to defaults and print an error message
            System.out.println("Error");
            day = dayIn;
            month = monthIn;
            year = yearIn;
            name = nameIn;
            for (int i = 0; i < values.length; i++) {
                values[i] = 0;
            }
        }
	}

	public int getDay() {
		return day;
	}

	public int getMonth() {
		return month;
	}

	public int getYear() {
		return year;
	}
	
	public String getName() {
		return name;
	}
	
	public int getValue(int ind) {
		if(ind < 0 || ind > 6) {
			return -1;
		} else {
			return values[ind];
		}
	}
	
	public void setName(String nameIn) {
		name = nameIn;
	}
	
	public void setValue(int val, int ind) {
		if(val < 0 || ind < 0 || ind > 6) {
			System.out.println("Error");
		}else {
			values[ind] = val;
		}
	}
	
	public void printStock() {
		System.out.println(this.name + ": " + day + "." + month + "." + year + " Values: " + Arrays.toString(values));
		System.out.println();
	}
	
	public int getMean(){
		int sum = 0;
		for(int i = 0; i < values.length; i++) {
			sum = sum + values[i];
		}
		return sum/values.length;
	}
	
	private boolean validateValues(int[] valIn) {
		if (valIn == null || valIn.length != 7) {
            return false;
        }
        for (int val : valIn) {
            if (val < 0) {
                return false;
            }
        }
        return true;
    }
	
	public boolean setDate(int dayIn, int monthIn, int yearIn) {
		//List of days in each month, adjusted for leap years
		int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		if (monthIn == 2 && isLeapYear(yearIn)) {
			daysInMonth[1] = 29;
		}

		if (dayIn >= 1 && (monthIn >= 1 && monthIn <= 12 && dayIn <= daysInMonth[monthIn - 1])) {
			day = dayIn;
		} else if((monthIn < 1 || monthIn > 12) && dayIn >= 1 && dayIn <= 31) {
			day = dayIn;
		}
		else {
			System.out.println("Error");
			return false;
		}
		if (monthIn <= 12 && monthIn >= 1) {
			month = monthIn;
		} else {
			System.out.println("Error");
			return false;
		}
		if (yearIn >= 0) {
			year = yearIn;
		} else {
			System.out.println("Error");
			return false;
		}
		return true;
	}
	
	
	private boolean isLeapYear(int yearIn) {
	       if (yearIn % 4 == 0) {
	           if (yearIn % 100 == 0) {
	               return yearIn % 400 == 0;
	           }
	           return true;
	       }
	       return false;
	 }
	public void printDate() {
		System.out.println(day + "." + month + "." + year);
	}
}
