/*Lab 2 Exercise 4, CSCI 2110
FibonacciGCD.java is a client program for GCD.java. It asks the user for which Fibonacci number
theu would like to, finds it and the one before it. It then computes the GCD between the two numbers
found using Method1 and Method2 of GCD.java
October 2, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
import java.util.ArrayList;
public class FibonacciGCD{
   public static void main(String[] args){
      long startTime, endTime, executionTime;
      Scanner input = new Scanner(System.in);
      System.out.print("Enter which Fibonacci number you'd like to know: ");
      long num = input.nextLong();
      while(num>92){
         System.out.print("Sorry, program cannot compute for Fibonacci numbers greater than 92.\n" +
                          "Enter which Fibonacci number you'd like to know: ");
         num = input.nextLong();
      }
      long finalFib;
      ArrayList<Long> nums = new ArrayList<Long>();
      nums.add((long)0);
      nums.add((long)1);
      if(num==0)
         finalFib = nums.get(0);
      else if(num==1)
         finalFib = nums.get(1);
      else{
         /*If the desired number is two or greater, then the for loop will add
         the last two numbers of the nums ArrayList, and add that number to the ArrayList */
         for(int i=1; i<num; i++)
            nums.add(nums.get(i-1)+nums.get(i));
         finalFib=nums.get(nums.size()-1);
      }
      System.out.println("Fibonacci number " + (num-1) + " is: " + nums.get(nums.size()-2));
      System.out.println("Fibonacci number " + num + " is: "+finalFib);
      GCD g = new GCD(finalFib, nums.get(nums.size()-2));
      startTime = System.currentTimeMillis();
      System.out.println("Using Method1, the GCD of " + (nums.get(nums.size()-2)) + " and " + 
                       finalFib + " is: " + g.method1());//calls method1
      endTime = System.currentTimeMillis();
      executionTime = endTime - startTime;
      System.out.println("Method1 took " + executionTime + " millisecs");
      startTime = System.currentTimeMillis();
      System.out.println("Using Method2, the GCD of " + (nums.get(nums.size()-2)) + " and " + 
                       finalFib + " is: " + g.method2());//calls method2
      endTime = System.currentTimeMillis();
      executionTime = endTime - startTime;
      System.out.println("Method1 took " + executionTime + " millisecs");
      
         
   }
}