import java.util.*;

public class Connect4Game{
  private char [][] board;

  public Game(){
    board=new char [6][7];
    //make all elements of board have the value of 32 (space)
    for(int x=0; x<6;x++){
      for(int y=0;y<7;y++){
        board[x][y]=32;
      }
    }
  }
  public void printBoard(){
    //Print the board
    for(int x=-1;x<6;x++){
      for(int y=0;y<7;y++){
        if (x==-1){
          System.out.print(y+" ");
        }
        else{
          System.out.print(board[x][y]+" ");
        }
      }
      System.out.println();
    }
  }
  public void move(char sym, int col){
    boolean change=false;//Turn true when change has been made to keep
                         //unneeded changes from being made

    for(int x=5;x>-1&&(change==false);x--){
      if (board[x][col]==32){//checks to see if any player has piece in the element
        board[x][col]=sym;//if not change to player symbol
        change=true;
      }
    }
  }

  public boolean check(){
    boolean hasWinner = false;

    for(int x=5;x>2;x--){
      for(int y=0;y<7;y++){
        //check for a up and down win
        if (board[x][y]!=32 &&
            board[x][y] == board[x-1][y] &&
            board[x][y] == board[x-2][y] &&
            board[x][y] == board[x-3][y]){
          hasWinner=true;
        }
      }
    }
    
    for(int x=0;x<6;x++){
      for(int y=0;y<4;y++){
        //check for a side to side win
        if (board[x][y]!=32 &&
            board[x][y] == board[x][y+1] &&
            board[x][y] == board[x][y+2] &&
            board[x][y] == board[x][y+3]){
          hasWinner=true;
        }
      }
    }
    for(int x=5;x>2;x--){
      for(int y=3;y<7;y++){
        //check for a diagonal win (\)
        if (board[x][y]!=32 &&
            board[x][y] == board[x-1][y-1] &&
            board[x][y] == board[x-2][y-2] &&
            board[x][y] == board[x-3][y-3]){
          hasWinner=true;
        }
      }
    }
    for(int x=3;x<6;x++){
      for(int y=0;y<4;y++){
        //check for a diagonal win (/)
        if (board[x][y]!=32 &&
            board[x][y] == board[x-1][y+1] &&
            board[x][y] == board[x-2][y+2] &&
            board[x][y] == board[x-3][y+3]){
          hasWinner=true;
        }
      }
    }
    return hasWinner;
  }

  public int intelComMove(){ //Adds defence to the comMove
    int move=0;
    boolean went=false;

    for(int row=5;row>=0; row--){ //Move up and down the board
      for(int col=0;col<7 && went==false;col++){ //Move across the board
        move=blockAndWinChecker(row,col);  //call blockChecker and move equal the return

        if (move<7){ //blockAndWinChecker will return 8 if no move was made
          went=true;//if move was made change went to true
          System.out.println(move);
        }
      }
    }
    if(went==false){
      boolean colNotFull=false;
      
      do{
        Random rnm=new Random();
        move=rnm.nextInt(7);
        if(board[0][move]==32){
          colNotFull=true;
        }
      }
      while(colNotFull==false);
    }
    return move;
  }

