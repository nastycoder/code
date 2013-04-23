import java.io.*;
import java.net.*;
import java.util.*;

public class ChatClient{
	public static void main(String [] args){
		int port=Integer.parseInt(args[1]);

		try{
			Socket s=new Socket(args[0], port);
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			Scanner sc=new Scanner(System.in);
			Scanner scIn=new Scanner(new InputStreamReader(s.getInputStream()));
			for(;;){
				if(sc.hasNextLine()){
					pw.println(sc.nextLine());
				}
				else if(scIn.hasNextLine()){
					System.out.println(scIn.nextLine());
				}
				else{
					Thread.sleep(5000);
				}
			}
		}
		catch(Exception e){
			System.out.println(e);
		}
	}
}
