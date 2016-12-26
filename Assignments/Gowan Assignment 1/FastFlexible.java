/*Assignment1, FastFlexible, CSCI 2110
FastPiece.java extends Piece.java. It has a contructor which creates a FastPiece and Piece object. It has
a move method which, if allowed, will change the position of the Piece horizontally or vertically for
a given number of steps.
October 4, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class FastFlexible extends FastPiece{
   public FastFlexible(String n, String c, String t, int x, int y){
      super(n,c,t,x,y);
   }
   public boolean move(String direction, int n){
      /*Method takes in a direction and an integer, if there is enough space, it will move in that 
      direction n times*/
      if(direction.equals("right")||direction.equals("left"))
         return(super.move(direction, n));
      else if(direction.equals("up")){
         if(super.getYPos()+n>0){
            super.setYPos(super.getYPos()-n);
            return true;
         }
         return false;
      }
      else if(direction.equals("down")){
         if(super.getYPos()+n<7){
            super.setYPos(super.getYPos()+n);
            return true;
         }
         return false;
      }
      return false;
   }
}