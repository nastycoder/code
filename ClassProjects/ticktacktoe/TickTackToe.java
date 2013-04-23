public class TickTackToe{
	private char [][] board;

	public TickTackToe(){
		board=new char [3][3];
		//make all elements equal ASCII character 32
		for(int x=0;x<3;x++){
			for(int y=0;y<3;y++){
				board[x][y]=' ';
			}
		}
	}

	public void printBoard(){
		for(int x=-1;x<3;x++){
			if(x>-1){
				System.out.print(x+" "); //print each row number
			}
			for(int y=0;y<3;y++){
				if(x==-1){
					System.out.print(" "+y+" "); //print each col. number 
				}
				else{
					System.out.print(board[x][y]+" "); //print each element
				}
			}
			System.out.println();

		}
	}

	public boolean move(int row,int col){
		boolean cont=false;
		if(board[row][col]==' '){ //If no player has a piece in that selected position
			board[row][col]='X'; // claim it and
			cont=true; // return true to continue the game
		}
		return cont;
	}

	public void comMove(){ //Computer's move
		boolean went=false;

		for(int x=0;(x<3)&&(went==false);x++){
			//Next three steps in ladder check for posible wins side to side
			if(board[x][0] =='X' &&
				 board[x][1] =='X' &&
				 board[x][2] ==' '){

				board[x][2]='O';
				went=true;
			}
			else if(board[x][2] == 'X' &&
							board[x][1] == 'X' &&
							board[x][0] == ' '){
			
				board[x][0]='O';
				went=true;
			}
			else if(board[x][0] =='X' &&
							board[x][2] =='X' &&
							board[x][1] ==' '){
			
				board[x][1]='O';
				went=true;
			}
			//Next three steps in ladder check for posible wins up and down 
			else if(board[0][x] == 'X' &&
							board[1][x] == 'X' &&
							board[2][x] == ' '){
				
				board[2][x]='O';
				went=true;
			}
			else if(board[2][x] == 'X' &&
							board[1][x] == 'X' &&
							board[0][x] == ' '){
				
				board[0][x]='O';
				went=true;
			}
			else if(board[0][x] == 'X' &&
							board[2][x] == 'X' &&
							board[1][x] == ' '){
				
				board[1][x]='O';
				went=true;
			}
			//Next three steps in ladder check for posible wins  \
			else if(board[0][0] == 'X' &&
							board[1][1] == 'X' &&
							board[2][2] == ' '){
			
				board[2][2]='O';
				went=true;
			}
			else if(board[2][2] == 'X' &&
							board[1][1] == 'X' &&
							board[0][0] == ' '){
				
				board[0][0]='O';
				went=true;
			}
			else if(board[0][0] == 'X' &&
							board[2][2] == 'X' &&
							board[1][1] == ' '){
				
				board[1][1]='O';
				went=true;
			}
			//Next steps in ladder check for posible wins /
			else if(board[0][2] =='X' &&
							board[1][1] =='X' &&
							board[2][0] ==' '){
			
				board[2][0]='O';
				went=true;
			}
			else if(board[2][0] =='X' &&
							board[1][1] =='X' &&
							board[0][2] ==' '){
			
				board[0][2]='O';
				went=true;
			}
			else if(board[0][2] =='X' &&
							board[2][0] =='X' &&
							board[1][1] ==' '){
			
				board[1][1]='O';
				went=true;
			}
		}
		//If no move has been made yet pick first open spot
		if(went==false){
			for(int x=0;(x<3)&&(went==false);x++){
				for(int y=0;(y<3)&&(went==false);y++){
					if(board[x][y] == ' '){
						board[x][y]='O';
						went=true;
					}
				}
			}
		}
	}

	public boolean check(){
		boolean winner=false;
		
		//This block checks to see if board is full
		for(int x=0;x<3;x++){
			for(int y=0;y<3;y++){
				if(board[x][y] == ' '){
					winner=false; //If blank position is found return "winner" to false and 
					break; // break the loop
				}
				else{
					winner=true;
				}
			}
		}
		//check side to side for winner
		for(int x=0;x<3;x++){
			if(board[x][0] !=' ' &&
				 board[x][0] == board[x][1] &&
				 board[x][0] == board[x][2]){
				winner=true;
			}
		}

		//check up and down for winner
		for(int x=0;x<3;x++){
			if(board[0][x] !=' ' &&
				 board[0][x] == board[1][x] &&
				 board[0][x] == board[2][x]){
				winner=true;
			}
		}
		//check (\) for winner
		if(board[0][0] !=' ' &&
			 board[0][0] == board[1][1] &&
			 board[0][0] == board[2][2]){
			winner=true;
		}
		//check (/) for winner
		else if(board[0][2] !=' ' &&
						board[0][2] == board[1][1] &&
						board[0][2] == board[2][0]){
			winner=true;
		}
		return winner;
	}
}
