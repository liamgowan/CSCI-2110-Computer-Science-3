/*Lab 2, Exercise 3, CSCI 2110
Exercise3.java takes in a value of n, and assigns all of the numbers up to 2^n in binary
to a String. Please note that this program does not display the binary numbers as it was 
stated in lab instructions that it does not have to.
September 23, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
public class Exercise3{
   public static void main(String[] args){ 
      Scanner input = new Scanner(System.in); 
      long startTime, endTime, executionTime;
      System.out.print("Enter the value of n: "); 
      int n = input.nextInt();
      startTime = System.currentTimeMillis();//finds startTime
      for(int i=0; i<=(Math.pow(2, n)-1); i++){//generates numbers in binary up to 2^n
         String sb = Integer.toBinaryString(i);  
      }
      endTime = System.currentTimeMillis();//finds endTime
      executionTime=endTime-startTime;//finds executionTime
      System.out.println("Execution time: to generate 2^"+n+
      " binary numbers: " + executionTime+" millisecs");
   }
}
      