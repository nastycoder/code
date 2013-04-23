import java.io.*;
import java.text.*;
import java.util.*;

class TAXI{
	public static void main(String [] args)throws Exception{
		Scanner sc=new Scanner(new File("TAXI.DAT"));
		FileWriter file=new FileWriter("TAXI.RPT");
		PrintWriter pw=new PrintWriter(file,true);
		String line;
		int miles=0; 
		double gall=0;
		for(int i=0;i<29;i++){
			pw.print(" ");
		}
		pw.println("A B C TAXI COMPANY\n\n");
		pw.print("VEHICLE ID     VEHICLE DESC   MILES TRAVELLED         GALLONS        AVERAGE\n\n");
		while(sc.hasNextLine()){
			line=sc.nextLine();
			pw.print(line.substring(0,10)+"     "+line.substring(10,20)+"        ");
			int mi=Integer.parseInt(line.substring(20,24));
			double ga=Double.parseDouble(line.substring(24,28))/100;
			String mil=String.format("%,d",mi);
			for(int i=mil.length();i<5;i++){
			 pw.print(" ");
			}
			
			pw.print(mil);
			for(int i=0;i<17;i++){
				pw.print(" ");
			}
			String gallon=String.format("%.2f", ga);
			for(int i=gallon.length();i<5;i++){
			 pw.print(" ");
			}
			//FIX THIS
			pw.print(gallon);
			for(int i=0;i<10;i++){
				pw.print(" ");
			}
			pw.print(String.format("%.2f",mi/ga));
			miles+=mi;
			gall+=ga;
			pw.println();
		}
		pw.println();
		for(int i=0;i<15;i++){
			pw.print(" ");
		}
		pw.print("TOTALS");
		String m=String.format("%, d",miles);
		for(int i=0;i<17-m.length();i++){
			pw.print(" ");
		}
		pw.print(m);
		String g=String.format("%.2f",gall);
		for(int i=0;i<22-g.length();i++){
		pw.print(" ");
		}
		pw.print(g);
		for(int i=0;i<10;i++){
		 pw.print(" ");
		}
		pw.println(String.format("%.2f",miles/gall));
	}
}
