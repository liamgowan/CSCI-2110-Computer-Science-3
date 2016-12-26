/*Assignment1, Board, CSCI 2110
Board.java contains a 2D 8*8 array of Piece objects. It has a method to create new Piece objects,
that either be just SlowPiece objects, SlowFlexible objects, just FastPiece objects or FastFlexible
objects. It has a method to move pieces to a different position, depending on what kind
of type is. Finally it has a method to display all elements of the board, in an 8*8 fashion.
October 4, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
public class Board{
   public Piece[][] board = new Piece[8][8];
   private Scanner input = new Scanner(System.in);
   public Board(){}
   public boolean addNew(String type, String name, String colour, int xPos, int yPos){
      /* If the position at the given x and y Position is null, then it will check to see
      what type of piece was inputted by user, and will the appropiate object of that type using 
      generics at the given spot. Otherwise, it will return false. */
      if(board[yPos][xPos]==null){
         if(type.equals("s")){
             board[yPos][xPos] = new SlowPiece(name, colour, "S",  xPos, yPos);
             return true;
         }
         else if(type.equals("sf")){
            board[yPos][xPos] = new SlowFlexible(name, colour, "SF", xPos, yPos);
            return true;
         }
         else if(type.equals("f")){
            board[yPos][xPos] = new FastPiece(name, colour, "F", xPos, yPos);
            return true;
         }
         else if(type.equals("ff")){
            board[yPos][xPos] = new FastFlexible(name, colour, "FF", xPos, yPos);
            return true;
         }
      }
      return false;
   }
   public boolean movePiece(){
      /*First this method asks the user for an x and y position, and makes sure that both values are
      between 1-8, and then subtracts one from each. */
      Scanner input = new Scanner(System.in);
      String direction;
      int newX, newY, xPos, yPos;
      newX=0; newY=0; xPos=0; yPos=0;
      System.out.print("Enter current X position of piece: ");
      xPos = input.nextInt();
      while(xPos>8||xPos<1){
         System.out.println("Error - X position out of bounds");
         System.out.print("Enter current X position of piece: ");
         xPos = input.nextInt();
      }
      System.out.print("Enter current Y position of piece: ");
      yPos = input.nextInt();
      while(yPos>8||yPos<1){
         System.out.println("Error - Y position out of bounds");
         System.out.print("Enter current Y position of piece: ");
         yPos = input.nextInt();
      }
      input.nextLine();
      xPos = xPos -1;
      yPos = yPos -1;
      /*Next, if the piece at the given location is only a SlowPiece, it will ask the user if they want
      to remove left or right. It will call the SlowPieces move method, and if possible, it will move the
      pieces location either once to the left, or once to the right. The previous location will be set
      to null.*/
      if(board[yPos][xPos] instanceof SlowPiece && board[yPos][xPos] instanceof SlowFlexible==false){
         SlowPiece sp = (SlowPiece)board[yPos][xPos];
         System.out.print("Would you like to move \"left\" or \"right?\": ");
         direction = input.nextLine();
         while(!direction.equals("left") && !direction.equals("right")){
            System.out.println("You must type in \"left\" or \"right\".");
            System.out.print("Would you like to move \"left\" or \"right?\": ");
            direction = input.nextLine();
         }
         if(direction.equals("right"))
            newX=sp.getXPos()+1;
         else
            newX=sp.getXPos()-1;
         if(sp.move(direction) && board[yPos][newX]==null){
            board[yPos][newX] = board[yPos][xPos];
            board[yPos][xPos] = null;
            return true;
         }   
         return false;
      }
      /*if the piece at the given location is only a SlowFlexible object, it will ask the user if they want
      to remove left,right, up, or down. It will call the SlowFlexible move method, and if possible, it will 
      move the pieces location either once left, right, up or down. The previous location will be set to null.*/
      if(board[yPos][xPos] instanceof SlowFlexible){
         SlowFlexible sp = (SlowFlexible)board[yPos][xPos];
         System.out.print("Would you like to move \"left\", \"right?\", \"up\", or \"down\"?: ");
         direction = input.nextLine();
         while(!direction.equals("left") && !direction.equals("right") && !direction.equals("up") && !direction.equals("down")){
            System.out.println("You must type in \"left\", \"right?\", \"up\", or \"down\".");
            System.out.print("Would you like to move \"left\", \"right?\", \"up\", or \"down\"?: ");
            direction = input.nextLine();
         }
         if(direction.equals("right"))
            newX=sp.getXPos()+1;
         else if(direction.equals("left"))
            newX=sp.getXPos()-1;
         else if(direction.equals("up"))
            newY=sp.getYPos()-1;
         else if(direction.equals("down"))
            newY=sp.getYPos()+1;
         if(direction.equals("right")||direction.equals("left")){
            if(sp.move(direction) && board[yPos][newX]==null){
               board[yPos][newX] = board[yPos][xPos];
               board[yPos][xPos] = null;
               return true;
            }   
            return false;
         }
         if(direction.equals("up")||direction.equals("down")){
            if(sp.move(direction) && board[newY][xPos]==null){
               board[newY][xPos] = board[yPos][xPos];
               board[yPos][xPos] = null;
               return true;
            }   
            return false;
         }
      }
      /*if the piece at the given location is only a FastPiece, it will ask the user if they want
      to remove left or right, and by how many spaces. It will call the FastPieces move method, and 
      if possible, it will move the pieces location n amount of times to either the left or right, and 
      the previous location will be set to null.*/
      if(board[yPos][xPos] instanceof FastPiece && board[yPos][xPos] instanceof FastFlexible==false){
         FastPiece sp = (FastPiece)board[yPos][xPos];
         System.out.print("Would you like to move \"left\" or \"right?\": ");
         direction = input.nextLine();
         while(!direction.equals("left") && !direction.equals("right")){
            System.out.println("You must type in \"left\" or \"right\".");
            System.out.print("Would you like to move \"left\" or \"right?\": ");
            direction = input.nextLine();
         }
         System.out.print("Enter amount to by (1-7): ");
         int moveCount = input.nextInt();
         while(moveCount>7||moveCount<0){
            System.out.println("Error - you can only move 1 to 7 spaces");
            System.out.print("Enter amount to by (1-7): ");
            moveCount = input.nextInt();
         }
         if(direction.equals("right"))
            newX=sp.getXPos()+moveCount;
         else
            newX=sp.getXPos()-moveCount;
         if(sp.move(direction, moveCount) && board[yPos][newX]==null){
            board[yPos][newX] = board[yPos][xPos];
            board[yPos][xPos] = null;
            return true;
         }   
         return false;
      }
      /*if the piece at the given location is a FastFlexible object, it will ask the user if they want
      to remove left,right, up, or down, and by how many spaces. It will call the SlowFlexible move method, and if possible, it will 
      move the pieces location n amount of times to the left, right, up or down. The previous location will be set to null.*/
      if(board[yPos][xPos] instanceof FastFlexible){
         FastFlexible sp = (FastFlexible)board[yPos][xPos];
         System.out.print("Would you like to move \"left\", \"right?\", \"up\", or \"down\"?: ");
         direction = input.nextLine();
         while(!direction.equals("left") && !direction.equals("right") && !direction.equals("up") && !direction.equals("down")){
            System.out.println("You must type in \"left\", \"right?\", \"up\", or \"down\".");
            System.out.print("Would you like to move \"left\", \"right?\", \"up\", or \"down\"?: ");
            direction = input.nextLine();
         }
         System.out.print("Enter amount to by (1-7): ");
         int moveCount = input.nextInt();
         while(moveCount>7||moveCount<0){
            System.out.println("Error - you can only move 1 to 7 spaces");
            System.out.print("Enter amount to by (1-7): ");
            moveCount = input.nextInt();
         }
         if(direction.equals("right"))
            newX=sp.getXPos()+moveCount;
         else if(direction.equals("left"))
            newX=sp.getXPos()-moveCount;
         else if(direction.equals("up"))
            newY=sp.getYPos()-moveCount;
         else if(direction.equals("down"))
            newY=sp.getYPos()+moveCount;
         if(direction.equals("right")||direction.equals("left")){
            if(sp.move(direction, moveCount) && board[yPos][newX]==null){
               board[yPos][newX] = board[yPos][xPos];
               board[yPos][xPos] = null;
               return true;
            }   
            return false;
         }
         if(direction.equals("up")||direction.equals("down")){
            if(sp.move(direction, moveCount) && board[newY][xPos]==null){
               board[newY][xPos] = board[yPos][xPos];
               board[yPos][xPos] = null;
               return true;
            }   
            return false;
         } 
         return false;
      }
      return false;
   }
         
   public void display(){
      /*this method uses a double for loop to display all elements of the Piece array, using 13 character
      spacing */
      String toDisplay = "";
      for(int i=0; i<8; i++){
         for(int j=0; j<8; j++){
            if(board[i][j]==null)
               toDisplay = "-";
            else{
               toDisplay = board[i][j].toString();
            }
            System.out.printf("%-13s", toDisplay);
         }
         System.out.println();
      }
   }              
}
   