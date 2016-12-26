/*Lab 4, Exercise 2, CSCI 2110
QueueClient.java is a client program for Queue.java, it tests out it's methods.
October 15, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class QueueClient {
	public static void main(String[] args){
		Queue<String> q = new Queue<String>();
		q.enqueue("Hello");
		q.enqueue("Goodbye");
		q.enqueue("Cake");
		q.enqueue("Hello");
		q.enqueue("Dog");
		q.enqueue("Hello");
		System.out.println(q.first());
		System.out.println(q.next());
		System.out.println(q.dequeue());
		System.out.println("Is the queue empty? " + q.isEmpty());
		System.out.println("The queue has " + q.size() + " elements.");
		System.out.println("Hello first appears at position " + q.positionOf("Hello"));
		q.remove("Hello");
		System.out.println("Hello first appears at position " + q.positionOf("Hello"));
		System.out.println("Peeking ---" + q.peek());
		q.clear();
		System.out.println("Peeking ---" + q.peek());
		System.out.println("Is the queue empty? " + q.isEmpty());
	}
}
