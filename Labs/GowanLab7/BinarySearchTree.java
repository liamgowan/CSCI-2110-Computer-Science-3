/*Lab 7, CSCI 2110
BinaryTreeSearch.java has had 8 methods added to it. These methods are used to find the smallest and largest key,
search for a key recursively, to test if a BinaryTree is a BinarySearchTree, to convert a BinaryTree to an ArrayList
and to merge two BinarySearchTrees.
November 13, 2015
Liam Gowan B00673126
The last 8 methods are my own work.
*/
import java.util.ArrayList;
//Binary Search Tree class
//uses the Binary Tree class
public class BinarySearchTree<T extends Comparable<T>>
//you are using the compareTo method on objects of type T; hence T should extend Comparable<T>
{
	private BinaryTree<T> tree;
	private int size;
	public BinarySearchTree()
	{
		tree = new BinaryTree<T>();
		size=0;
	}
	public BinaryTree<T> getTree()
	{
		return tree;
	}
	public boolean isEmpty()
	{
		return tree.isEmpty();
	}
	public int size()
	{
		return size;
	}
	public BinaryTree<T> search(T key)
	{
		BinaryTree<T> t = tree;
		if (isEmpty()) return null;
		while (t!=null)
		{
			if (key.compareTo(t.getData())<0)
				t = t.getLeft();
			else if (key.compareTo(t.getData())>0)
				t = t.getRight();
			else // key is found
				return t;
		}
		return null;
	}	
	public void insert(T item)
	{
		BinaryTree<T> newNode = new BinaryTree<T>(); //sets left, right, parent and data to null
		newNode.setData(item);

		if (size==0){tree = newNode; size++;return;}
		
		BinaryTree<T> t = tree;
		boolean done = false;
		while (!done)
		{
			int c = item.compareTo(t.getData());
			if (c==0)
			{
				System.out.println("Duplicate key. Can't insert");
				return;
			}
			else if (c<0) //need to go left
			{
				if (t.getLeft()==null)	//place to insert found
				{
					t.setLeft(newNode);
					newNode.setParent(t);
					size++;
					done = true;
				}
				else
					t = t.getLeft(); //otherwise go left one branch
			}
			else //c>0; need to go right
			{
				if (t.getRight()==null) //place to insert found
				{
					t.setRight(newNode);
					newNode.setParent(t);
					size++;
					done=true;
				}
				else
					t = t.getRight();
			}
		}
	}
	
	public BinaryTree<T> findPredecessor(BinaryTree<T> node)
	{
		if (node==null) return null;
		if (node.getLeft()==null) return null;
		BinaryTree<T> pred = node.getLeft();
		while (pred.getRight()!=null)
			pred = pred.getRight();
		return pred;
	}
	
	public void deleteHere(BinaryTree<T> deleteNode, BinaryTree<T> attach)
	{
		if (deleteNode==null) return;
		BinaryTree<T> parent = deleteNode.getParent();
		
		if (parent == null) return;
		if (attach == null)
		{
			if (parent.getLeft()==deleteNode)
				parent.setLeft(null);
			else
				parent.setRight(null);
			return;
		}
		if (deleteNode==parent.getRight())
		{
			parent.detachRight();
			attach.setParent(parent);
			parent.attachRight(attach);
		}
		else
		{
			parent.detachLeft();
			attach.setParent(parent);
			parent.attachLeft(attach);
		}
		deleteNode.clear();
	}
	
	public void delete(T key)
	{
		if (size==0){System.out.println("Can't delete. Empty tree"); return;}
		BinaryTree<T> deleteNode = search(key);
		if (deleteNode==null) {System.out.println("Key not found. Can't delete"); return;}
		
		BinaryTree<T> hold = null;
		if (deleteNode.getLeft()==null && deleteNode.getRight()==null)
		{
			deleteHere(deleteNode, null);
		}
		else if (deleteNode.getLeft()==null)
		{
			hold = deleteNode.getRight();
			deleteHere(deleteNode, hold);
		}
		else if (deleteNode.getRight()==null)
		{
			hold = deleteNode.getLeft();
			deleteHere(deleteNode, hold);
		}
		else
		{
			hold = findPredecessor(deleteNode);
			deleteNode.setData(hold.getData());
			deleteNode=hold;
			deleteHere(deleteNode, deleteNode.getLeft());
		}
		size--;
	}
	//recursively finds the maximum key by just going right until there isn't more rights to go
	public T findMax(){
		BinaryTree curr = new BinaryTree();
		curr = tree.root();
		while(curr.getRight()!=null){
			curr = curr.getRight();
		}
		return (T)curr.getData();
	}
	//recursively finds the minimum key by just going left until there isn't more lefts to go
	public T findMin(){
		BinaryTree curr = new BinaryTree();
		curr = tree.root();
		while(curr.getLeft()!=null){
			curr = curr.getLeft();
		}
		return (T)curr.getData();
	}
	//Driver method for recursiveSearch
	public BinaryTree<T> recursiveSearch(T key){
		if(tree.isEmpty())
			return null;
		else
			return recursiveSearch(tree,key);
	}
	//Actual recursive search method, checks whole BinaryTree for key
	public BinaryTree<T> recursiveSearch(BinaryTree<T> t, T key){
		if(t.isEmpty())
			return null;
		else if(key.compareTo(t.getData())<0)
			return recursiveSearch(t.getLeft(), key);
		else if(key.compareTo(t.getData())>0)
			return recursiveSearch(t.getRight(), key);
		else 
			return t;
	}
	//Driver method for isBST
	public boolean isBST(BinaryTree<T> t){
		return isBST(t, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}
	//Actual recursive method to determine recursively if a BinaryTree is in fact a BST 
	public boolean isBST(BinaryTree<T> t, int minimum, int maximum){
		if(t == null)
			return true;
		if((int)t.getData()>minimum
				&& (int)t.getData()<maximum
				&& isBST(t.getLeft(),minimum,Math.min((int)t.getData(), maximum))
				&& isBST(t.getRight(), Math.max((int)t.getData(), minimum), maximum)){
			return true;
		}
		else
			return false;
	}
	//Method takes in a BinaryTree, converts it into an array (not sorted)
	public ArrayList<T> convertToArrList(BinaryTree<T> t){
		ArrayList<T> dataList = new ArrayList<T>();
		if(t.getLeft()!=null)
			dataList.addAll(convertToArrList(t.getLeft()));
		if(t.getRight()!=null)
			dataList.addAll(convertToArrList(t.getRight()));
		dataList.add(t.getData());
		return dataList;
	}
	//Takes in two BinarySearchTrees, returns one merged BST
	public BinarySearchTree<T> merge(BinarySearchTree<T> t, BinarySearchTree<T> t2){
		//converts both BST's to ArrayLists
		ArrayList<T> list1 = t.convertToArrList(t.getTree()); 
		ArrayList<T> list2 = t2.convertToArrList(t2.getTree());
		//adds all elements of list2 to list1
		while(list2.size()!=0){
			list1.add(list2.remove(0));
		}
		ArrayList<T> list3 = new ArrayList<T>();
		//Sorts all of list1, and returns to list3 highest to lowest
		while(!list1.isEmpty()){
			T highestData = list1.get(0);
			for(int i=0; i<list1.size(); i++){
				if(highestData.compareTo(list1.get(i))>0)
					highestData = list1.get(i);
			}
			list3.add(highestData);
			list1.remove(highestData);
		}
		BinarySearchTree<T> merged = new BinarySearchTree<T>();
		//inserts all elements of list3 into new BST
		for(int i=0; i<list3.size(); i++){
			merged.insert(list3.get(i));
		}
		return merged;
	}
}

