import java.io.*;
import java.util.*;
import java.text.*;
class VALIDATE{
	public static void main(String [] args) throws Exception{
		Scanner sc=new Scanner(new File("VALIDATE.DAT"));
		FileWriter file=new FileWriter("VALIDATE.RPT");
		PrintWriter pw=new PrintWriter(file,true);
		int page=1;
		pageStart(page,pw);
		int rec=0, linNum=0;
		String line;
		int noNum=0,noNam=0,inSal=0,inDep=0;
		while(sc.hasNextLine()){
			if(rec>=20&&rec%20==0){
				page++;
				pw.print((char)12);
				pageStart(page,pw);
			}
			line=sc.nextLine();
			boolean goodEmp=true;
			String emp=line.substring(0,5);
			try{
				Integer.parseInt(emp);
			}catch(Exception e){
				goodEmp=false;
			}
			pw.print(emp);
			for(int i=0;i<10;i++){
				pw.print(" ");
			}
			String name=line.substring(5,25).trim();
			pw.print(name);
			boolean goodName=true;
			if(name.length()<1){
				goodName=false;
			}

			for(int i=name.length();i<30;i++){
				pw.print(" ");
			}
			String sal=line.substring(29,35).trim();
			boolean goodSal=true;
			int money=0;
			try{
				money=Integer.parseInt(sal.trim());
			}catch(Exception e){
				goodSal=false;
			}
			if(goodSal){
				pw.print("$");
				sal=String.format("%, d",money).trim();
				for(int i=sal.length();i<7;i++){
					pw.print(" ");
				}
				pw.print(sal);
			}else{
				pw.print(sal+" ");
			}
			if(money>=100000||!goodSal){
				pw.print(" ");
			}
			for(int i=sal.length();i<16;i++){
				pw.print(" ");
			}
			String dep=line.substring(44,46);
			pw.println(dep);
			boolean goodDep;
			if(dep.equals("01")){
				goodDep=true;
			}else if(dep.equals("02")){
				goodDep=true;
			}else if(dep.equals("03")){
				goodDep=true;
			}else if(dep.equals("04")){
				goodDep=true;
			}else if(dep.equals("05")){
				goodDep=true;
			}else{
				goodDep=false;
			}
			rec++;
			linNum++;
			if(!goodEmp){
				pw.println("*ERROR*          EMPLOYEE NOT NUMERIC");
				linNum++;
				noNum++;

			}
			if(!goodName){
				pw.println("*ERROR*          NAME MISSING");
				linNum++;
				noNam++;
			}
			if(!goodSal){
				pw.println("*ERROR*          SALARY NOT NUMERIC");
				linNum++;
				noNum++;
			}
			if(money>100000){
				pw.println("*ERROR*          SALARY > $100,000");
				linNum++;
				inSal++;
			}
			if(!goodDep){
				pw.println("*ERROR*          DEPT CODE INVALID");
				linNum++;
				inDep++;
			}
			pw.println();
		}
		pw.println("\n");
		pw.print("RECORDS PROCESSED");
		for(int i=0;i<7;i++){
			pw.print(" ");
		}
		if(rec>9){
			pw.println(rec);
		}else{
			pw.println(" "+rec);
		}
		pw.println();
		pw.print("TOTAL NOT NUMERIC");
		for(int i=0;i<7;i++){
			pw.print(" ");
		}
		if(noNum>9){
			pw.println(noNum);
		}else{
			pw.println(" "+noNum);
		}
		pw.print("TOTAL MISSING NAMES");
		for(int i=0;i<5;i++){
			pw.print(" ");
		}
		if(noNam>9){
			pw.println(noNam);
		}else{
			pw.println(" "+noNam);
		}
		pw.print("TOTAL INVALID SALARIES");
		for(int i=0;i<2;i++){
			pw.print(" ");
		}
		if(inSal>9){
			pw.println(inSal);
		}else{
			pw.println(" "+inSal);
		}
		pw.print("TOTAL INVALID DEPTS");
		for(int i=0;i<5;i++){
			pw.print(" ");
		}
		if(inDep>9){
			pw.println(inDep);
		}else{
			pw.println(" "+inDep);
		}
	}
	public static void pageStart(int num,PrintWriter pw){

		pw.println();
		for(int i=0;i<29;i++){
			pw.print(" ");
		}
		pw.print("VALIDATION REPORT");
		for(int i=0;i<27;i++){
			pw.print(" ");
		}
		pw.print("PAGE ");
		if(num<10){
			pw.print(" ");
		}
		pw.println(num+"\n\n");
		pw.print("EMP NO");
		for(int i=0;i<12;i++){
			pw.print(" ");
		}
		pw.print("NAME");
		for(int i=0;i<25;i++){
			pw.print(" ");
		}
		pw.print("SALARY");

		for(int i=0;i<7;i++){
			pw.print(" ");
		}
		pw.println("DEPARTMENT\n\n");
	
	}
}
