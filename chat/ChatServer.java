import java.io.*;
import java.net.*;
import java.util.*;

public class ChatServer{
	public static void main(String [] args){
		try{
			ServerSocket ss=new ServerSocket(6789);
			Socket s=ss.accept();
			PrintWriter pw=new PrintWriter(s.getOutputStream(),true);
			Scanner scOut=new Scanner(System.in);
			Scanner scIn=new Scanner(new InputStreamReader(s.getInputStream()));
			for(;;){
				if(scIn.hasNextLine()){
					System.out.println(scIn.nextLine());
					pw.println(scIn.nextLine());
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
