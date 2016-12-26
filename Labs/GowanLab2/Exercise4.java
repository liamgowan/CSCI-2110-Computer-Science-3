/*Lab 2, Exercise 4, CSCI 2110
Exercise4.java takes in a value of p, which is checked to ensure it is less than or equal to 64.
It then checks to see if every number from 2 to p is a Mersenne prime number. It then displays all
of the Mersenne prime numbers found.
September 23, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
import java.util.ArrayList;
public class Exercise4{
   public static void main(String[] args){
      long startTime, endTime, executionTime;
      ArrayList<Integer> mersennePrimes = new ArrayList<Integer>();
      Scanner input = new Scanner(System.in);
      System.out.print("Enter p (please enter a value <=64): ");
      int p = input.nextInt();
      while(p>64){//Ensures p is less than or equal to 64
         System.out.print("Please enter a value <= 64): ");
         p = input.nextInt();
      }
      startTime = System.currentTimeMillis();//finds start time
      for(int i=2; i<=p; i++){
      //from 2 to p, it will see if i is a Mersenne prime number, if so, it will add it to an
      //array list
         if(isPrime(i))
            if(isMersennePrime(i))
               mersennePrimes.add(i);
      }
      for(int i=0; i<mersennePrimes.size(); i++){//displays found mersennePrime numbers
         System.out.println(mersennePrimes.get(i));
      }
      endTime = System.currentTimeMillis();
      executionTime = endTime - startTime;
      System.out.println("Time required to find Mersenne primes: " + executionTime + " millisecs");
   }
   public static boolean isPrime(long p){
      //determines if a number is prime number by seeing if the remainder of p divided by i (from 2 until
      //the square root of p) is zero, and if it is, p is not a prime number and program will return 
      //false, otherwise it will return true 
      for(long i=2; i<Math.sqrt(p); i++){
         if(p%i==0)
            return false;
      }
      return true;
   }
   public static boolean isMersennePrime(int p){
      return(isPrime((long)Math.pow(2,p)-1));//calls the isPrime method with the value 2^p-1
   }           
}              