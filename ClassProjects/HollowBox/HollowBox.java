//prints a hollow box

import java.io.*;
import java.util.*;
public class HollowBox{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int i; //input number
		System.out.print("Enter a Number. ");
		i= sc.nextInt();
		
		for (int line =1; line <= i; line++){
		
			if (line == 1 || line == i){
	
				for (int s=0; s < i; s++){
					System.out.print("*");
				}
				System.out.println();
			}
			
			else{

				System.out.print("*");
				
				for (int sp = i-2, x=0; sp>x; x++){
					System.out.print(" ");
				}
				System.out.println("*"); 
			}
		}
	}
}
