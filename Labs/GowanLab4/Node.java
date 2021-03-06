/*Lab 4, Exercise 1 & 2, CSCI 2110
Node.java stores accepts any kind of object, stores the data, and the reference for the next node in the 
sequence. It has accessor and mutator methods.
October 15, 2015
Liam Gowan B00673126
This is NOT my work. It was provided in the lab.
*/
public class Node<T>
{
	private T data;
	private Node<T> next;
	public Node(T data, Node<T> next)
	{
		this.data = data;
		this.next = next;
	}
	public T getData()
	{
		return data;
	}
	public Node<T> getNext()
	{
		return this.next;
	}
	public void setData(T data)
	{
		this.data = data;
	}
	public void setNext(Node<T> next)
	{
		this.next = next;
	}
	
}
