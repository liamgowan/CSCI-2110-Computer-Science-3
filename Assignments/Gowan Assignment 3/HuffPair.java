/*Assignment 3, CSCI 2110
HuffPair.java contains a character the Huffman code for that character. It has getters and setters. 
November 12, 2015
Liam Gowan B00673126
This is entirely my own work.
*/
public class HuffPair {
	private String c;
	private String code;
	public HuffPair(String c, String code){
		this.c = c; 
		this.code = code;
	}
	public String getC() {
		return c;
	}
	public void setC(String c) {
		this.c = c;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
}
