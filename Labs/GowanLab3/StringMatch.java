/*Lab 2 Exercise 1, CSCI 2110
StringMatchC.java has two String variables. s1 will contain String of text to be searched, and s2 
will contain the String of text to be searched for. The method match() will return an ArrayList of 
integers for the starting location of all indeces.
October 2, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.ArrayList;
public class StringMatch{
   private String s1, s2;
   public StringMatch(String s1, String s2){
      this.s1 = s1; this.s2 = s2;
   }
   public ArrayList<Integer> match(){
      ArrayList<Integer> starts = new ArrayList<Integer>();
      String s3 = "";
      /*The first for loop runs to test if the character at the index being test of s1
      is the same as the first character of S2, and if the length of s2 + i is less than or equal
      to the length of s1. If it is, for the length of s2, a new String, s3, will be created of 
      the next characters in s1. The program will then test to see if s3 is equal to s2, and if it
      is, it will add the index to the ArrayList. */ 
      for(int i=0; i<s1.length(); i++){
         if(s1.charAt(i)==s2.charAt(0)&&s2.length()+i<=s1.length()){
            for(int j=0; j<s2.length(); j++)
               s3 += "" + s1.charAt(i+j);
            if(s3.equals(s2))
               starts.add(i);    
         }
         s3 = "";
      }
      return starts;
   }
}