package packageLab2;

public class Activity {
	private int day;
	private int month;
	private int year;
	
	public Activity() {
		day = 1;
		month = 1;
		year = 1;
	}

	public Activity(int dayIn, int monthIn, int yearIn){
		day = 1;
		month = 1;
		year = 1;
		setDate(dayIn, monthIn, yearIn);
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
	

	public void setDate(int dayIn, int monthIn, int yearIn) {
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
		}
		if (monthIn <= 12 && monthIn >= 1) {
			month = monthIn;
		} else {
			System.out.println("Error");
		}
		if (yearIn >= 0) {
			year = yearIn;
		} else {
			System.out.println("Error");
		}
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

