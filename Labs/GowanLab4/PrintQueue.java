/*Lab 4, Exercise 2, CSCI 2110
PrintQueue.java implements a Queue to form a PrintQueue, which has methods to add Jobs, display the information
about all jobs, to take a jobId and remove the first item from queue if the jobId matches, and to remove all
items of a given name.
October 15, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class PrintQueue {
	private Queue<Job> q;
	public PrintQueue(){
		q = new Queue<Job>();
	}
	public void lbr(String owner, int jobId){//makes Job object, enqueues it
		Job j = new Job(owner, jobId);
		q.enqueue(j);
	}
	public void lpq(){//displays all Job information in queue
		if(q.isEmpty())
			System.out.println("Error - Queue empty");
		else if(q.size()==1){
			String owner = q.first().getOwner();
			int jobId = q.first().getJobId();
			System.out.printf("%-20s"+ "%s",owner,jobId);
		}
		else{
			String owner = q.first().getOwner();
			int jobId = q.first().getJobId();
			System.out.printf("%-20s"+ "%s\n",owner,jobId);
			for(int i=0; i<q.size()-1; i++){
				Job j = q.next();
				owner = j.getOwner();
				jobId = j.getJobId();
				System.out.printf("%-20s"+ "%s\n",owner,jobId);
			}
		}
	}
	public void lprm(int jobId){//takes jobId, if it matches first object in queue program removes it
		if(q.isEmpty())
			System.out.println("Error - Empty Queue");
		else if(jobId == q.first().getJobId())
			q.removeAt(0);
		else
			System.out.println("Error - Front of queue does not have job ID: " + jobId);
	}
	public void lprmAll(String owner){
		/*Method creates a deep copy of q called q2, and then a for loop dequeues it and assigns to a Job
		 object, and if the owner name of the Job being dequeued is the same as this.owner, then that will
		 be removed from q.
		 */
		Queue<Job> q2 = new Queue<Job>();
		int m = q.size();
		q2.enqueue(q.first());
		for(int i=0; i<m-1;i++){
			q2.enqueue(q.next());
		}
		for(int i=0; i<m; i++){
			Job j = q2.dequeue();
			if(j.getOwner().equals(owner)){ 
				q.remove(j);
			}
		}
	}
}
