/*Assignment 3, CSCI 2110
FileReaderWriter.java asks the user for a .txt file. It then reads all of the lines of that .txt file, calculates the frequency 
of each character, creates a binary tree of each letter based on frequency, encodes the given .txt file to the Huffman symbols,
and then decodes the encoded file back to the original .txt file.
November 12, 2015
Liam Gowan B00673126
This is entirely my own work, with the exception of the findEncoding methods which were provided in the assignment.
*/

import java.util.StringTokenizer;
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
public class FileReaderWriter {
	public static void main(String[] args)throws IOException{
		ArrayList<Pair> pairList = new ArrayList<Pair>();
		ArrayList<Character> charList = new ArrayList<Character>();
		String s = "";
		String all = "";
		Scanner input = new Scanner(System.in);
		//Asks user for file to be read
		System.out.print("Enter the name of file to be read: ");
		String filename = input.nextLine();
		File file = new File(filename);
		File outputFile = new File("Huffman.txt");
		FileWriter fw = new FileWriter(outputFile);
		FileInputStream fis = new FileInputStream(file);
		InputStreamReader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		BufferedWriter bw = new BufferedWriter(fw);
		//reads file and saves all as one string
		s = br.readLine();
		while(s!=null){
			all = "" + s;
			s=br.readLine();
		}
		//checks if the current character as already been accounted for. If it hasn't, it there will be a new char added
		//to charList, and a Pair object will be made. Otherwise it will increase the number for that object.
		for(int i=0; i<all.length(); i++){
			if(!charList.contains(all.charAt(i))&&all.charAt(i)!='\r'){
				charList.add(all.charAt(i));
				Pair p = new Pair(all.charAt(i));
				pairList.add(p);
				p.increaseTotalNum();
			}
			else{
				for(int j=0; j<pairList.size(); j++){
					if(pairList.get(j).getValue()==(all.charAt(i))){
						pairList.get(j).increaseNum();
						pairList.get(j).increaseTotalNum();
					}
				}
			}		
		}
		//calculates probability for all Pair objects
		for(int i=0; i<pairList.size(); i++)
			pairList.get(i).calcProb();
		ArrayList<BinaryTree<Pair>> S = new ArrayList<BinaryTree<Pair>>();
		ArrayList<Character> chrList = new ArrayList<Character>();
		//finds the index of the pair with highest num
		int highestIndex = 0;
		int highestNum = 0;
		for(int i=0; i<pairList.size(); i++){
			if(pairList.get(i).getNum()>highestNum){
				highestNum = pairList.get(i).getNum();
				highestIndex = i;
			}
		}
		//Adds Pair objects to queue S so that smaller objects are at beginning of queue
		for(int i=0; i<pairList.size(); i++){
			BinaryTree<Pair> lowest = new BinaryTree<Pair>();
			lowest.setData(pairList.get(highestIndex));
			if(S.size()>0){
				for(int j=0; j<pairList.size(); j++){
					if(pairList.get(j).getNum()>=S.get(S.size()-1).getData().getNum() && pairList.get(j).getNum()<=lowest.getData().getNum()&&!chrList.contains(pairList.get(j).getValue()))
						lowest.setData(pairList.get(j));
				}
				S.add(lowest);
				chrList.add(lowest.getData().getValue());
			}
			if(S.size()==0){
				for(int j=0; j<pairList.size(); j++){
					if(pairList.get(j).getNum()<lowest.getData().getNum())
						lowest.setData(pairList.get(j));
				}
				S.add(lowest);
				chrList.add(lowest.getData().getValue());
			}
		}
		ArrayList<BinaryTree<Pair>> T = new ArrayList<BinaryTree<Pair>>();
		//The following is huffman coding, as described in the assignment.
		BinaryTree<Pair> A = new BinaryTree<Pair>();
		BinaryTree<Pair> B = new BinaryTree<Pair>();
		while(!S.isEmpty()){
			if(T.isEmpty()){
				A = S.remove(0);
				B = S.remove(0);
			}
			else{
				if(S.get(0).getData().getProb()<T.get(0).getData().getProb())
					A = S.remove(0);
				else
					A = T.remove(0);
				if(S.size()==0)
					B=T.remove(0);
				else if(S.get(0).getData().getProb()<T.get(0).getData().getProb())
						B = S.remove(0);
				else
					B = T.remove(0);
			}
			BinaryTree<Pair> P = new BinaryTree<Pair>();
			Pair Par = new Pair('0'); //dummy object
			Par.setProb(A.getData().getProb()+B.getData().getProb());
			P.makeRoot(Par);
			P.attachLeft(A);
			P.attachRight(B);
			T.add(P);
		}
		//Step 6
		while(T.size()>1){
			A = T.remove(0);
			B = T.remove(0);
			BinaryTree<Pair> P = new BinaryTree<Pair>();
			Pair Par = new Pair('0');
			Par.setProb(A.getData().getProb()+B.getData().getProb());
			P.makeRoot(Par);
			P.attachLeft(A);
			P.attachRight(B);
			T.add(P);
		}
		String[] codes = findEncoding(T.get(0));
		ArrayList<String> useCodes = new ArrayList<String>();
		for(int i=0; i<codes.length;i++){
			if(codes[i]!=null){
				useCodes.add("" + codes[i]);
			}
		}
		for(int i=0; i<useCodes.size(); i++){
			String code = useCodes.get(i);
			String temp = code;
			BinaryTree<Pair> curr = T.get(0);
			while(code.length()!=0){
				if(code.charAt(0)=='0')
					curr = curr.getLeft();
				else
					curr = curr.getRight();
				code = code.substring(1);
			}
			//writes all information to the Huffman.txt file
			if(curr.getData().getValue()!=' '&&!Character.isWhitespace(curr.getData().getValue()))
				bw.write(String.format("%-10s%-10s%s\n", curr.getData().getValue(), curr.getData().getProb(), temp));
			
		}
		bw.close();
		br.close();
		//The following reads the Huffman.txt file, and encodes the Pokemon file to Encoded.txt
		File file2 = new File("Huffman.txt");
		File outputFile2 = new File("Encoded.txt");
		FileWriter fw2 = new FileWriter(outputFile2);
		FileInputStream fis2 = new FileInputStream(file2);
		InputStreamReader isr2 = new InputStreamReader(fis2);
		BufferedReader br2 = new BufferedReader(isr2);
		BufferedWriter bw2 = new BufferedWriter(fw2);
		ArrayList<HuffPair> huffs = new ArrayList<HuffPair>();
		StringTokenizer st;
		s=br2.readLine();
		//creates HuffPair objects for each line
		while(s!=null){
			st = new StringTokenizer(s);
			while(st.hasMoreTokens()){
				String c = st.nextToken();
				st.nextToken();
				String code = st.nextToken();
				HuffPair hp = new HuffPair(c,code);
				huffs.add(hp);
			}
			s=br2.readLine();
		}
		for(int i=0; i<all.length(); i++){
			//"all" is the result from original file being read in. 
			char letter = all.charAt(i);
			String code;
			HuffPair hp;
			//For loop will check to see which code it has to write for the particular letter, and will then write it to Encoded.txt
			for(int j=0; j<huffs.size(); j++){
				if((letter + "").equals(huffs.get(j).getC())){
					hp = huffs.get(j);
					code = hp.getCode();
					bw2.write(code);
					break;
				}
				else if (j==huffs.size()-1){
					bw2.write(letter);
				}
			}
		}
		bw2.close();
		br2.close();
		//Reads in Encoded.txt, converts all lines to one string
		File file3 = new File("Encoded.txt");
		File outputFile3 = new File("Decoded.txt");
		FileWriter fw3 = new FileWriter(outputFile3);
		FileInputStream fis3 = new FileInputStream(file3);
		InputStreamReader isr3 = new InputStreamReader(fis3);
		BufferedReader br3 = new BufferedReader(isr3);
		BufferedWriter bw3 = new BufferedWriter(fw3);
		String allEncoded="";
		s = br3.readLine();
		while(s!=null){
			allEncoded = "" + s;
			s=br3.readLine();
		}
		br3.close();
		//each iteration it will add another 0 or 1 to code, and if that code is exists in any HuffPair object,
		//it will print to Decoded.txt the character for that object and reset code to nothing.
		//If it is a space or line return, it will print that to Decoded.txt.
		String code="";
		for(int i=0; i<allEncoded.length(); i++){
			code = code + allEncoded.charAt(i);
			if(useCodes.contains(code)){
				for(int j=0; j<huffs.size(); j++){
					if(huffs.get(j).getCode().equals(code))
						bw3.write(huffs.get(j).getC());
				}
				code = "";
			}
			else if(Character.isWhitespace(allEncoded.charAt(i))){
				bw3.write(allEncoded.charAt(i));
				code = "";
			}
		}
		bw3.close();
	}
	//Below are the methods provided in assignment.
	public static void findEncoding(BinaryTree<Pair> t, String[] a, String prefix) {
		if (t.getLeft()==null&& t.getRight()==null){
			a[(byte)(t.getData().getValue())]= prefix;
		} 
		else{
			findEncoding(t.getLeft(), a, prefix+"0");
			findEncoding(t.getRight(), a, prefix+"1"); }
		}
	
		public static String[] findEncoding(BinaryTree<Pair> t){
			String[] result = new String[256]; 
			findEncoding(t, result, "");
			return result;
		}
}
