
import java.util.*;
public class anas {
    
	public static void main (String[]args, int[][] arr){
		Scanner in = new Scanner (System.in);
		System.out.println ("Enter rows");
		int rows=in.nextInt();
		System.out.println ("Enter columns");
		int col=in.nextInt();
		createArr (rows,col);
		inputArr (arr);
	}
		static int[][] createArr(int r,int c){
			int arr=new int [r][c];
			return arr;
		}
		static int[][] inputArr (int[][] arr){
			Scanner in = new Scanner (System.in);
			for(int r=0;r<arr.length;r++){
				for(int c=0;c<arr[r].length;c++){
					arr[r][c]=in.nextInt();
				}
			}
			return arr;
		} 
	}
