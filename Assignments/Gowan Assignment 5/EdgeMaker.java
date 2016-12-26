/*Assignment 5, EdgeMaker, CSCI 2110
EdgeMaker.java reads in a .txt file, uses the first line as the number for the length and width of 2D integer array, 
which is used at the adjacency matrix. It also creates two arrayLists of Strings, where the first and last String go 
into separate arrayLists. It makes another ArrayList that contains all of the vertex titles in alphabetical order. 
The adj matrix is then filled with zeros, and then the appropiate 1's. It then uses a Breadth First Search Algorithm
to make another ArrayList which displays all vertexes in the graph, just by starting with the first vertex read in.

"Edges.txt" contains the example from assignment instructions.
"Edges2.txt" contains an example written by me.

December 3rd, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.util.StringTokenizer;
import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
public class EdgeMaker {
	public static void main(String[] args) throws IOException{
		//Asks user for name of file to read
		Scanner input = new Scanner(System.in);
		System.out.print("Enter file to read from: ");
		String fileName = input.nextLine();
		input.close();
		//Sets up the BufferedReader
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		int num = Integer.parseInt(br.readLine());//sets num to number in first line of .txt file
		int[][] adjMatrix = new int[num][num];//makes num by num 2D array of ints
		//sets all values to 0
		for(int i=0; i<num; i++){
			for(int j=0; j<num;j++){
				adjMatrix[i][j] = 0;
			}
		}
		ArrayList<String> graphNames = new ArrayList<String>();
		ArrayList<String> leftVertexes = new ArrayList<String>();
		ArrayList<String> rightVertexes = new ArrayList<String>();
		ArrayList<String> graphNamesSorted = new ArrayList<String>();
		StringTokenizer st;
		String s = br.readLine();
		//reads the file, fills an ArrayList of values on the left, an ArrayList of values on the right,
		//and all the values without duplications
		while(s!=null){
			st = new StringTokenizer(s);
			while(st.hasMoreTokens()){
				String firstVertex, secondVertex;
				firstVertex = st.nextToken(); 
				secondVertex = st.nextToken();
				leftVertexes.add(firstVertex);
				rightVertexes.add(secondVertex);
				if(!graphNames.contains(firstVertex))
					graphNames.add(firstVertex);
				if(!graphNames.contains(secondVertex))
					graphNames.add(secondVertex);
				//fills the adjMatrix with 1's, where appropiate
				int x = firstVertex.charAt(0)-65;
				int y = secondVertex.charAt(0)-65;
				adjMatrix[x][y] =1;
				adjMatrix[y][x]=1;
			}
			s = br.readLine();
		}
		br.close();
		//Takes the graphNames ArrayList, and uses insertion sort to make a graphNamesSorted ArrayList
		if(!graphNames.isEmpty()){
			String smallest=graphNames.get(0);
			int smallestIndex =0;
			int size = graphNames.size();
			for(int j=0; j<size; j++){
				for(int i=0; i<graphNames.size(); i++){
					if(graphNames.get(i).compareTo(smallest)<0){
						smallest = graphNames.get(i);
						smallestIndex = i;
					}
				}
				graphNamesSorted.add(graphNames.remove(smallestIndex));
				if(!graphNames.isEmpty()){
					smallestIndex = 0;
					smallest = graphNames.get(0);
				}
			}
		}
		//Here to line 97 prints properly formatted adjMatrix
		System.out.print(" ");
		for(int i=0; i<graphNamesSorted.size(); i++){
			System.out.print(" " + graphNamesSorted.get(i));
		}
		System.out.println();
		for(int i=0; i<num; i++){
			System.out.print(graphNamesSorted.get(i));
			for(int j=0; j<num;j++){
				System.out.print(" " + adjMatrix[i][j]);
			}
			System.out.println();
		}
		//The following is the algorithm for BFS
		//Creates two ArrayLists, one will be used as a queue
		ArrayList<String> queue = new ArrayList<String>();
		ArrayList<String> resultList = new ArrayList<String>();
		queue.add(leftVertexes.get(0));//enqueues the very first value read in
		while(!queue.isEmpty()){
			resultList.add(queue.remove(0)); //dequeues first entry to resultList
			//enqueues all neighbours of last vertex from rightVertex in resultList to queue if they aren't already in queue or resultList
			for(int i=0; i<leftVertexes.size(); i++){
				String gAtI = leftVertexes.get(i);
				if(gAtI.equals(resultList.get(resultList.size()-1))&&!resultList.contains(rightVertexes.get(i))&&!queue.contains(rightVertexes.get(i)))
					queue.add(rightVertexes.get(i));
			}
			//enqueues all neighbours of last vertex from leftVertex in resultList to queue if they aren't already in queue or resultList
			for(int i=0; i<rightVertexes.size(); i++){
				String gAtI = rightVertexes.get(i);
				if(gAtI.equals(resultList.get(resultList.size()-1))&&!resultList.contains(leftVertexes.get(i))&&!queue.contains(leftVertexes.get(i)))
					queue.add(leftVertexes.get(i));
			}
		}
		//enumerates all the vertex's found.
		System.out.println(resultList);
	}
}
