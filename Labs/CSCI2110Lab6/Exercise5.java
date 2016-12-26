/*Lab 6, Exercise5, CSCI 2110
Exercise5.java uses recursion to take an integer n, and find the sum of all of it's squares 
from 1 squared to n squared.
October 28, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Exercise5 {
	public static void main(String[] args){
		System.out.print(sumSquares(4));
	}
	public static int sumSquares(int n){
		if(n==0)//base case
			return 0;
		return (int)Math.pow(n, 2) + sumSquares(n-1);//glue case returns n^2 + the method taking n-1
	}
}
