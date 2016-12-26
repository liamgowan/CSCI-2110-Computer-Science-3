/*Lab 1 Exercise 4, CSCI 2110
Jumble.java can be used a a client program for MyString.java. In this program, it asks the user for 
an input, calculates how many times the letters can be rearranged, asks the user for how many 
variations they would like to see, and if the requested number is less than the maximum number,
it will print them, otherwise it will print all of the possible variations.
September 19, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
import java.util.ArrayList;
public class Jumble{
   public static void main(String[] args){
      ArrayList<String> jumbleList = new ArrayList<String>();
      Scanner keyboard = new Scanner(System.in);
      System.out.print("Enter the word: ");
      String input = keyboard.nextLine();
      int wordNum=input.length();
      int topFactorial = wordNum;
      while(wordNum!=1){//calculates how many permutations there are if no letters repeat
         topFactorial =+topFactorial*(wordNum-1);
         wordNum--;
      }
      int maxPerm = topFactorial;
      //From here to line calculates how many permutations there are if letters do repeat
      ArrayList<Character> allChars = new ArrayList<Character>();
      for(int i=0; i<input.length(); i++){
         allChars.add(input.charAt(i));//adds each letter in input to char ArrayList
      }
      int length = input.length();
      for(int i=0; i<length; i++){
         //counts letters in the words, if the first index of one is not the last index as well, 
         //the count increases, and the first index is removed. Process repeats itself.
         int count = 1;
         if(allChars.indexOf(allChars.get(i))!=allChars.lastIndexOf(allChars.get(i))){
            count++;
            allChars.remove(allChars.lastIndexOf(allChars.get(i)));
            if(allChars.indexOf(allChars.get(i))!=allChars.lastIndexOf(allChars.get(i))){
               count++;
               allChars.remove(allChars.lastIndexOf(allChars.get(i)));
            }
            if(allChars.indexOf(allChars.get(i))!=allChars.lastIndexOf(allChars.get(i))){
               count++;
               allChars.remove(allChars.lastIndexOf(allChars.get(i)));
            }
            int divideBy=0;
            if(count>=2){//determines was factorial to divide the original number by.
               divideBy =+ count*(count-1);
               count--;
               length--;
               maxPerm = topFactorial/divideBy;
               if(count==2)
                  break; 
            }  
         } 
      }
      MyString w1 = new MyString(input); //MyString object is made, sending the input word to it
      //user is prompted for how many variations they would like to see, if greater than maxPerm
      //it will display error message and display all versions.
      System.out.print("Enter the number of jumbled versions required: ");
      int num = keyboard.nextInt();
      if(num>maxPerm){
         System.out.println("Sorry! The maximum amount of variations is " + maxPerm+
                          "\nGenerating " + maxPerm + " versions:");
         num=maxPerm;
      }
      for(int i = 0; i<num; i++){
         //for num amount of times, program will jumble the word and add it to the jumbleList 
         //ArrayList, if it does not already contain it.
         String word = w1.permute();
         if(!jumbleList.contains(word))
            jumbleList.add(word);
         else//if it does contain it, i will be decreased
            i--;
      }
      for(int i=0; i<jumbleList.size(); i++)//displays all variations in jumbleList ArrayList
         System.out.println(jumbleList.get(i));
   }
}    