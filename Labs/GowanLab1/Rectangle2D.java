/*Lab 1 Exercise 1, CSCI 2110
Rectangle2D.java stores information about a rectangle object regarding the x and y position of it's top
left corner, width and height. It contains 2 contstructor methods, get and set methods, methods to return
the area and perimeter, a method to tell if a given point or rectangle can be contained within the rectangle,
or if a given rectangle overlaps the rectangle. 
September 19, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Rectangle2D{
   //instance variables
   private double xpos, ypos, width, height;
   public Rectangle2D(){
   xpos = 0.0; ypos = 0.0; width = 0.0; height = 0.0;
   }
   public Rectangle2D(double xpos, double ypos, double width, double height){//creates Rectangle object
      this.xpos = xpos;
      this.ypos = ypos;
      this.width = width;
      this.height = height;
   }
   //accessor methods
   public double getXPos(){
      return xpos;
   }
   public double getYPos(){
      return ypos;
   }
   public double getWidth(){
      return width;
   }
   public double getHeight(){
      return height;
   }
   //mutator methods
   public void setXPos(double xpos){
      this.xpos = xpos;
   }
   public void setYPos(double ypos){
      this.ypos = ypos;
   }
   public void setWidth(double width){
      this.width = width;
   }
   public void setHeight(double height){
      this.height = height;
   }
   //other methods
   public double getArea(){
      return width*height;
   }
   public double getPerimeter(){
      return 2*width+2*height;
   }
   public boolean contains(double x, double y){//determines if point is in rectangle
      return (x >= xpos && xpos <= xpos+width&& y >= ypos && y <= ypos+height);
   }
   public boolean contains(Rectangle2D r){//finds if top left corner and bottom right corner of r are contained
      return (contains(r.getXPos(), r.getYPos()) && contains(r.getXPos()+r.getWidth(), r.getYPos()+r.getHeight()));
   } 
   public boolean overlap(Rectangle2D r){
      //return true if the xpos and ypos of r is contains, but the whole rectangle isn't
      if(contains(r.getXPos(), r.getYPos()) && !contains(r))
         return true;
      //return true if r's xpos is less than this xpos and r's xpos and r's width is past this xpos
      //OR return true if r's ypos is less than this ypos and r's ypos and r's height is past this ypos
      if((r.getXPos()<xpos && (r.getXPos()+r.getWidth())>xpos) ||
         (r.getYPos()<ypos && (r.getYPos()+r.getHeight())>ypos))
         return true;
      return false;
   }     
}