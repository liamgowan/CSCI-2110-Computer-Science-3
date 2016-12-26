/*Lab 6, Exercise1, CSCI 2110
Exercise1.java uses recursion to print down from 10, and then say "Blast Off!"
October 28, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Exercise1 {
	public static void main(String[] args){
		System.out.print(countDown(10));//calls recursive method
	}
	public static String countDown(int n){
		if(n==0)//base case
			return "Blast Off!";
		return (n+ "\t" + countDown(n-1));//glue case
		
	}
}
