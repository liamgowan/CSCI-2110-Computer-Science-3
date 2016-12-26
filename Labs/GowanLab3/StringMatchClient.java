/*Lab 2 Exercise 1, CSCI 2110
StringMatchClient.java is a client program for the StringMatch.java file. It takes in a string and a
substring from the user, creates a StringMatch object, uses the match() method to return an ArrayList of
integers, and displays each element of the ArrayList if the size of the ArrayList is at least one, 
otherwise it will provide a message to the user saying the substring was not found.
October 2, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
import java.util.ArrayList;
public class StringMatchClient{
   public static void main(String[] args){
      long startTime, endTime, executionTime;
      Scanner input = new Scanner(System.in);
      System.out.print("Enter a string: ");
      String s1 = input.nextLine();
      System.out.print("Enter a substring: ");
      String s2 = input.nextLine();
      StringMatch sa1 = new StringMatch(s1, s2);//creates StringMatch object
      ArrayList<Integer> starts;
      startTime = System.currentTimeMillis();
      starts = sa1.match();//assigns ArrayList returned by sa1 to "this" starts ArrayList
      endTime = System.currentTimeMillis();
      executionTime = endTime-startTime;
      if(starts.size()>0){
         System.out.println("Substring " + s2 + " was found in " + s1 + " at indeces: ");
         for(int i=0; i<starts.size(); i++)
            System.out.print(starts.get(i) + " ");//prints all indeces
         System.out.println();
      }
      else
         System.out.println("No matches - substring " + s2 + " was not found in " + s1);
      System.out.print("Execution time: " + executionTime + " millisecs");      
   }
}