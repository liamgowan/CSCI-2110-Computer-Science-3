/*Assignment2, NHLStatsDemo, CSCI 2110
NHLStatsDemo.java tests the methods in the NHLStats.java program by making an object of it, reading in input
from "nhlstats.txt" and outputting new information out to "nhlstatsoutput.txt".
October 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.StringTokenizer;
import java.io.*;
import java.util.Scanner;
public class NHLListDemo {
	public static void main(String[] args) throws IOException{
		NHLStats n = new NHLStats(); //creates NHLStats object
		//The following sets everything needed for file reading and writing 
		File file = new File("nhlstats.txt");
		File outputFile = new File("nhlstatsoutput.txt");
		FileWriter fw = new FileWriter(outputFile);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(fw);
		//Prints headers
		bw.write("Name          Position  Team   GP     G      A      PIM    SOG    GWG    P      P/G    PCT\n");
		String s = "";
		StringTokenizer st;
		s = br.readLine();
		while(s!=null){//When the line read equals null, do this
			st = new StringTokenizer(s);
			while(st.hasMoreTokens()){//when there are still more tokens, do this
				//creates a PlayerRecord object and writes it's toString method to output file.
				String name, position, team;
				int gp, g, a, pim, sog, gwg;
				name = st.nextToken();
				position = st.nextToken();
				team = st.nextToken();
				gp = Integer.parseInt(st.nextToken());
				g = Integer.parseInt(st.nextToken());
				a = Integer.parseInt(st.nextToken());
				pim = Integer.parseInt(st.nextToken());
				sog = Integer.parseInt(st.nextToken());
				gwg = Integer.parseInt(st.nextToken());
				PlayerRecord pr = new PlayerRecord(name,position,team,gp,g,a,pim,sog,gwg);
				n.addPlayerRecord(pr);
				bw.write(pr.toString());
			}
			s = br.readLine();//reads the next line from input file
		}
		//writes to file the players with most points, most penalty minutes, most game winning goals,
		//most shots on goals, and teams with most penalty minutes and most and least game winning goals.
		bw.write(n.highestPoints()+"\n");
		bw.write(n.mostAggressive()+"\n");
		bw.write(n.MVP()+"\n");
		bw.write(n.mostPromising()+"\n");
		bw.write(n.teamWithMostPenaltyMinutes()+"\n");
		bw.write(n.teamWithMostGWG()+"\n");
		bw.write(n.teamWithLeastGWG());
		bw.close();//closes the BufferedWriter object.
	}	
}
