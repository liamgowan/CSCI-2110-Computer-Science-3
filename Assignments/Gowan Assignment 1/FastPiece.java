/*Assignment1, FastPiece, CSCI 2110
FastPiece.java extends Piece.java. It has a contructor which creates a FastPiece and Piece object. It has
a move method which, if allowed, will change the position of the Piece horizontally for a given amount
of steps.
October 4, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class FastPiece extends Piece{
   public FastPiece(String n, String c, String t, int x, int y){
      super(n,c,t,x,y);
   }
   public boolean move(String direction, int n){
      /*Method takes in a direction and an integer, if there is enough space, it will move in that 
      direction n times*/
      if(direction.equals("right")){
         if(super.getXPos()+n<=7){
            super.setXPos(super.getXPos()+n);
            return true;
          }
      }
      if(direction.equals("left")){
         if(super.getXPos()+n>=0){
            super.setXPos(super.getXPos()-n);
            return true;
          }
      }
      return false;
   }
}