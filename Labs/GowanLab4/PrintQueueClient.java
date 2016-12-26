/*Lab 4, Exercise 2, CSCI 2110
PrintQueueClient.java is a client program for PrintQueue.java, it tests out it's four methods.
October 15, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class PrintQueueClient{
	public static void main(String[] args){
		PrintQueue pq = new PrintQueue();
		pq.lbr("Liam Gowan", 63);
		pq.lbr("Jabran Umar", 20);
		pq.lbr("Jabran Umar", 421);
		pq.lbr("Thomas Laskey", 99);
		pq.lbr("Liam Gowan", 34);
		pq.lbr("Liam Gowan", 37);
		pq.lbr("Mason Maxwell", 8);
		pq.lbr("Noah Thompson", 88);
		pq.lbr("Jabran Umar", 35);
		pq.lbr("Jabran Umar", 36);
		pq.lbr("Noah Thompson", 82);
		pq.lbr("Noah Thompson", 98);
		pq.lbr("Liam Gowan", 38);
		pq.lbr("Liam Gowan", 39);
		pq.lpq();
		pq.lprmAll("Jabran Umar");
		System.out.println();
		pq.lpq();
		System.out.println();
		pq.lprm(63);
		pq.lprm(63);
		System.out.println();
		pq.lpq();
	}
}
