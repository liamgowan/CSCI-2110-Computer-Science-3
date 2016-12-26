/*Assignment 4, Heap, CSCI 2110
Heap.java is a modified version of the provided Heap file in the lab. It has been modified to only take in Process
objects and arrange them according to priority first, and if the priority was the same it would arrange them by
time arrival. Parts added or modified have been marked with a comment
November 28, 2015
Liam Gowan B00673126
This code was provided by the Faculty of CS, but was modified by me.
*/

import java.util.ArrayList;

public class Heap
{
	ArrayList<Process> heapList;
	public Heap()
	{
		heapList = new ArrayList<Process>();
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
	
	public void add(Process item)
	{
		heapList.add(item);
		
		int index = heapList.size()-1;
		int pindex = (index-1)/2;
		Process parent = heapList.get(pindex);
		
		while (index>0 && item.getPriority()>parent.getPriority())//modified part
		{
			heapList.set(index, parent);
			heapList.set(pindex, item);
			index = pindex;
			pindex = (index-1)/2;
			parent = heapList.get(pindex);
		}
		//This part has been added to ensure that if the priority is the same, elements will be ordered by 
		//time arrival
		for(int i=1; i<heapList.size(); i++){
			if(heapList.get(i-1).getPriority()==heapList.get(i).getPriority())
				if(heapList.get(i-1).getTimeArrival()>heapList.get(i).getTimeArrival()&&heapList.get(i-1)!=item&&heapList.get(i)!=item){
					Process left = heapList.get(i-1);
					Process right = heapList.get(i);
					heapList.set(i, left);
					heapList.set(i-1, right);
				}
		}
	}
	
	public Process deleteMax()
	{
		if (isEmpty())
		{
			System.out.println("Heap is empty");
			return null;
		}
		
		else
		{
			Process ret = heapList.get(0);	//get the item in the root. This is the largest item.
			
			Process item = heapList.remove(heapList.size()-1);	//remove the last item.
			
			if (heapList.size()==0)
				return ret;						//if there was only one item in the heap to begin with, we are done.
				
			heapList.set(0, item);			//otherwise, proceed. Put the item in the root.
			int index, lIndex, rIndex, maxIndex;
			Process maxChild;
			boolean found=false;
			index = 0;
			lIndex = index*2+1;
			rIndex = index*2+2;
			
			while (!found)
			{
				if (lIndex<size()&&rIndex<size())	//case 1: item to be sifted down has two children
				{
					//find the maxChild and maxIndex
					if (heapList.get(lIndex).getPriority()>heapList.get(rIndex).getPriority())//modified part
					{
						maxChild = heapList.get(lIndex);
						maxIndex = lIndex;
					}
					else
					{
						maxChild = heapList.get(rIndex);
						maxIndex = rIndex;
					}
					
					//sift down if necessary
					if (item.getPriority()<maxChild.getPriority())//modified part
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
					if (item.getPriority()<heapList.get(lIndex).getPriority())//modified part
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
	public Process removeAt(int i){//added to remove specific part of heapList
		return heapList.remove(i);
	}
}