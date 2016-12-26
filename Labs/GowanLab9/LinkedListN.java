//Non-generic linked list
//uses the non-generic NodeN class
//each node stores integer data (key)
//keys are assumed to be positive (>0) integers
public class LinkedListN
{
	private NodeN head;
	private int count;
	
	public LinkedListN()
	{
		head = null;
		count=0;
	}
	public void add(int item)
	{
		NodeN itemnode = new NodeN(item, head);
		head = itemnode;
		count++;
	}
	public int size()
	{
		return count;
	}
	public void clear()
	{
		head = null;
		count=0;
	}
	public boolean isEmpty()
	{
		return (count==0);
	}
	public int getAt(int index)
	{
		NodeN curr = head;
		if (index<0||index>=count)
		{
			System.out.println("Can't set. Index out of bounds");
			System.exit(0);
		}
		else
		{
			
			for(int i=0; i<index; i++)
				curr = curr.getNext();
			
		}
		return curr.getData();
			

	}
	
	public void insertAt(int item, int index)
	{
		if (index<0||index>count)
		{
			System.out.println("Can't insert. Index out of bounds.");
			System.exit(0);
		}
		else
		{
			NodeN pred = head;
			if (index==0)
			{
				add(item);
				
				return;
			}
			for(int i=0;i<index-1;i++)
				pred = pred.getNext();
			NodeN itemnode = new NodeN(item,pred.getNext());
			pred.setNext(itemnode);
			count++;
		}
	}
	public void setAt(int item, int index)
	{
		if (index<0||index>=count)
		{
			System.out.println("Can't set. Index out of bounds");
			System.exit(0);
		}
		else
		{
			NodeN curr = head;
			for(int i=0;i<index;i++)
				curr = curr.getNext();
			curr.setData(item);
		}
	}
	public void enumerate()
	{
		NodeN curr = head;
	
		while (curr!=null)
		{
			System.out.print("-->" + curr.getData());
			curr = curr.getNext();
		}
		System.out.println();
	}
	
	public int indexOf(int item)
	{
		if (count==0)
			return -1;
		NodeN curr = head;
		for(int i=0;i<count;i++)
		{
			System.out.println("count: " + count + "\t" + "comparing " + curr.getData());
			if (item==curr.getData())
				return i;
			curr = curr.getNext();
		}
		return -1;
	}
	public int removeAt(int index)
	{
		int ret=0;
		if (index<0||index>=count)
		{
			System.out.println("Can't remove. Index out of bounds");
			System.exit(0);
		}
		else
		{
			
			if (index==0)
			{
				ret = head.getData();
				head = head.getNext();
			}
			else
			{
				NodeN prev = head;
				for(int i=0;i<index-1;i++)
					prev = prev.getNext();
				NodeN curr = prev.getNext();
				ret=curr.getData();
				prev.setNext(curr.getNext());
				curr.setNext(null);	
			}
			count--;
		}
		return ret;
	}
	
	public void remove (int item)
	{
		int i = indexOf(item);
		if (i==-1)
		{
			System.out.println("No such item");
			System.exit(0);
		}
		else
			removeAt(i);
	}
	
	public void removeAll(int item)
	{
		
		NodeN curr, prev=null;
		curr = head;
		while (curr!=null)
		{
			if (head.getData()==item)
			{
				head = head.getNext();
				curr = curr.getNext();
				count--;
			}
			else if (curr == head)
			{
				prev = curr;
				curr = curr.getNext();
			}
			else
			{
				if (curr!=null)
				{
					if (curr.getData()==item)
					{
						prev.setNext(curr.getNext());
						curr= prev.getNext();
						count--;
					}
					else
					{
					prev = curr;
					curr = curr.getNext();
					}
				}
			}
		}
	}
	
	public void addToEnd(int item)
	{
		NodeN itemnode = new NodeN(item, null);
		if (head==null)
			head = itemnode;
		else if (head.getNext()==null)
			head.setNext(itemnode);
		else
		{
			NodeN curr = head;
			while (curr.getNext()!=null)
				curr = curr.getNext();
			curr.setNext(itemnode);
		}
		count++;
	}
	
	


	
}