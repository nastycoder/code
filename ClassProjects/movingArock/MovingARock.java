import java.util.*;
import java.io.*;

class MovingARock{
	public static void main(String [] args) throws IOException{
		Scanner sc=new Scanner(new File("input.txt"));
		
		while (sc.hasNextLine()){
			int N=sc.nextInt(), T=sc.nextInt(), X=sc.nextInt(), Y=sc.nextInt(),z=1;
			sc.nextLine(); sc.nextLine();
			
			for (int x=0; x<T; x++){
				if(z%2==0){
					z+=X;
				}
				else{
					z+=Y;
				}
				if (z>N){
					z=z-N;
				}
			}
			if (z%2==1){
				System.out.println("Alice wins\n");
			}
			else{
				System.out.println("Bob wins\n");
			}
		}
	}
}
