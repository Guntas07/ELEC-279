package package1;
import java.util.Scanner;

public class TaskInputOutput {
public static void main(String args[]) {
	Scanner input = new Scanner(System.in);
	int num1 = input.nextInt();
	int num2 = input.nextInt();
	
	int sum = num1+num2;
	
	System.out.println("The sum is " + sum);
	System.out.println("The multiplication is " + num1*num2);
	
	input.close();
}
}
