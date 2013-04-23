//Prints a full diamond

import java.io.*;
import java.util.*;
public class Diamond{
	public static void main(String [] args){
		Scanner sc = new Scanner(System.in);
		int i;

		do{
			System.out.print("Enter an odd number. ");
			i= sc.nextInt();
		}
		while (i%2==0);//Make sure the number entered is odd
		
		//Prints top half
		for (int x= i/2, star= 1; i>=star ; x--, star+=2){

			for (int s=0; x>s; s++){
				System.out.print(" ");//prints spaces needed
			}

			for (int y=0; star>y; y++){
				System.out.print("*");//prints stars needed
			}
			System.out.println(); //end each line
		}
		//Prints bottom half
		for (int x=1, star=i-2; star>=1; star-=2, x++){
			
			for (int s=0; x>s; s++){
				System.out.print(" ");//prints spaces needed
			}
			
			for (int y=0; star>y; y++){
				System.out.print("*");//prints stars needed
			}
			System.out.println();//end each line
		}
	}
}
