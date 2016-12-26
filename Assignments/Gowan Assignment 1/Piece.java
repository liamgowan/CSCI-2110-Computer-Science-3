/*Assignment1, Piece, CSCI 2110
Piece.java contains information about a particular piece object. It stores tha name, colour, type, x and y
position. It contains a constructor which sets all attributes, accessors and mutators, as well as a toString
method.
October 4, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Piece{
	//instance variables
	private String name;
	private String colour;
   private String type;
	private int xPos;
   private int yPos;
   //constructor
   public Piece(String name, String colour, String type, int x, int y){
      this.name = name; this.colour = colour; this.type = type;
      xPos = x; yPos = y;
   } 
   //accessor methods
   public String getName(){return name;}
   public String getColour(){return colour;}
   public String getType(){return type;}
   public int getXPos(){return xPos;}
   public int getYPos(){return yPos;}
   //mutator methods
   public void setName(String name){this.name = name;}
   public void setColour(String colour){this.colour = colour;}
   public void setType(String type){this.type = type;}
   public void setXPos(int x){
      xPos = x;
   }
   public void setYPos(int y){
      yPos = y;
   }
   public String toString(){
      return(colour + " " + name + " " + type);
   }
}