/*Assignment2, PlayerRecord, CSCI 2110
PlayerRecord.java contains the following information about a hockey player: name, position, team,
games played, goals, assists, penalty minutes, shots on goal, game winning goals, points, points per game
and percentage of successful shots. It contains a constructor, get and set methods, methods to calculate
points, points per game and percentage of successful shots, and a toString method.
October 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class PlayerRecord {
	//instance variables
	private String name;
	private String position;
	private String team;
	private int gp;
	private int g;
	private int a;
	private int pim;
	private int sog;
	private int gwg;
	private int p;
	private double pg;
	private double pct;
	
	public PlayerRecord(String name, String position, String team, int gp, int g, int a, int pim, int sog, int gwg){
		this.name=name;
		this.position=position;
		this.team=team;
		this.gp=gp;
		this.g=g; 
		this.a=a;
		this.pim=pim;
		this.sog=sog;
		this.gwg=gwg;
		findPoints();
		findPointsPerGame();
		findShootingPercentage();
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getGp() {
		return gp;
	}

	public void setGp(int gp) {
		this.gp = gp;
	}

	public int getG() {
		return g;
	}

	public void setG(int g) {
		this.g = g;
	}

	public int getA() {
		return a;
	}

	public void setA(int a) {
		this.a = a;
	}

	public int getPim() {
		return pim;
	}

	public void setPim(int pim) {
		this.pim = pim;
	}

	public int getSog() {
		return sog;
	}

	public void setSog(int sog) {
		this.sog = sog;
	}

	public int getGwg() {
		return gwg;
	}

	public void setGwg(int gwg) {
		this.gwg = gwg;
	}
	public int getP(){
		return p;
	}
	public double getPG(){
		return pg;
	}
	public double getPCT(){
		return pct;
	}
	public void findPoints(){
		//calculates points
		p = g+a;
	}
	public void findPointsPerGame(){
		pg = (double)p/gp;//calculates points per game
	}
	public void findShootingPercentage(){
		pct = (double)g/sog*100;//calculates percentage of successful shots
	}	
	public String toString(){//returns all attributes in a proper format
		return String.format("%-14s%-10s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7s%-7.2f%.2f \n",name,position,team,gp,g,a,pim,sog,gwg,p,pg,pct);
	}
}
