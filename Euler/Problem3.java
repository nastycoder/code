/*
	What is the largest prime factor of the number 600851475143?
	March 27,2012
*/

public class Problem3{
	public static void main(String [] args){
		long max=0,num=600851475143L;
		boolean isPrime=true;
		for (long i=2;i<Math.sqrt(num);i++){
			if(num%i==0){
				for (long x=2;x<=Math.sqrt(i);x++){
					if (i%x!=0){
						isPrime=true;
					}else{
						isPrime=false;
						break;
					}
				}
				if(isPrime){
					max=i;
				}
			}
		}
		System.out.println(max);
	}
}
