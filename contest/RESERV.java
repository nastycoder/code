import java.io.*;
import java.util.*;
import java.text.*;

class RESERV{
	public static void main(String [] args)throws Exception{
		Scanner sc=new Scanner(new File("RESERV.DAT"));
		FileWriter file=new FileWriter("RESERV.RPT");
		PrintWriter pw=new PrintWriter(file,true);

		for(int i=0;i<20;i++){
			pw.print(" ");
		}
		pw.println("SLEEP SO TIGHT RESERVATION REPORT\n");
		pw.print("DATE");
		for(int i=0;i<20;i++){
			pw.print(" ");
		}
		pw.print("NAME");
		for(int i=0;i<26;i++){
			pw.print(" ");
		}
		pw.println("ROOM\n");

		while(sc.hasNextLine()){
			String line=sc.nextLine();
			int mon=Integer.parseInt(line.substring(0,2));
			String month;
			if(mon==3){
				month="March ";
			}else if(mon==4){
				month="April ";
			}else{
				month="May ";
			}
			String date=month+line.substring(2,4)+" "+line.substring(4,8);
			pw.print(date);
			for(int i=date.length();i<24;i++){
				pw.print(" ");
			}
			int sp=line.indexOf(' ');
			String nam=line.substring(sp+1,33).trim()+", "+line.substring(8,sp);
			pw.print(nam);
			for(int i=nam.length();i<30;i++){
				pw.print(" ");
			}
			pw.println(line.substring(33)+"\n");
		}
	}
}
