/*Lab 1 Exercise 3, CSCI 2110
Rectangle2D.java stores information about a circle object regarding the x and y position of it's centre, 
and radius. It contains 2 contstructor methods, get and set methods, methods to return
the area and perimeter, a method to tell if a given point or circle can be contained within the circle,
or if a given circle overlaps the circle. 
September 19, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Circle2D{
   //instance variables
   private double x,y, radius;
   public Circle2D(){
      x = 0; y = 0; radius = 1;
   }
   public Circle2D(double x, double y, double radius){
      this.x=x; this.y=y; this.radius=radius;
   }
   //accessor methods
   public double getX(){return x;}
   public double getY(){return y;}
   public double getRadius(){return radius;}
   //mutator methods
   public void setX(double x){this.x = x;}
   public void setY(double y){this.y = y;}
   public void setRadius(double radius){this.radius = radius;}
   //other methods
   public double getArea(){
      return Math.PI*radius*radius;
   }
   public double getPerimeter(){
      return 2*Math.PI*radius;
   }
   public boolean contains(double x, double y){//tests if a point is contained
      return(x<=(this.x+radius)&&y<=(this.y+radius));
   }
   public boolean contains(Circle2D circle){//tests if a circle is contained within "this" circle
      double distance = Math.sqrt(Math.pow(circle.getX()-x,2)+Math.pow(circle.getY()-y,2));
      return (distance<=Math.abs(radius-circle.getRadius()));
   }
   public boolean overlaps(Circle2D circle){//tests if a circle overlaps "this" circle
      double distance = Math.sqrt(Math.pow(circle.getX()-x,2)+Math.pow(circle.getY()-y,2));
      return (distance >= (radius+circle.getRadius()));
   }
      
      
}
      