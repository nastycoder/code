/*
	Find the sum of all primes under two millon
	March 28,2012
*/

public class Problem10{
	public static void main(String [] args){
		long total=0L;
		boolean isPrime;
		for(int i=2;i<2000000;i++){
			isPrime=true;
			for(int x=2;x<=Math.sqrt(i);x++){
				if(i%x==0){
					isPrime=false;
					break;
				}
			}
			if(isPrime){
				total+=i;
				System.out.println(i);
			}
		}
		System.out.println(total);
	}
}
