/*Assignment 4, Process, CSCI 2110
Process.java holds information about a process, getters and setters and a toString method.
November 28, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Process {
	private int id;
	private int timeReq;
	private int priority;
	private int timeArrival;
	
	public Process(int id, int timeReq, int priority, int timeArrival){
		this.id=id; this.timeReq=timeReq; this.priority=priority; this.timeArrival=timeArrival;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTimeReq() {
		return timeReq;
	}
	public void setTimeReq(int timeReq) {
		this.timeReq = timeReq;
	}
	public int getPriority() {
		return priority;
	}
	public void setPriority(int priority) {
		this.priority = priority;
	}
	public int getTimeArrival() {
		return timeArrival;
	}
	public void setTimeArrival(int timeArrival) {
		this.timeArrival = timeArrival;
	}
	public String toString(){
		return "("+id+", "+timeReq+", "+priority+")";
	}
}