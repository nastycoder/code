/*
	Find the 10,001st prime number
	March 27,2012
*/

public class Problem7{
	public static void main(String [] args){
		int count=0,prime=0;
		boolean isPrime=true;
		for(int i=2;count<10001;i++){
			isPrime=true;
			for(int x=2;x<=Math.sqrt(i);x++){
				if(i%x==0){
					isPrime=false;
					break;
				}
			}
			if(isPrime){
				count++;
				prime=i;
			}
		}
		System.out.println(prime);
	}
}
