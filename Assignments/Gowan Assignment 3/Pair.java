/*Assignment 3, CSCI 2110
Pair.java contains information about Pair objects. It contains the value of a certain char, the probability of a pair, the number 
of times that number appears, and the total number of Pair objects. Has getters, setters, and increase methods.
November 12, 2015
Liam Gowan B00673126
This is entirely my own work
*/
public class Pair {
	private char value;
	private double prob;
	private int num;
	public static double totalNum=0;
	public Pair(char value){//constructor
		this.value = value;
		num=1;
	}
	public char getValue() {
		return value;
	}
	public void setValue(char value) {
		this.value = value;
	}
	public double getProb() {
		return prob;
	}
	public void setProb(double prob) {
		this.prob = prob;
	}
	public double getTotalPairs(){
		return totalNum;
	}
	public int getNum(){
		return num;
	}
	public void increaseNum(){
		num++;
	}
	public void increaseTotalNum(){
		totalNum++;
	}
	public void calcProb(){
		//calculates frequency, rounds to 3 decimal places.
		prob = num/totalNum;
		int r = (int) Math.round(prob*1000);
		prob = r/1000.0;
	}
	public String toString(){
		return "Character: " + value + " Num: " + num + " Probability: " + prob;
	}
	
}
