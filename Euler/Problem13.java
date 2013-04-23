/* 
	Sum of 100, 50 digit numbers
	March 30,2012
*/


import java.util.*;
import java.io.*;
public class Problem13{
	public static void main(String [] args)throws IOException{
		Scanner sc=new Scanner(new File("Problem13.in"));
		Add getit=new Add();
		String num=sc.nextLine();
		while(sc.hasNextLine()){
			String num2=sc.nextLine();
			num=getit.AddItUp(num,num2);
		}
		System.out.println(num);
	}
}
