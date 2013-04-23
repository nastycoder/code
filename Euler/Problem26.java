/*
 *  Find the value of d  1000 for which 1/d contains the longest recurring cycle
 *  in its decimal fraction part.
 *
 */
import java.math.*;
public class Problem26{
	public static void main(String [] args){
		//find all primes <1000
		int [] primes=new int [0];
		boolean isPrime;
		for(int i=6;i<1000;i++){
			isPrime=true;
			for(int x=2;x<i;x++){
				if(i%x==0){
					isPrime=false;
					break;
				}
			}
			if(isPrime){
				int [] hold=new int [primes.length+1];
				for(int x=0;x<primes.length;x++){
					hold[x]=primes[x];
				}
				hold[primes.length]=i;
				primes=hold;
			}
		}
		System.out.println(1.0/7.0);
	}
}
