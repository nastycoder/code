/* Which prime, below one-million, can be written as the sum of the most consecutive primes?
*/
//NOT WORKING
public class Problem50{
	public static void main(String [] args){
		int [] primes=new int [0];
		boolean isPrime=true;

		//find all prime below 1 mill
		for (int i=2;i<1000;i++){
			isPrime=true;
			for (int x=2;x<i;x++){
				if(i%x==0){
					isPrime=false;
					break;
				}
			}
			if(isPrime){
				int [] mover=new int [primes.length+1];
				for(int count=0;count<primes.length;count++){
					mover[count]=primes[count];
				}
				mover[primes.length]=i;
				primes=mover;
			}
		}
	//test to find the largest sum
	for(int i=primes.length-1;i>0;i--){
		for(int x=0,sum=0;sum<primes[i];x++){
			sum+=primes[x];
			if(sum==primes[i]){
			 System.out.println(primes[i]+"\t"+x);
			}
		}
	}
		
	}
}
