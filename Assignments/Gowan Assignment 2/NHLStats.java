/*Assignment2, NHLStats, CSCI 2110
NHLStats.java creates a list, which accepts PlayerRecord objects. It has methods to add PlayerRecord objects
to tell if the list is empty, to return the first item in list, and the next item in the list, to 
enumerate, to find the player with most amount of points, to find the player with the most amount of 
penalty points, to find the MVP, to find the most promising player, to find the team with the most
penalty minutes among all players, to find the teams with most and least amount of game winning goals.
October 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.ArrayList;
public class NHLStats {
	private List<PlayerRecord> playerList;
	public NHLStats(){
		playerList = new List<PlayerRecord>();
	}
	public void addPlayerRecord(PlayerRecord pr){
		playerList.add(pr);
	}
	public boolean isEmpty(){
		return playerList.isEmpty();
	}
	public PlayerRecord first(){
		return playerList.first();
	}
	public PlayerRecord next(){
		return playerList.next();
	}
	public void enumerate(){
		playerList.enumerate();
	}
	public String highestPoints(){
		//Method finds the player(s) with most amount of points and returns name and their team.
		ArrayList<String> namesAndTeam = new ArrayList<String>();
		//The following finds the highest score, and saves to num
		int highest = first().getP();
		for(int i=1; i<playerList.size(); i++){
			int num = next().getP();
			if(num>highest)
				highest = num;
		}
		//The following adds all players and team strings to namesAndTeam ArrayList if they have
		//the correct amount of points.
		if(first().getP()==highest)
			namesAndTeam.add("Player: " + first().getName() +" from Team: " + first().getTeam()+"\n");
		for(int i=1; i<playerList.size(); i++){
			PlayerRecord pr = next();
			if(pr.getP()==highest)
				namesAndTeam.add("Player: " + pr.getName() +" from Team: " + pr.getTeam()+"\n");
		}
		//returns correct String
		String result="";
		for(int i=0; i<namesAndTeam.size(); i++)
			result = result + namesAndTeam.get(i);
		return "Players with highest points and their teams: \n" + result;	
	}
	public String mostAggressive(){
		//Method finds the player(s) with most amount of penalty minutes and returns name, team and position.
		ArrayList<String> namesTeamAndPosition = new ArrayList<String>();
		//The following finds the highest amount of penalty minutes, and saves to num
		int highest = first().getPim();
		for(int i=1; i<playerList.size(); i++){
			int num = next().getPim();
			if(num>highest)
				highest = num;
		}
		//The following adds all players and team strings to namesAndTeam ArrayList if they have
		//the correct amount of penalty minutes.
		if(first().getP()==highest)
			namesTeamAndPosition.add("Player: " + first().getName() +" from Team: " + first().getTeam()+" Position: " +first().getPosition() + "\n");
		for(int i=1; i<playerList.size(); i++){
			PlayerRecord pr = next();
			if(pr.getPim()==highest)
				namesTeamAndPosition.add("Player: " + pr.getName() +" from Team: " + pr.getTeam()+" Position: " +pr.getPosition()+"\n");
		}
		String result="";
		//returns correct String
		for(int i=0; i<namesTeamAndPosition.size(); i++)
			result = result + namesTeamAndPosition.get(i);
		return "Most aggressive players, their teams and their positions: \n" + result;	
	}
	public String MVP(){
		//Method finds the player(s) with most amount of game winning goals and returns name, team.
		ArrayList<String> namesTeam = new ArrayList<String>();
		//The following finds the highest amount of game winning goals, and saves to num
		int highest = first().getGwg();
		for(int i=1; i<playerList.size(); i++){
			int num = next().getGwg();
			if(num>highest)
				highest = num;
		}
		//The following adds all players and team strings to namesAndTeam ArrayList if they have
		//the correct amount of goal winning goals.
		if(first().getGwg()==highest)
			namesTeam.add("Player: " + first().getName() +" from Team: " + first().getTeam()+"\n");
		for(int i=1; i<playerList.size(); i++){
			PlayerRecord pr = next();
			if(pr.getGwg()==highest)
				namesTeam.add("Player: " + pr.getName() +" from Team: " + pr.getTeam()+"\n");
		}
		//returns correct String
		String result="";
		for(int i=0; i<namesTeam.size(); i++)
			result = result + namesTeam.get(i);
		return "Most valuable players and their teams: \n" + result;	
	}
	public String mostPromising(){
		//Method finds the player(s) with most amount of shots on goals and returns name, team.
		ArrayList<String> namesTeam = new ArrayList<String>();
		//The following finds the highest amount of shots on goals, and saves to num
		int highest = first().getSog();
		for(int i=1; i<playerList.size(); i++){
			int num = next().getSog();
			if(num>highest)
				highest = num;
		}
		//The following adds all players and team strings to namesAndTeam ArrayList if they have
		//the correct amount of shots on goals.
		if(first().getSog()==highest)
			namesTeam.add("Player: " + first().getName() +" from Team: " + first().getTeam()+"\n");
		for(int i=1; i<playerList.size(); i++){
			PlayerRecord pr = next();
			if(pr.getSog()==highest)
				namesTeam.add("Player: " + pr.getName() +" from Team: " + pr.getTeam()+"\n");
		}
		//returns correct String
		String result="";
		for(int i=0; i<namesTeam.size(); i++)
			result = result + namesTeam.get(i);
		return "Most promising players and their teams: \n" + result;	
	}
	public String teamWithMostPenaltyMinutes(){
		//Method finds the team(s) with most amount of penalty minutes and returns Team name, and penalty minutes
		ArrayList<String> namesOfTeams = new ArrayList<String>();
		ArrayList<Team> teams = new ArrayList<Team>();
		//The following creates an ArrayList of all Team objects if there is not already a Team object
		//with the team name in question. It also adds the penalty minutes to each Team object
		String teamName = first().getTeam();
		namesOfTeams.add(teamName);
		Team t = new Team(first().getTeam());
		teams.add(t);
		teams.get(0).addToPenaltyMinutes(first().getPim());
		for(int i=1; i<playerList.size(); i++){
			PlayerRecord pr = next();
			if(!namesOfTeams.contains(pr.getTeam())){
				t = new Team(pr.getTeam());
				namesOfTeams.add(pr.getTeam());
				teams.add(t);
			}
			else{
				int pos = namesOfTeams.indexOf(pr.getTeam());
				teams.get(pos).addToPenaltyMinutes(pr.getPim());
			}
		}
		//The following finds the the highest number of penalty points of the teams.
		int highest = teams.get(0).getPenaltyMinutes();
		for(int i=1; i<teams.size();i++){
			if(teams.get(i).getPenaltyMinutes()>highest)
				highest = teams.get(i).getPenaltyMinutes();
		}
		//Adds to String result if team in question has correct number of penalty minutes 
		String result="";
		for(int i=0; i<teams.size(); i++){
			if(teams.get(i).getPenaltyMinutes()==highest)
				result = result + teams.get(i).getTeamName() + " with " + teams.get(i).getPenaltyMinutes()+" penalty minutes\n";
		}
		return "Teams that had the most number of penalty minutes: \n" + result;	
	}
	public String teamWithMostGWG(){
		//Method finds the team(s) with most amount of game winning goals and returns Team name, and penalty minutes
		ArrayList<String> namesOfTeams = new ArrayList<String>();
		ArrayList<Team> teams = new ArrayList<Team>();
		//The following creates an ArrayList of all Team objects if there is not already a Team object
		//with the team name in question. It also adds the game winning goals to each Team object
		String teamName = first().getTeam();
		namesOfTeams.add(teamName);
		Team t = new Team(first().getTeam());
		teams.add(t);
		teams.get(0).addToTotalGWG(first().getGwg());
		for(int i=1; i<playerList.size(); i++){
			PlayerRecord pr = next();
			if(!namesOfTeams.contains(pr.getTeam())){
				t = new Team(pr.getTeam());
				namesOfTeams.add(pr.getTeam());
				teams.add(t);
			}
			else{
				int pos = namesOfTeams.indexOf(pr.getTeam());
				teams.get(pos).addToTotalGWG(pr.getGwg());
			}
		}
		//The following finds the the highest number of game winning goals of the teams.
		int highest = teams.get(0).getTotalGWG();
		for(int i=1; i<teams.size();i++){
			if(teams.get(i).getTotalGWG()>highest)
				highest = teams.get(i).getTotalGWG();
		}
		//Adds to String result if team in question has correct number of game winning goals
		String result="";
		for(int i=0; i<teams.size(); i++){
			if(teams.get(i).getTotalGWG()==highest)
				result = result + teams.get(i).getTeamName() + " with " + teams.get(i).getTotalGWG()+" goal winning goals!\n";
		}
		return "Teams that had the most number of game winning goals: \n" + result;	
	}
	public String teamWithLeastGWG(){
		//Method finds the team(s) with least amount of game winning goals and returns Team name, and penalty minutes
		ArrayList<String> namesOfTeams = new ArrayList<String>();
		ArrayList<Team> teams = new ArrayList<Team>();
		//The following creates an ArrayList of all Team objects if there is not already a Team object
		//with the team name in question. It also adds the game winning goals to each Team object
		String teamName = first().getTeam();
		namesOfTeams.add(teamName);
		Team t = new Team(first().getTeam());
		teams.add(t);
		teams.get(0).addToTotalGWG(first().getGwg());
		for(int i=1; i<playerList.size(); i++){
			PlayerRecord pr = next();
			if(!namesOfTeams.contains(pr.getTeam())){
				t = new Team(pr.getTeam());
				namesOfTeams.add(pr.getTeam());
				teams.add(t);
			}
			else{
				int pos = namesOfTeams.indexOf(pr.getTeam());
				teams.get(pos).addToTotalGWG(pr.getGwg());
			}
		}
		//The following finds the the lowest number of game winning goals of the teams.
		int lowest = teams.get(0).getTotalGWG();
		for(int i=1; i<teams.size();i++){
			if(teams.get(i).getTotalGWG()<lowest)
				lowest = teams.get(i).getTotalGWG();
		}
		//Adds to String result if team in question has correct number of game winning goals
		String result="";
		for(int i=0; i<teams.size(); i++){
			if(teams.get(i).getTotalGWG()==lowest)
				result = result + teams.get(i).getTeamName() + " with " + teams.get(i).getTotalGWG()+" goal winning goals\n";
		}
		return "Teams that had the least number of game winning goals: \n" + result;	
	}
}