  private int blockAndWinChecker(int row,int col){ //for checking where to move to block the player from winning and where comp can go to win
    int countPlayer,countComp,move=8; //to keep track of if move was made
    boolean went=false;

    if(row>2){ //check up and down
      countPlayer=0; //for counting '$'
      countComp=0; // for counting '#'

      for(int upAndDown=row; upAndDown>row-4; upAndDown--){ //Begin at current location and check up
        if(board[upAndDown][col]=='$'){
          countPlayer++; //count how many '$''s are in the next four elements
        }
        else if(board[upAndDown][col]=='#'){
          countComp++; //count how many '#''s are in the next four elements
        }
      }
      if(countComp==3 || countPlayer==3){  
        for(int checker=row; checker>row-4; checker--){
          if(board[checker][col]==32){
            move=col;
            went=true;
          }
        }
      }
    }
    if(col<4 && went==false){ //check -->
      countPlayer=0; //for counting '$'
      countComp=0; //for counting '#'

      for(int sideWays=col; sideWays<col+4; sideWays++){
        if(board[row][sideWays]=='$'){
          countPlayer++; //count how many '$''s are in the next four elements
        }
        else if(board[row][sideWays]=='#'){
          countComp++; //count how many '#''s are in the next four elements
        }
      }
          
      if((countComp==3 || countPlayer==3) && row<5){ //if not on bottom row and there are three '#'s or '$'s
        for(int checker=col; checker<col+4; checker++){ //start from original position and look for blank spots
          if(board[row][checker]==32 &&  //if blank spot is found
             board[row+1][checker]!=32){ // and there is something in the spot below it (dont want the piece to fall to far)
            move=checker; //move there
            went=true;
          }
        }
      }
      else if((countComp==3 || countPlayer==3) && row==5){ //if on the bottom row when there are three '#'s or '$'s
        for(int checker=col; checker<col+4; checker++){ //start from original position and look for a blank spot
          if(board[row][checker]==32){ //if a blank spot is found
            move=checker; //move there
            went=true;
          }
        }
      }
    }
    
    if(col>2 && went==false){ //check <--
      countPlayer=0;
      countComp=0;

      for(int sideWays=col; sideWays>col-4; sideWays--){
        if(board[row][sideWays]=='$'){
          countPlayer++; //count how many '$''s are in the next four elements
        }
        else if(board[row][sideWays]=='#'){
          countComp++; //count how many '#''s are in the next four elements
        }
      }
        
      if((countComp==3 || countPlayer==3) && row<5){ //if not on the bottom row and there are three '$''s
        for(int checker=col; checker>col-4; checker--){ //start from original position and look for a blank spot
          if(board[row][checker]==32 &&  //if blank spot is found
             board[row+1][checker]!=32){ //and the element just below is not blank
            move=checker; //move there
            went=true;
          }
        }
      }
      else if((countComp==3 || countPlayer==3) && row==5){
        for(int checker=col; checker>col-4; checker--){
          if(board[row][checker] == 32){
            move=checker;
            went=true;
          }
        }
      }
    }
    
    if(row>2 && col<4 && went==false){ //check /
      countPlayer=0;
      countComp=0;

      //diagRow will decrease every time to move up the board; while diagCol increases to move right
      for(int diagRow=row, diagCol=col; diagRow>row-4; diagRow--, diagCol++){ 
        if(board[diagRow][diagCol] == '$'){
          countPlayer++; //count the '$' in the next four elements
        }
        else if(board[diagRow][diagCol]=='#'){
          countComp++; //count how many '#''s are in the next four elements
        }

          
        if(countComp==3 || countPlayer==3){
          for(int rowChecker=row, colChecker=col; rowChecker>row-4; rowChecker--,colChecker++){
            if(board[rowChecker][colChecker]==32){
              if(rowChecker==5){ //if rowChecker is on the bottom row when blank spot is found
                move=colChecker; //move there
                went=true;
              }
              else if(rowChecker<5 && //else if the blank spot is not on the bottom row
                      board[rowChecker+1][colChecker]!=32){ //and the posistion just below it is not blank
                move=colChecker; //move there
                went=true;
              }
            }
          }
        }
      }
    }

    if(row>2 && col>2 && went==false){ //check \
      countPlayer=0;
      countComp=0;

      //diagRow deceases every pass to move up, and diagCol decease as well to move left across the board
      for(int diagRow=row, diagCol=col; diagRow>row-4; diagRow--, diagCol--){
        if(board[diagRow][diagCol]=='$'){
          countPlayer++;
        }
        else if(board[diagRow][diagCol]=='#'){
          countComp++; //count how many '#''s are in the next four elements
        }

          
        if(countComp==3 || countPlayer==3){
          for(int rowChecker=row, colChecker=col; rowChecker>row-4;rowChecker--, colChecker--){
            if(board[rowChecker][colChecker]==32){
              if(rowChecker==5){
                move=colChecker;
                went=true;
              }
              else if(rowChecker<5 &&
                      board[rowChecker+1][colChecker]!=32){
                move=colChecker;
                went=true;
              }
            }
          }
        }
      }
    }
    return move;
  }
  public boolean isBoardFull(){ //checks to see if the borad is full
    boolean full=false;
    for(int col=0; col<7;col++){
      if(board[0][col]!=32){
        full=true;
      }
      else{
        full=false;
        break;
      }
    }
    return full;
  }
}
