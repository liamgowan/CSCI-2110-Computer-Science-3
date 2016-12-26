/*Lab 6, Exercise4, CSCI 2110
Exercise4.java, using recursion, takes an integer, and prints the first digit of the 
number on line, followed by the second, etc.
October 28, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Exercise4 {
	public static void main(String[] args){
		writeVertical(1234);
	}
	public static void writeVertical(int n){
		if(n<=0)//base case
			return;
		//glue case 
		writeVertical(n/10);//method must go first in order for it to be 1-2-3-4
		System.out.println(n%10);//prints the remainder of when n is divided by 10
	}
}
