/*Lab 1 Exercise 3, CSCI 2110
Exercise2.java takes in the x and y position of 5 points and then determines the dimensions of the 
smallest dimensions possible for a rectangle to contain the points, and creates the rectangle.
September 19, 2015
Liam Gowan B00673126
The getRectangle() method is entirely my own work. The main method was given in instructions, but has been
modified to display the x and y position of the top left corner of the rectangle.
*/
import java.util.Scanner;
public class Exercise2{  
   public static void main(String[] args){
      double[][] points = new double[5][2];
      Scanner input = new Scanner(System.in);
     System.out.print("Enter " + points.length + " points: ");
     for(int i = 0; i < points.length; i++){
         points[i][0] = input.nextDouble();
         points[i][1] = input.nextDouble();
     }
      Rectangle2D boundingRectangle = getRectangle(points);
     System.out.println("The bounding rectangle's XPos and YPos (" +boundingRectangle.getXPos() + ", " +
boundingRectangle.getYPos() + ") the bounding rectangle's centre is: " + "(" + (boundingRectangle.getXPos() + boundingRectangle.getWidth()/2) + ", " +
(boundingRectangle.getYPos() + boundingRectangle.getHeight()/2) + "), width: " +boundingRectangle.getWidth() + ", height: " +boundingRectangle.getHeight());  
   }
   public static Rectangle2D getRectangle(double[][] points){
      double smallXPos = points[0][0];
      double largeXPos = points[0][0];
      double smallYPos = points[0][1];
      double largeYPos = points[0][1];
      for(int i=0; i<points.length; i++){
         //find smallest and largest x values, assigns to appropiate variables
         if(points[i][0]<smallXPos)
            smallXPos = points[i][0];
         if(points[i][0]>largeXPos)
            largeXPos = points[i][0];
      }
      for(int i=0; i<points.length; i++){
         //find smallest and largest y values, assigns to appropiate variables
         if(points[i][1]<smallYPos)
            smallYPos = points[i][1];
         if(points[i][1]>largeYPos)
            largeYPos = points[i][1];
      }
      double width = largeXPos-smallXPos;
      double height = largeYPos-smallYPos;
      return new Rectangle2D(smallXPos, smallYPos, width, height);//returns smallest possible rectangle   
   }
}








