/*Lab 2 Exercise 1, CSCI 2110
Exercise1.java takes in the highest degree of a polynomial and the value
of x, and determines the value obtained by calculating what the polynomial is equal 
to. It also provides the time that it took the program to do this
September 23, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
public class Exercise1{
   public static void main(String[] args){
      Scanner input = new Scanner(System.in);
      long startTime, endTime, executionTime;
      System.out.print("Enter the degree of the polynomial: ");
      long degree = input.nextLong();
      System.out.print("Enter the value of x: ");
      long x = input.nextLong();
      long total = 0;
      startTime = System.currentTimeMillis();//Finds start time
      for(long i=0; i<=degree; i++){//finds what polynomial is equal to
         total += (long)Math.pow(x,i);
         //System.out.println(total);
      }
      endTime = System.currentTimeMillis();//finds end time
      System.out.println("The polynomial evaluates to: " + total);
      executionTime = endTime - startTime;//calculates execution time
      System.out.println("Execution time to evaluate polynomial of degree " + degree + 
                         ": " + executionTime + " millisecs");
   }
}