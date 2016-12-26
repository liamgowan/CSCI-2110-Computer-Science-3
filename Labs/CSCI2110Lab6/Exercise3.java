/*Lab 6, Exercise3, CSCI 2110
Exercise3.java uses recursion to take m and n, and displays m multiples of n.
October 28, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Exercise3 {
	public static void main(String[] args){
		System.out.print(multiples(5,2,1));
	}
	public static String multiples(int m,int n, int counter){
		//Method uses a counter to multiply m appropriately each time
		if(m==1)//base case
			return "" + n*counter;
		return (n*counter+", " + multiples(m-1, n, counter +1));//glue case
	}
}