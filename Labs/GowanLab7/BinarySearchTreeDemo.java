/*Lab 7, CSCI 2110
BinaryTreeSearchDemo.java was created to test the methods added to BinarySearchTree.java.
November 13, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class BinarySearchTreeDemo {
	public static void main(String[] args){
		BinarySearchTree bst = new BinarySearchTree();//creates new bst and inserts elements
		bst.insert(17);
		bst.insert(30);
		bst.insert(65);
		bst.insert(98);
		bst.insert(23);
		bst.insert(14);
		bst.insert(87);
		bst.insert(78);
		bst.insert(19);
		bst.insert(10);
		System.out.println(bst.findMax());//displays max
		System.out.println(bst.findMin());//displays min
		System.out.println(bst.recursiveSearch(98));//displays address of node with key 98
		System.out.println(bst.isBST(bst.getTree()));//determines if bst is a Binary Search Tree
		BinarySearchTree bst2 = new BinarySearchTree();//creates another bst, inserts elements
		bst2.insert(24);
		bst2.insert(55);
		bst2.insert(8);
		System.out.println(bst2.findMin());//displays max and min
		System.out.println(bst2.findMax());
		BinarySearchTree merged = bst.merge(bst, bst2);//merges both 
		System.out.println(bst.convertToArrList(merged.getTree()));//converts merged to arrayList and displays it
		System.out.println(merged.isBST(merged.getTree()));//displays if merged is a bst
		
	}
	
}
