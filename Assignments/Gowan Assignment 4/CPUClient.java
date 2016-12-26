/*Assignment 4, CPUClient, CSCI 2110
CPUClient.java reads in a .txt file full of Processes and adds all of them to a non-heap ArrayList.
A for loop within a while loop ensures that Processes are added to the Heap at the proper time.
It then computes how many time units are required to process.
Only one Process can be held within the CPU, and it is held within for the given amount of time units, or until 
timeReq is 0, which ever comes first.

"Processes.txt" contains the example from assignment instructions.

November 28, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.ArrayList;
public class CPUClient{
	public static void main(String[] args) throws IOException{
		//reads in file
		Heap processHeap = new Heap();
		ArrayList<Process> processList = new ArrayList<Process>();
		ArrayList<Process> CPU = new ArrayList<Process>();
		File file = new File("Processes.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		//reads first line to get timeUnitsForHold
		String s = br.readLine();
		StringTokenizer st;
		int timeUnitsForHold = Integer.parseInt(s);
		int time=1;
		int count=1;
		s=br.readLine();
		//creates a new process for every process line in "Processes.txt"
		//using string tokenizers, and adds it the processList ArrayList
		while(s!=null){
			st = new StringTokenizer(s);
			while(st.hasMoreTokens()){
				int id = Integer.parseInt(st.nextToken());
				int timeReq = Integer.parseInt(st.nextToken());
				int priority = Integer.parseInt(st.nextToken());
				int timeArrival = Integer.parseInt(st.nextToken());
				Process hp = new Process(id, timeReq, priority, timeArrival);
				processList.add(hp);
			}
			s = br.readLine();
		}
		br.close();//closes "Processes.txt"
		
		boolean processListIsEmpty = false;
		while(!processList.isEmpty()||(processListIsEmpty && !processHeap.isEmpty())){
			//adds processes from processList to processHeap if the time is appropiate
			for(int i=0; i<processList.size(); i++){
				if(processList.get(i).getTimeArrival()==time){
					processHeap.add(processList.remove(i));
					i--;
				}
			}
			if(CPU.isEmpty())
				count=1;
			//Displays current Time Unit
			System.out.println("Time Unit:    " + time+"\n\n");
			
			//Displays what the processHeap and CPU contains at the beginning of each round
			System.out.println("Beginning:\n");
			System.out.println("Priority Heap contains:");
			if(!processHeap.isEmpty())
				processHeap.enumerate();
			else
				System.out.println("-\n");
			System.out.println("\nCPU Contains:");
			if(CPU.isEmpty())
				System.out.println("-\n");
			else
				System.out.println(CPU+"\n");
			//Displays what the processHeap and CPU contains in the middle of each round
			System.out.println("During:\n");
			//If it is an appropriate time to add a process to the CPU, it will the add the first one in Heap
			if((time%timeUnitsForHold!=0&&CPU.isEmpty())||CPU.isEmpty())
				CPU.add(processHeap.removeAt(0));
			System.out.println("Priority Heap contains:");
			if(processHeap.isEmpty())
				System.out.println("-\n");
			else
				processHeap.enumerate();
			System.out.println("\nCPU Contains:");
			if(CPU.isEmpty())
				System.out.println("-\n");
			else
				System.out.println(CPU+"\n");
			
			System.out.println("End:\n");
			//If there's something in the CPU, decrease the timeReq by 1
			if(!CPU.isEmpty()){
				CPU.get(0).setTimeReq(CPU.get(0).getTimeReq()-1);
				//if the thing in CPU has a timeReq of 0, remove it
				if(CPU.get(0).getTimeReq()==0){
					CPU.remove(0);
				}
			}
			//if it's time to remove whatever is in the CPU, and if it isn't empty, remove whatever is in there
			if(count%timeUnitsForHold==0&&!CPU.isEmpty()){
				processHeap.add(CPU.remove(0));
				count=1;
			}
			//Display what's in the Heap and CPU
			System.out.println("Priority Heap contains:");
			if(processHeap.isEmpty())
				System.out.println("-\n");
			else
				processHeap.enumerate();
			System.out.println("\nCPU Contains:");
			if(CPU.isEmpty())
				System.out.println("-\n");
			else
				System.out.println(CPU+"\n");
			//increases time and round each line
			time++;
			count++;
			if(processList.isEmpty())
				processListIsEmpty=true;
			//In the event that the processList and processHeap are empty, but the CPU is not
			//the CPU will have to keep decreasing the timeReq each round
			if(processList.isEmpty()&&processHeap.isEmpty()&&!CPU.isEmpty()){
				while(CPU.get(0).getTimeReq()!=0){
					System.out.println("Time Unit:    " + time+"\n\n");
					System.out.println("Only one item left in CPU, none in Heap.");
					System.out.println("CPU contains:");
					System.out.println(CPU);
					CPU.get(0).setTimeReq(CPU.get(0).getTimeReq()-1);
					System.out.println("AFTER PROCESSING ONE TIME UNIT CPU CONTAINS:");
					System.out.println(CPU);
					time++;
				}
			}
		}
		//displays total time units required
		System.out.println("CPU took " + (time-1) + " time units to process all data.");
	}
}
