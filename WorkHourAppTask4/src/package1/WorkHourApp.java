package package1;
import java.util.Scanner;

public class WorkHourApp {
public static void main(String args[]) {
	Scanner input = new Scanner(System.in);
	
	System.out.print("Enter the number of hours per day:");
	int num1 = input.nextInt();
	System.out.print("Enter the number of days:");
	int num2 = input.nextInt();
	
	for(int i = 1; i<=num2; i++) {
		System.out.println("Day "+i+ ", Total Hours Worked = "+i*num1);
	}

}
}
