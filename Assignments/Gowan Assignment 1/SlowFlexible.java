/*Assignment1, SlowFlexible, CSCI 2110
SlowFlexible.java extends SlowPiece.java. It has a contructor which creates a SlowFlexible and a SlowPiece (as well as 
and Piece object). It has a move method which, if allowed, will change the position of the Piece horizontally
or vertically.
October 4, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class SlowFlexible extends SlowPiece{
   public SlowFlexible(String n, String c, String t, int x, int y){
      super(n,c,t,x,y);
   }
   public boolean move(String direction){
      /*Method takes in a direction, if there is enough space, it will move once in that direction*/
      if(direction.equals("right")||direction.equals("left"))
         return(super.move(direction));
      else if(direction.equals("up")){
         if(super.getYPos()>0){
            super.setYPos(super.getYPos()-1);
            return true;
         }
         return false;
      }
      else if(direction.equals("down")){
         if(super.getYPos()<7){
            super.setYPos(super.getYPos()+1);
            return true;
         }
         return false;
      }
      return false;
   }
}           