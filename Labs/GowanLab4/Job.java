/*Lab 4, Exercise 2, CSCI 2110
Job.java contains information the owner name and jobId of a job. It has accessory methods.
October 15, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Job{
	private String owner; 
	private int jobId;
	public Job(String o, int j) {
	owner = o;
	jobId = j; 
	}
	public String getOwner() {
	return owner; 
	}
	public int getJobId() {
	return jobId; 
	}
}
