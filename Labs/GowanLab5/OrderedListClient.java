/*Lab5, Exercise 1, CSCI 2110
OrderedListClient.java creates two OrderedList objects by reading text in from files. It uses variations
of the two-finger walking algorithm to traverse though both OrderedLists to merge, find the common elements,
and to find the difference of L1-L2 and the difference of L2-L1,
October 24, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.io.*;
import java.util.Scanner;
public class OrderedListClient {
	public static void main(String[] args)throws IOException{
		//Program first creates two OrderedList objects, asks for a filename to read from, twice,
		//and fills the lists from there, and shows user what they first each look like.
		OrderedList<String> list1 = new OrderedList<String>();
		OrderedList<String> list2 = new OrderedList<String>();
		Scanner input = new Scanner(System.in); 
		System.out.print("Enter the filename to read from: "); 
		String fileName = input.nextLine();
		File file = new File(fileName); 
		Scanner inputFile = new Scanner(file); 
		while (inputFile.hasNext()){
			list1.insert(inputFile.nextLine());
		}
		list1.enumerate();
		inputFile.close(); 
		System.out.print("Enter the filename to read from: "); 
		fileName = input.nextLine();
		file = new File(fileName); 
		inputFile = new Scanner(file); 
		while (inputFile.hasNext()){
			list2.insert(inputFile.nextLine());
		}
		list2.enumerate();
		inputFile.close();
		//Creates another OrderedList object, and makes it equal to the return address each method made,
		//and then enumerates
		OrderedList<String> list3 = merge(list1, list2);
		list3.enumerate();
		list3 = intersection(list1, list2);
		list3.enumerate();
		list3 = L1MinusL2(list1, list2);
		list3.enumerate();
		list3 = L2MinusL1(list1, list2);
		list3.enumerate();
	}
	
	public static <T extends Comparable<T>> OrderedList<T> merge (OrderedList<T> list1, OrderedList<T> list2){
		//Returns list containing all elements of list1 and list2, without duplicates
		OrderedList<T> list3 = new OrderedList<T>();
		//user two cursor integers
		int c1 = 0;
		int c2 = 0;
		//while loop executes when both cursors are less than their corresponding list size.
		while(c1<list1.size()&&c2<list2.size()){
			if(list1.get(c1).compareTo(list2.get(c2))>0){
				//If item at pos c1 of list1 is greater than item at pos c2 of list2, insert the c1 item, increase
				//c1 cursor.
				list3.insert(list1.get(c1));
				c1++;
			}
			else if(list1.get(c1).compareTo(list2.get(c2))<0){
				//If item at pos c2 of list2 is greater than pos c1 of list1, insert the c2 item, increase
				//c2 cursor.
				list3.insert(list2.get(c2));
				c2++;
			}
			else{
				//If item at pos c1 of list1 is equal item at pos c2 of list2, insert the c1 item, increase
				//both cursors.
				list3.insert(list1.get(c1));
				c1++;
				c2++;
			}
		}
		
		//If one cursor gets to the end of the list, and there are still more items in the other list,
		//this will append everything else to list3.
		if(c1==list1.size()){
			while(c2<list2.size()){
				list3.insert(list2.get(c2));
				c2++;
			}
		}
		if(c2==list2.size()){
			while(c1<list1.size()){
				list3.insert(list1.get(c1));
				c1++;
			}
		}
		return list3;
	}
	
	public static <T extends Comparable<T>> OrderedList<T> intersection (OrderedList<T> list1, OrderedList<T> list2){
		//Returns list containing all elements common of list1 and list2
		OrderedList<T> list3 = new OrderedList<T>();
		int c1 = 0;
		int c2 = 0;
		while(c1<list1.size()&&c2<list2.size()){
			if(list1.get(c1).equals(list2.get(c2))){
				//If item at pos c1 of list1 is equal to item at pos c2 of list2, insert the c1 item, increase
				//both cursors
				list3.insert(list1.get(c1));
				c1++;
				c2++;
			}
			else if(list1.get(c1).compareTo(list2.get(c2))>0){
				//If item at pos c1 of list1 is greater than pos c2 of list2, increase c2 cursor
				c2++;
			}
			else{
				//If item at pos c2 of list2 is greater than pos c1 of list1, increase c2 cursor
				c1++;
			}	
		}
		return list3;	
	}
	
	public static <T extends Comparable<T>> OrderedList<T> L1MinusL2 (OrderedList<T> list1, OrderedList<T> list2){
		//Returns list containing all elements of list1 minus the elements of list2
		OrderedList<T> list3 = new OrderedList<T>();
		int c1 = 0;
		int c2 = 0;
		while(c1<list1.size()&&c2<list2.size()){
			if(list1.get(c1).compareTo(list2.get(c2))<0){
				//If item at pos c2 of list2 is greater than item at pos c1 of list1, insert the c1 item, increase
				//c1 cursor.
				list3.insert(list1.get(c1));
				c1++;
			}
			else if(list1.get(c1).compareTo(list2.get(c2))>0){
				//If item at pos c1 of list1 is greater than item at pos c2 of list2, increase c2 cursor
				c2++;
			}
			else{
				//If item at pos c1 of list1 is equal to item at pos c2 of list2, increase both cursors
				c1++;
				c2++;
			}
		}
		//If one cursor gets to the end of the list, and there are still more items in the other list,
		//this will append everything else to list3.
		if(c2==list2.size()){
			while(c1<list1.size()){
				list3.insert(list1.get(c1));
				c1++;
			}
		}
		return list3;	
	}
	public static <T extends Comparable<T>> OrderedList<T> L2MinusL1 (OrderedList<T> list1, OrderedList<T> list2){
		//Returns list containing all elements of list2 minus the elements of list1
		OrderedList<T> list3 = new OrderedList<T>();
		int c1 = 0;
		int c2 = 0;
		while(c1<list1.size()&&c2<list2.size()){
			if(list1.get(c1).compareTo(list2.get(c2))<0){
				//If item at pos c2 of list2 is greater than item at pos c1 of list1, increase c1 cursor
				c1++;
			}
			else if(list1.get(c1).compareTo(list2.get(c2))>0){
				//If item at pos c1 of list1 is greater than item at pos c2 of list2, insert list1 item and
				//increase c2 cursor
				list3.insert(list2.get(c2));
				c2++;
			}
			else{//If item at pos c1 of list1 is equal to item at pos c2 of list2, increase both cursors
				c1++;
				c2++;
			}
		}
		//If one cursor gets to the end of the list, and there are still more items in the other list,
		//this will append everything else to list3.
		if(c1==list1.size()){
			while(c2<list2.size()){
				list3.insert(list2.get(c2));
				c2++;
			}
		}
		return list3;	
	}	
}
