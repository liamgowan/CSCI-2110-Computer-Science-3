//non-generic Node class
public class NodeN
{
	private int data;
	private NodeN next;
	public NodeN(int data, NodeN next)
	{
		this.data = data;
		this.next = next;
	}
	public int getData()
	{
		return data;
	}
	public NodeN getNext()
	{
		return this.next;
	}
	public void setData(int data)
	{
		this.data = data;
	}
	public void setNext(NodeN next)
	{
		this.next = next;
	}
	
}