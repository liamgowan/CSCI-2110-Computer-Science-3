/*Lab 1 Exercise 1 Client, CSCI 2110
Rectangle2DClient.java tests the Rectangle2D class by testing each of it's methods 3 times using 
different scenarios.
September 19, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Rectangle2DClient{
   public static void main(String[] args){
      System.out.println("TEST 1\n");//Assigned to test these values
      Rectangle2D r1 = new Rectangle2D(2, 2, 5.5, 4); 
      System.out.println("XPos: " + r1.getXPos() + 
                         "\nYPos: " + r1.getYPos() +
                         "\nWidth: " + r1.getWidth() +
                         "\nHeight: " + r1.getHeight()+
                         "\nArea: " + r1.getArea() +
                         "\nPerimeter " + r1.getPerimeter());
                         
      System.out.println("r1 contains 3,3: " + r1.contains(3,3));
      System.out.println("r1 contains rectangle (4, 5, 10.5, 3.2): " + r1.contains(new Rectangle2D(4, 5, 10.5, 3.2)));
      System.out.println("Overlap with (3, 5, 2.3, 5.4): " + r1.overlap(new Rectangle2D(3, 5, 2.3, 5.4)));
      System.out.println("\nTEST 2\n");
      Rectangle2D r2 = new Rectangle2D(3, 1, 6, 3);
      System.out.println("XPos: " + r2.getXPos() + 
                         "\nYPos: " + r2.getYPos() +
                         "\nWidth: " + r2.getWidth() +
                         "\nHeight: " + r2.getHeight()+
                         "\nArea: " + r2.getArea() +
                         "\nPerimeter " + r2.getPerimeter());
      System.out.println("r2 contains 1,1: " + r2.contains(1,1));
      System.out.println("r2 contains rectangle (3.5, 1.5, 4, 1.5): " + r2.contains(new Rectangle2D(3.5, 1.5, 4, 1.5)));
      System.out.println("Overlap with (2, 1, 6, 3): " + r2.overlap(new Rectangle2D(2, 1, 6, 3)));//starts on left
      
      System.out.println("\nTEST 3\n");
      Rectangle2D r3 = new Rectangle2D(4, 5, 3, 8);
      System.out.println("XPos: " + r3.getXPos() + 
                         "\nYPos: " + r3.getYPos() +
                         "\nWidth: " + r3.getWidth() +
                         "\nHeight: " + r3.getHeight()+
                         "\nArea: " + r3.getArea() +
                         "\nPerimeter " + r3.getPerimeter());
      System.out.println("r3 contains 1,1: " + r3.contains(5,7));
      System.out.println("r3 contains rectangle (4, 6, 3, 7): " + r3.contains(new Rectangle2D(4, 6, 3, 7)));//touching side
      System.out.println("Overlap with (4,3,2,10): " + r3.overlap(new Rectangle2D(4,3,2,10)));//overlap through vertical
                        
                         
   }
}