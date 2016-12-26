/*Lab 2 Exercise 2, CSCI 2110
DNAMatch.java is a client program for the StringMatch.java file. It takes in a filename, converts 
all of it's contents to one String, and then prompts user for a substring to look for. It then 
returns the number of times the substring is found within the text file.
October 2, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
import java.io.*;
import java.util.ArrayList;
public class DNAMatch{
   public static void main(String[] args)throws IOException{  
      Scanner input = new Scanner(System.in);
      System.out.print("Enter the filename to read from: ");
      String filename = input.nextLine();
      String s1 = "";
      File file = new File(filename);
      Scanner inputFile = new Scanner(file);
      while(inputFile.hasNext())//while there is still more to copy, s1 gets increased
         s1 += inputFile.nextLine();
      inputFile.close();
      System.out.print("Enter the test string: ");
      String s2 = input.nextLine();
      StringMatch sa1 = new StringMatch(s1, s2);//makes String match object
      ArrayList<Integer> starts;
      long startTime, endTime, executionTime; 
      startTime = System.currentTimeMillis();
      starts = sa1.match();//assigns the ArrayList returned by match method to starts ArrayList
      endTime = System.currentTimeMillis();
      executionTime = endTime - startTime;
      //Displays how many times the s2 is found. 
      if(starts.size()==0)
         System.out.print("No matches - substring " + s2 + " was not found\n");
      else
         System.out.print("Substring " + s2 + " was found " + starts.size() + " times.\n");
      System.out.print("Execution time: " + executionTime + " millisecs");
   }
}