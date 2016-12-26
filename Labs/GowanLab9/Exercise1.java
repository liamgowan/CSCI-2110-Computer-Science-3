 /*Lab9, Exercise1, CSCI 2110
Exercise1.java reads in information from userInfo.txt, uses a string tokenizer to save each part, and creates two 
hashmaps, where for one the username is the key and the password is the value, and for the other the username is the
key and the full name is the value. It then gives the user 3 attempts to enter in a matching username and password, and 
if there is a match it will welcome the user by full name, otherwise it will exit.
November 26, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.HashMap;
import java.util.Scanner;
public class Exercise1 {
	public static void main(String[] args) throws IOException{
		//Reads in file
		File file = new File("userInfo.txt");
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		String s = br.readLine();
		StringTokenizer st;
		HashMap<String, String> userPass = new HashMap<String, String>();
		HashMap<String, String> userFullname = new HashMap<String, String>();
		while(s!=null){//while line isn't equal to null
			st = new StringTokenizer(s);
			while(st.hasMoreTokens()){
				String fullName, username, password;
				//the full name is made up two parts, so two nextToken methods must be called
				fullName = st.nextToken() + " ";
				fullName = fullName + st.nextToken();
				//username and password only require one nextToken method
				username = st.nextToken();
				password = st.nextToken();
				userPass.put(username, password);//adds the password value to userPass HashMap with key username
				userFullname.put(username, fullName);//adds the fullname value to userFullname HashMap with key username
			}
			s = br.readLine();
		}
		br.close();
		//prompts user for username and massword, checks if there's a match
		Scanner input = new Scanner(System.in);
		System.out.print("Enter username: ");
		String username = input.nextLine();
		System.out.print("Enter password: ");
		String password = input.nextLine();
		int num = 2;
		while(!match(username, password, userPass)){
			//if there isn't a match, and num=2, it will tell user that they have 2 more attempts
			if(num==2)
				System.out.println("\nEither the username or password is incorrect. You have " + num + " more attempts.");
			else if (num==1)
				//if there isn't a match, and num=1, it will tell user that they have 1 more attempt
				System.out.println("\nEither the username or password is incorrect. You have " + num + " more attempt.");
			else{
				//if there isn't a match and num=0, system will quit
				System.out.println("\nSorry. Incorrect login. Please contact the system administrator.");
				System.exit(0);
			}
			//prompts user, decreases num
			System.out.print("Enter username: ");
			username = input.nextLine();
			System.out.print("Enter password: ");
			password = input.nextLine();
			num--;
		}
		if(match(username, password, userPass)){
			//if there is a match, it will welcome the user by their full name
			System.out.println("\nLogin successful");
			System.out.println("Welcome " + userFullname.get(username));
		}	
	}
	
	public static boolean match(String username, String password, HashMap<String, String> userPass){
		//if userpass has the username as a key, it will test to see if the value for the key is the same as inputted password
		//if so return true, otherwise return false
		if(userPass.containsKey(username)){
			String passInHash = userPass.get(username);
			if(passInHash.equals(password))
				return true;
			else
				return false;
		}
		else 
			return false;
	}
}
