/*Lab 8, CSCI 2110
HeapAllExercises.java tests all exercises in the lab.
November 21, 2015
Liam Gowan B00673126
*/
public class HeapAllExercises {
	public static void main(String[] args){
		System.out.println("EXERCISE 1");
		Heap<String> h = new Heap<String>();
		h.E1();//displays words in descending order
		System.out.println("EXERCISE 2");
		MinHeap<String> MH = new MinHeap<String>();
		MH.add("d");
		MH.add("e");
		MH.add("c");
		MH.add("b");
		MH.add("a");
		MH.enumerate();//displays in ascending order
		System.out.println("EXERCISE 3");
		Heap<Integer> ih = new Heap<Integer>();
		ih.add(6);
		ih.add(2);
		ih.add(4);
		ih.add(3);
		ih.add(5);
		ih.add(1);
		ih.add(0);
		ih.add(34);
		ih.add(34);
		ih.add(34);
		ih.add(34);
		ih.add(34);
		System.out.println("Minimum: " + ih.findMin());//displays min
		System.out.println("EXERCISE 4");
		System.out.println("5 is at position: " + ih.findItem(5));//displays index of 5
		ih.enumerate();//proves it's where it is
		System.out.println("EXERCISE 5");
		ih.changePriority(34, 7);//changes priority
		ih.enumerate();//proves what it's done
	}
	
}
