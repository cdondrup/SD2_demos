import java.util.Scanner;

public class TestCommandLine {

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int i; int sum=0; int next;
		System.out.println("Find sum of 10 integers between 0 & 100");
		for(i=0;i<10;i++) { 
			System.out.print("Enter integer "+i+" > ");
		   	System.out.flush();
		   	next = keyboard.nextInt();
		   	while(next<0 || next>100) { 
				System.out.println("Integer not between 0 & 100");
		      		System.out.print("Enter integer "+i+" > ");
		      		System.out.flush();
		     		next = keyboard.nextInt();
		   	}
		   	sum = sum + next;
		}
		System.out.println("Sum is: "+sum);

	}

}
