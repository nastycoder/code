import java.util.*;

public class TickTackDriver{
	public static void main(String [] args){
		TickTackToe play=new TickTackToe();
		Scanner sc=new Scanner(System.in);
		boolean winner=false;

		play.printBoard();
		
		while(play.check()==false){
			
			boolean cont=false;

			do{
				System.out.print("Whats your move?(row,col)  ");
				int row=sc.nextInt(), col=sc.nextInt();
				cont=play.move(row,col);
			}
			while(cont==false);
			play.printBoard();
			
			if(play.check()==true){
				break;
			}
			else{
				play.comMove();
				play.printBoard();
			}
		}
		System.out.println("GAME OVER");
	}
}
