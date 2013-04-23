/*
	How many routes are there through a 2121 grid?
solved may 24,2012
*/
public class Problem15{
	public static void main(String [] args){
		long [][] grid=new long [21][21];

		for(int i=0;i<21;i++){
			grid[0][i]=grid[i][0]=1L;
		}
		for(int i=1;i<21;i++){
			for(int x=1;x<21;x++){
				grid[i][x]=grid[i][x-1]+grid[i-1][x];
			}
		}
		System.out.println(grid[20][20]);
	}
}
