/*Assignment2, Team, CSCI 2110
Team.java stores information about a team, regarding the team name, penalty minutes total and total game w
winning goals. It has get and set methods, and methods to add to the penalty minutes and total game winning
goals. It's constructor sets the team name and penalty minutes/game winning goals to zero.
October 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Team {
	//instance variables
	private String teamName;
	private int penaltyMinutes;
	private int totalGWG;
	public Team(String teamName){
		this.teamName = teamName;
		penaltyMinutes = 0;
		totalGWG = 0;
	}
	public void addToPenaltyMinutes(int num){
		penaltyMinutes = penaltyMinutes + num;
	}
	public void addToTotalGWG(int num){
		totalGWG = totalGWG + num;
	}
	public String getTeamName() {
		return teamName;
	}
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	public int getPenaltyMinutes() {
		return penaltyMinutes;
	}
	public void setPenaltyMinutes(int penaltyMinutes) {
		this.penaltyMinutes = penaltyMinutes;
	}
	public int getTotalGWG() {
		return totalGWG;
	}
	public void setTotalGWG(int totalGWG) {
		this.totalGWG = totalGWG;
	}
}
