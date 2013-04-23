/* What is the total of all the name scores in the file names.txt
 *
 *Sovled May 25, 2012
*/
import java.util.*;
import java.io.*;

public class Problem22{
	public static void main(String [] args)throws Exception{
		Scanner sc=new Scanner(new File("names.txt"));
		PrintWriter pw=new PrintWriter(new FileWriter("nameSorted.txt"));
		String [] names=new String [0];
		int count=0;

		//Get all Names fromm the file and put them into an array
		while (sc.hasNext()){
			String [] hold=new String [names.length+1];
			for(int i=0;i<names.length;i++){
				hold[i]=names[i];
			}
			hold[names.length]=sc.next();
			names=hold;
			count++;
		}
		System.out.println(count+" elements in the array.");
		
		//Sort the array into alphabetical order using a bubble sort
		boolean changesMade=true;
		while(changesMade){
			changesMade=false;
			for(int i=0;i<names.length-1;i++){
				if(names[i].compareTo(names[i+1])>0){
					String hold=names[i+1];
					names[i+1]=names[i];
					names[i]=hold;
					changesMade=true;
				}
			}
		}
		System.out.println("Sorted\n");

		for(int i=0;i<names.length;i++){
			pw.println(names[i]);
		}

		//Create a name score for all names and put them into a parallel array
		int [] scores=new int [names.length];
		for(int i=0;i<scores.length;i++){
			int sum=0;
			for(int x=0;x<names[i].length();x++){
				sum+=((int)names[i].toUpperCase().charAt(x))-64;
			}
			scores[i]=sum*(i+1);
		}
		System.out.println("Scored");

		//Add all the scores
		long total=0;
		for(int i=0;i<scores.length;i++){
			total+=scores[i];
		}

		System.out.println("\nTotaled\n"+total);
	}
}
