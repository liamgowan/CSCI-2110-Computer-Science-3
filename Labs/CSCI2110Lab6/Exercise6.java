/*Lab 6, Exercise6, CSCI 2110
Exercise6.java uses recursion to solve the Tower of Hanoi problem for a user selected number
of discs. It displays the number of moves required and execution time. By uncommenting 
the print statement in hanoi method, one can see the steps required, however it has been 
commented to more quickly process the moves required.
October 28, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
public class Exercise6 {
	public static long counter=0;
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter number of discs: ");
		int num = input.nextInt();
		long startTime, endTime, executionTime;
		startTime = System.currentTimeMillis();
		hanoi(num, 1,3,2);
		endTime = System.currentTimeMillis();
		executionTime = endTime - startTime;
		System.out.println("Minimum moves required: " + counter);
		System.out.print("Time to execute: " + executionTime + " milliseconds");
	}
	public static void hanoi(int num, int from, int to, int temp){
		//base case is when num is zero
		if(num>0){//glue case is when num is greater than 0
			hanoi(num-1, from,temp,to);
			//To save time, the print statement has been intentionally commented.
			//If you wish to see if it is functional, you may uncomment it.
			//System.out.println("Move disc " + num + " from peg " + from + " to peg " + to);
			Exercise6.counter++;
			hanoi(num-1,temp, to, from);
		}
	}
}
