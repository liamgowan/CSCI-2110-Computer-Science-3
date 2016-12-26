/*Lab9, Exercise2, CSCI 2110
Exercise2.java creates an array of linkest list of an inputed size, and creates an inputed number of keys
and calculates statistics on them. 
November 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.Scanner;
public class Exercise2 {
	public static void main(String[] args){
		//Step one - asks for the size of the hash table
		Scanner input = new Scanner(System.in);
		int tableSize, numKeys;
		System.out.print("Enter the size of the hash table: ");
		tableSize = input.nextInt();
		//creates hashTable - just an array of LinkedLists
		LinkedListN[] hashTable = new LinkedListN[tableSize];
		for(int i=0; i<tableSize; i++)
			hashTable[i] = new LinkedListN();//initializes each LinkedList
		//Step two
		//asks for how many keys are to be created
		System.out.print("Enter the number of keys to be hashed: ");
		numKeys = input.nextInt();
		for(int i=0; i<numKeys; i++){//for input, it makes that many keys between 1 and 10000, hashes them
									//by using the key mod table size, and then using that as the position 
								    //of the LinkedList to add it to
			int key = (int)(Math.random()*10000);//Step 3
			int pos = key%tableSize;//Step 4
			hashTable[pos].add(key);//Step 5
		}
		for(int i=0; i<tableSize; i++){//prints linked list index, and enumerates each once
			System.out.println("LinkedList " + i + ": ");
			hashTable[i].enumerate();
		}
		//collision/longest list finder
		int collisions = 0;
		int longestListSize = hashTable[0].size();
		for(int i=0; i<tableSize; i++){//finds out how many collisions there are, and size of the longest list
			if(hashTable[i].size()>1)
				collisions = collisions + hashTable[i].size()-1;
			if(hashTable[i].size()>longestListSize){
				longestListSize = hashTable[i].size();
			}
		}
		//prints all stats
		System.out.println("\nStatistics:");
		System.out.println("Table size: " + tableSize);
		System.out.println("Number of keys: " + numKeys);
		System.out.println("Load factor: " + (double)numKeys/tableSize);
		System.out.println("Total number of Collisions: " + collisions);
		System.out.println("Longest List: " + longestListSize);
	}
}
