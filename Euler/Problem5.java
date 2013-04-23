/*
	What is the smallest positive number that is evenly divisible 
		by all of the numbers from 1 to 20?
	March 27,2012
*/

public class Problem5{
	public static void main(String [] args){
		int num=0;
		boolean isOk=true;
		for(long i=100000000L;i<999999999999999L;i++){
			for(int x=1;x<21;x++){
				isOk=true;
				if(i%x!=0){
					isOk=false;
					break;
				}
			}
			if(isOk){
				System.out.println(i);
				break;
			}
		}
	}
}
