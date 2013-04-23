import java.util.*;

public class GameDriver{
  public static void main(String [] args){
    Game gam=new Game();
    Scanner sc=new Scanner(System.in);
    boolean gameOver=false;

    while(gameOver==false){
      gam.printBoard();
      int col=0, move;

      do{
        System.out.print("Player, whats your move? ");
        col=sc.nextInt();
      }
      while ((col>6)||(col<0));
    
      gam.move('$',col);
      gameOver=gam.check();
      
      if (gameOver==true){
        gam.printBoard();
        System.out.println("Hey You WON!!!");
        break;
      }
      else{
        gam.printBoard();
      }

      move=gam.intelComMove();
      gam.move('#',move);
      gameOver=gam.check();
      
      if (gameOver==true){
        gam.printBoard();
        System.out.println("HaHa, I beat you!!!");
        break;
      }

      gameOver=gam.isBoardFull();
      if (gameOver==true){
        gam.printBoard();
        System.out.println("The board is full\nGAME OVER");
      }
    }
  }
}
