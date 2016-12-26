/*Lab 1 Exercise 4, CSCI 2110
MyString.java holds information about a string. It has a constructor, which takes in a string. It has
a method which takes the letters of a word and scrambles them, and then returns the result.
September 19, 2015
Liam Gowan B00673126
This is entirely my own work.

*/
public class MyString{
   private String word;
   public MyString(String word){
      this.word = word;
   }
   public String permute(){
      //method creates an array of char's, that is full of the word converted to a char array.
      char[] chars = word.toCharArray();
      for(int i=0; i<word.length()*2; i++){
         //for loop then switches all of the letters around
         int index1 = (int)(word.length()*Math.random());
         int index2 = (int)(word.length()*Math.random());
         char cHold1 = chars[index1];
         char cHold2 = chars[index2];
         chars[index1]=cHold2;
         chars[index2]=cHold1;
      }
      return new String(chars);//returns the char array converted to a string
   }
}        
         