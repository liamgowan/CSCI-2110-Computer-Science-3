/*Lab 2 Exercise 3, CSCI 2110
GCDClient.java is a client program for GCD.java. It asks the user for which method they would like to 
compute the GCD between two numbers, and then uses the appropiate method from GCD object to
calcute GCD.
October 2, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
public class GCDClient{
   public static void main(String[] args){
      long num1, num2, startTime, endTime, executionTime;
      System.out.print("Which method (Enter Method1 or Method2)?: ");
      Scanner input = new Scanner(System.in);
      String method = input.nextLine();
      System.out.print("Enter the first integer: ");
      num1 = input.nextLong();
      System.out.print("Enter the second integer: ");
      num2 = input.nextLong();
      GCD g = new GCD(num1,num2);//creates GCD object
      startTime = System.currentTimeMillis();
      if(method.equals("Method1"))
         System.out.println("The GCD is: " + g.method1());
      else if(method.equals("Method2"))
         System.out.println("The GCD is: " + g.method2());
      endTime = System.currentTimeMillis();
      executionTime = endTime - startTime;
      System.out.print("Execution time: " + executionTime);
   }
}