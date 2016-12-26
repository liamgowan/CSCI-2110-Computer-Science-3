/*Lab 6, Exercise2, CSCI 2110
Exercise2.java uses recursion to print down from a number, 2 at a time, and then say "Blast Off!"
October 28, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Exercise2 {
	public static void main(String[] args){
		System.out.println(countDown(10));
		System.out.print(countDown(9));
	}
	public static String countDown(int n){
		if(n<=0)//base case
			return "Blast Off!";
		return (n+ "\t" + countDown(n-2));//decreases n by 2 instead of 1, glue case
		
	}
}