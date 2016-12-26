/*Lab 2 Exercise 3, CSCI 2110
GCD.java takes in two numbers, and will determine the greatest common denominator between the two of
them using one of two methods, depending on which one is called. Method2 is more efficient than 
Method1.
October 2, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class GCD{
   private long num1, num2;
   public GCD(long num1, long num2){
      this.num1 = num1; this.num2 = num2;
   }
   public long method1(){
      /*This brute force method will go on for the number of times that the largest value of
      num1 and num2 is equal to. If the remainder of num1 and num2 divided by i is equal to zero,
      than the GCD is updated to i. GCD is then returned. */
      long GCD = 0;
      for(long i=1; i<=num1 || i<=num2; i++){
         if(num1%i==0 && num2%i==0 && i>GCD)
            GCD = i;
      }
      return GCD;
   }
   public long method2(){
      /*This method is more efficient of finding a GCD, it starts counting down from half of the 
      greatest num, and once a common demoninator is found, it is obviously the greater one, and is 
      then returned.*/
      long GCD = 0;
      for(long i=(Math.max(num1, num2))/2; i>0; i--){
         if(num1%i==0 && num2%i==0 && i>GCD){
            GCD = i;
            return GCD;
         }
      }
      return GCD;
   }
}