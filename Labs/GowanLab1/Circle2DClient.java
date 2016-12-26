/*Lab 1 Exercise 3 Client, CSCI 2110
Rectangle2DClient.java tests the Rectangle2D class by testing each of it's methods 3 times using 
different values.
September 19, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Circle2DClient{
   public static void main(String[] args){
      System.out.println("TEST 1\n");
      Circle2D c1 = new Circle2D(2.0, 2.0, 5.5);
      System.out.println("Area: " + c1.getArea());
      System.out.println("Perimeter: " + c1.getPerimeter());
      System.out.println("c1 contains (3.0,3.0): " + c1.contains(3.0,3.0));
      System.out.println("c1 contains circle (4.0, 5.0, 10.5): " + c1.contains(new Circle2D(4.0,5.0,10.5)));
      System.out.println("c1 overlaps with (3.0, 5.0, 2.3): "+ c1.overlaps(new Circle2D(3.0, 5.0, 2.3)));
      
      System.out.println("TEST 2\n");
      Circle2D c2 = new Circle2D(5.5, 3.0, 10);
      System.out.println("Area: " + c2.getArea());
      System.out.println("Perimeter: " + c2.getPerimeter());
      System.out.println("c1 contains (8,50): " + c2.contains(8,50));
      System.out.println("c1 contains circle (6.3, 2.5, 4): " + c2.contains(new Circle2D(6.3, 2.5, 4)));
      System.out.println("c1 overlaps with (6.3, 2.5, 4): "+ c2.overlaps(new Circle2D(6.3, 2.5, 4)));
      
      System.out.println("TEST 3\n");
      Circle2D c3 = new Circle2D(8, 6.3, 4);
      System.out.println("Area: " + c3.getArea());
      System.out.println("Perimeter: " + c3.getPerimeter());
      System.out.println("c1 contains (2,3): " + c3.contains(2,3));
      System.out.println("c1 contains circle (4.3, 6.7, 3.0): " + c3.contains(new Circle2D(4.3, 6.7, 3.0)));
      System.out.println("c1 overlaps with (2.3, 7.8, 5.3): "+ c3.overlaps(new Circle2D(2.3, 7.8, 5.3)));
   }
}