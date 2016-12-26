/*Lab 2, Exercise 2, CSCI 2110
MatrixMult.java takes in the size of each square matrix, and the (identical) element.
The program then creates two identical matrices, and multiplies them to create a new
matrix. The program also supplies the time it took to create the new matrix
September 23, 2015
Liam Gowan B00673126
The multiplyMatrix() method is entirely my own work, however the main method was 
provided in lab instructions.
*/
import java.util.Scanner;
public class MatrixMult{
   public static void main(String[] args){
      Scanner keyboard = new Scanner(System.in); 
      int n;
      double num;
      System.out.print("Enter the size of each matrix: ");
      n = keyboard.nextInt();
      System.out.println("Enter the matrix element"); 
      System.out.print("All elements of the matrices are assumed to be the same: ");
      num = keyboard.nextDouble();
      double[][] matrix1 = new double[n][n]; 
      for (int i = 0; i < n; i++)
         for (int j = 0; j < n; j++) 
            matrix1[i][j] = num;
            
      double[][] matrix2 = new double[n][n]; 
      for (int i = 0; i < n; i++)
         for (int j = 0; j < n; j++) 
            matrix2[i][j] = num;
            
      long startTime, endTime, executionTime; 
      startTime = System.currentTimeMillis();
      double[][] resultMatrix = multiplyMatrix(matrix1, matrix2);
      endTime = System.currentTimeMillis(); 
      executionTime = endTime - startTime;
      System.out.println("Execution time: " + executionTime + " millisecs");
   }
   public static double[][] multiplyMatrix(double[][] m1, double[][] m2){
      //multiplies both matrices to create new matrix, it will be the same size of 
      //as the other two matrices. Using 3 for loops, each element of the new
      //matrix is calculated
      double[][] m3 = new double[m1.length][m1.length];
      for(int i=0; i<m1.length; i++){
         for(int j=0; j<m1.length; j++){
            for(int k=0; k<m1.length; k++){
               m3[i][j] = m3[i][j] + m1[i][k] * m2[k][j];
            }
         }
      }
      return m3;
   }
}