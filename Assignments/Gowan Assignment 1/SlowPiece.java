/*Assignment1, SlowPiece, CSCI 2110
SlowPiece.java extends Piece.java. It has a contructor which creates a SlowPiece and Piece object. It has
a move method which, if allowed, will change the position of the Piece horizontally.
October 4, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class SlowPiece extends Piece{
   public SlowPiece(String n, String c, String t,  int x, int y){
      super(n,c,t,x, y);
   }
   public boolean move(String direction){
      /*Method takes in a direction, if there is enough space, it will move once in that direction*/
      if(direction.equals("right")){
         if(super.getXPos()<7){
            super.setXPos(super.getXPos()+1);
            return true;
          }
      }
      if(direction.equals("left")){
         if(super.getXPos()>0){
            super.setXPos(super.getXPos()-1);
            return true;
          }
      }
      return false;
   }
} 