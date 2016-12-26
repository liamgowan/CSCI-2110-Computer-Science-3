/*Assignment2, Team, CSCI 2110
This is a typical node list class, provided in lab.
October 26, 2015
Liam Gowan B00673126
This is NOT my own work. It was given in lab.
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