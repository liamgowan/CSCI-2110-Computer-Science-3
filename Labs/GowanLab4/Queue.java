/*Lab 4, Exercise 1 & 2, CSCI 2110
Queue.java implements a LinkedList to form a queue data structure. It has methods to add a new item object
to the queue, to remove and return the first item of the queue, to return the size, to say if the queue is 
empty, to clear the queue, to return the first item in the queue without removing it, to get the index of
a given item, to remove the first occurrence of a given item, to remove the item at a particular index, to 
view the first item and make the cursor 1, and to view the next item according to the cursor and increase 
cursor by 1.
October 15, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class Queue<T>{
	private LinkedList<T> list;
	int cursor;
	public Queue(){
		cursor = 0;
		list = new LinkedList<T>();
	}
	public void enqueue(T item){
		list.addToEnd(item);
	}
	public T dequeue(){//If the list isn't empty, it will return the front item from list, and remove it,
		//otherwise return null
		if(!isEmpty()){
			T data = list.getFront().getData();
			list.remove(data);
			return data;
		}
		return null;
	}
	public int size(){
		return list.size();
	}
	public boolean isEmpty(){
		if(list.isEmpty())
			return true;
		return false;
	}
	public void clear(){
		list.clear();
	}
	public T peek(){
		if(isEmpty())
			return (T)"Empty Queue";
		return list.getFront().getData();
	}
	public int positionOf(T item){
		return list.indexOf(item);
	}
	public void remove(T item){
		list.remove(item);
	}
	public void removeAt(int index){
		list.removeAt(index);
	}
	public T first(){
		//sets cursor to 1, and returns first item in list without removing it
		cursor=1;
		return peek();
	}
	public T next(){//increases cursor by 1, and returns item at index (cursor-1)
		cursor++;
		return list.getAt(cursor-1);
	}	
}
