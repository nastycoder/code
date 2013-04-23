import java.io.*;
import java.util.*;
import java.text.*;

class CUSTOMER{
	public static void main(String [] args)throws Exception{
		Scanner sc=new Scanner(new File("CUSTOMER.DAT"));
		FileWriter file=new FileWriter("CUSTOMER.RPT");
		PrintWriter pw=new PrintWriter(file,true);
		String line;
		for(int i=0;i<25;i++){
			pw.print(" ");
		}
		pw.println("CUSTOMER LISTING\n\n");
		pw.print("    CUST");
		for(int i=0;i<10;i++){
			pw.print(" ");
		}
		pw.print("CUST");
		for(int i=0;i<14;i++){
			pw.print(" ");
		}
		pw.print("CREDIT");
		for(int i=0;i<7;i++){
			pw.print(" ");
		}
		pw.print("BALANCE\n     NO ");
		for(int i=0;i<10;i++){
			pw.print(" ");
		}
		pw.print("NAME");
		for(int i=0;i<14;i++){
			pw.print(" ");
		}
		pw.print("RATING");
		for(int i=0;i<9;i++){
			pw.print(" ");
		}
		pw.println("DUE\n");

		int total=0;
		while(sc.hasNextLine()){
			line=sc.nextLine();
			if (line.charAt(23)!='A'&&line.charAt(23)!='G'){
				pw.print("     "+line.substring(0,3)+"     "+line.substring(3,23)+"     "+line.substring(23,25)+"          $");
				int bal=Integer.parseInt(line.substring(25,30));
				String sbal=String.format("%, d",bal);
				for(int i=sbal.trim().length();i<6;i++){
					pw.print(" ");
				}
				pw.println(sbal.trim());
				total+=bal;
			}
		}
		pw.println();
		for(int i=0;i<23;i++){
			pw.print(" ");
		}
		pw.print("TOTAL BALANCE DUE");
		String stotal=String.format("%, d",total);
		for(int i=stotal.trim().length();i<16;i++){
			pw.print(" ");
		}
		pw.println("$"+stotal.trim());
	}
}
