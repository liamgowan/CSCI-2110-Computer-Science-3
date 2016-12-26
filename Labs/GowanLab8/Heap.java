/*Lab 8, CSCI 2110
Heap.java has had 4 methods added to it. These methods are used to display words in descending order, find the minimum value
in heap, to find the index of an item, and to change the priorities. 
November 21, 2015
Liam Gowan B00673126
The last 4 methods are my own work.
*/
import java.util.ArrayList;
import java.util.Scanner;
public class Heap<T extends Comparable<T>>
{
	ArrayList<T> heapList;
	
	public Heap()
	{
		heapList = new ArrayList<T>();
	}
	
	public int size()
	{
		return heapList.size();
	}
	
	public boolean isEmpty()
	{
		return heapList.isEmpty();
	}
	
	public void clear()
	{
		heapList.clear();
	}
	public void enumerate()
	{
		System.out.println(heapList);
	}
	
	public void add(T item)
	{
		heapList.add(item);
		
		int index = heapList.size()-1;
		int pindex = (index-1)/2;
		T parent = heapList.get(pindex);
		
		while (index>0 && item.compareTo(parent)>0)
		{
			heapList.set(index, parent);
			heapList.set(pindex, item);
			index = pindex;
			pindex = (index-1)/2;
			parent = heapList.get(pindex);
		}
	}
	
	public T deleteMax()
	{
		if (isEmpty())
		{
			System.out.println("Heap is empty");
			return null;
		}
		
		else
		{
			T ret = heapList.get(0);	//get the item in the root. This is the largest item.
			
			T item = heapList.remove(heapList.size()-1);	//remove the last item.
			
			if (heapList.size()==0)
				return ret;						//if there was only one item in the heap to begin with, we are done.
				
			heapList.set(0, item);			//otherwise, proceed. Put the item in the root.
			int index, lIndex, rIndex, maxIndex;
			T maxChild;
			boolean found=false;
			index = 0;
			lIndex = index*2+1;
			rIndex = index*2+2;
			
			while (!found)
			{
				if (lIndex<size()&&rIndex<size())	//case 1: item to be sifted down has two children
				{
					//find the maxChild and maxIndex
					if (heapList.get(lIndex).compareTo(heapList.get(rIndex))>0)
					{
						maxChild = heapList.get(lIndex);
						maxIndex = lIndex;
					}
					else
					{
						maxChild = heapList.get(rIndex);
						maxIndex = rIndex;
					}
					
					//sift down if necesssary
					if (item.compareTo(maxChild)<0)
					{
						heapList.set(maxIndex, item);
						heapList.set(index, maxChild);
						index = maxIndex;
					}
					else
						found = true;
				}
						
				else if (lIndex < size()) //case 2: item to be sifted down has only left child
				//note: item to be sifted down cannot have only right child - it will violate the complete binary tree property
				{
					if (item.compareTo(heapList.get(lIndex))<0)
					{
						heapList.set(index, heapList.get(lIndex));
						heapList.set(lIndex,item);
						
						index = lIndex;
					}
				
					else
						found = true;
				}
				else //case 3: item to be sifted down has no children
					found = true;
						
				lIndex = index*2+1;
				rIndex = index*2+2;
			}
			return ret;
		}
	}	
	public void E1(){
		//Displays greatest value to least value
		System.out.print("Enter a word to be read, enter * and program will execute: ");
		Scanner input = new Scanner(System.in);
		String word = input.nextLine();
		while(!word.equals("*")){
			heapList.add((T)word);
			System.out.print("Enter next: ");
			word = input.nextLine();
		}
		while(!heapList.isEmpty())
			System.out.println(deleteMax());
	}
	public T findMin(){
		//method figures out the total possible leafs, and then searches from the end until that number is met.
		if(isEmpty())
			return null;
		else if(heapList.size()==1)
			return heapList.get(0);
		else if(heapList.size()==2)
			return heapList.get(1);
		ArrayList<T> allLeafs = new ArrayList<T>();
		int totalPossibleLeafs=0;
		for(int i=2; i<heapList.size(); i++){if(heapList.size()>Math.pow(2,i-1) && heapList.size()<=Math.pow(2, i)){
				totalPossibleLeafs = (int)Math.pow(2, i-1);
				break;
			}
		}
		for(int i=totalPossibleLeafs; i>0; i--)
			allLeafs.add(heapList.get(heapList.size()-i));
		int smallestIndex = 0;
		for(int i=0; i<allLeafs.size(); i++){
			if(allLeafs.get(smallestIndex).compareTo(allLeafs.get(i))>0){
				smallestIndex = i;
			}
		}
		return allLeafs.get(smallestIndex);
	}
	public int findItem(T item){
		//returns index of first occurrence of item, or -1, with O(1) time complexity.
		return heapList.indexOf(item);
	}
	public void changePriority(T item1, T item2){
		//removes all occurrences of item1, and then adds that many item1's and item2's
		if(findItem(item1)==-1)
			return;
		int indexToRemove = findItem(item1);
		int countToAdd = 0;
		while(indexToRemove!=-1){
			heapList.remove(indexToRemove);
			countToAdd++;
			indexToRemove = findItem(item1);
		}
		for(int i=0;i<countToAdd;i++){
			this.add(item1);
			this.add(item2);
		}
	}

}