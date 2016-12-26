/*Assignment1, PracticeMoves, CSCI 2110
PracticeMoves.java is a client program for Board.java. It creates a Board object. Using a while loop,
it asks user for commands. The "create" command will ask for information on a piece to be created, and
the Board object method to add a new piece will be called. The "move" command can move pieces. The "display"
command will display all pieces on the board. The "help" command will show all commands that can be used.
The "exit" command will satisfy the while loop, and exit the program.
October 4, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
public class PracticeMoves{
   public static void main(String[] args){
      Board b = new Board();
      Scanner input = new Scanner(System.in);
      String command = "";
      System.out.println("Welcome to PracticeMoves.java. \nFrom here you may create pieces, by tying " +
                         "\"create\", and move them by typing \"move\". \nTo display the board, " +
                         "type \"display\". For help, type \"help\". " + "To exit, type \"exit\".\n");
      while(!command.equals("exit")){
         System.out.print("Enter command: ");
         command = input.nextLine();
         if(command.equals("create")){
            String name="";
            String colour="";
            String type="";
            int xPos=0;
            int yPos=0;
            //Prompts for name, ensures it's less than 8 characters
            System.out.print("Enter a name with no more than 8 characters: ");
            name = input.nextLine();
            while(name.length()>8){
               System.out.print("Error - Please enter a name with no more than 8 characters: ");
               name = input.nextLine();
            }
            //asks for piece type, ensures it's valid
            System.out.println("Your piece may be one of the following types: ");
            System.out.println("A slow piece, which can move left or right, one move at a time. (Enter \"s\")");
            System.out.println("A slow flexible piece, which can move any direction, one move at a time. (Enter \"sf\")");
            System.out.println("A fast piece, which can move any direction, one move at a time. (Enter \"f\")");
            System.out.println("A fast flexible piece, which can move any direction, multiple moves at a time. (Enter \"ff\")");
            System.out.print("Enter piece type: ");
            type = input.nextLine();
            while(!type.equals("s")&&!type.equals("sf")&&!type.equals("f")&&!type.equals("ff")){
               System.out.print("Error - Please type \"s\", \"sf\", \"f\" or \"ff\": ");
               type = input.nextLine();
            }
            //Will take only the first letter if user tries to put it more than 1
            System.out.print("Enter the first letter of a colour: ");
            colour ="" + input.nextLine().charAt(0);
            //Asks for x and y pos, ensures user entry is between 1 and 8, then subtracts 1 from both
            System.out.print("Enter the X position (1-8): ");
            xPos = input.nextInt()-1;
            while(xPos<0||xPos>7){
               System.out.print("Error - Please enter the X position (1-8): ");
               xPos = input.nextInt()-1;
            }
            System.out.print("Enter the Y position (1-8): ");
            yPos = input.nextInt()-1;
            while(yPos<0||yPos>7){
               System.out.print("Error - Please enter the Y position (1-8): ");
               yPos = input.nextInt()-1;
            }
            input.nextLine();
            //tries to add the new piece, if it can't it will display error message
            if(!b.addNew(type,name,colour,xPos,yPos))
               System.out.println("Creation error - piece already at this position");
         }
         if(command.equals("display"))//displays pieces on board
            b.display();
         if(command.equals("move"))
            if(!b.movePiece())//will attempt to move a piece, if not it will display error message
               System.out.println("Error - move not allowed");
         if(command.equals("help")){//displays all available commands
            System.out.println("**********************************************HELP****************************************************");
            System.out.println("Type \"create\" to create new pieces on the board");
            System.out.println("Type \"move\" to move pieces on the board");
            System.out.println("Type \"display\" to display pieces on the board");
            System.out.println("Type \"help\" for a list of intructions");
            System.out.println("Type \"exit\" to close the program");
            System.out.println("**********************************************HELP****************************************************");
         }
      } 
      System.out.println("Thank you for using the program.");       
   }
}