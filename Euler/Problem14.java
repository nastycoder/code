/*
	Collatz Conjecture
	March 30,2012
*/

public class Problem14{
	public static void main(String [] args){
		int stNum=0,maxCounter=0,counter;
		for(int i=1000000;i>0;i--){
			counter=1;
			for(long n=i;n!=1;counter++){
				if(n%2==0){
					n/=2;
				}else{
					n=3*n+1;
				}
			}
			if(counter>maxCounter){
				maxCounter=counter;
				stNum=i;
				System.out.println(i+"  "+counter);
			}
		}
		System.out.println(stNum+"  "+maxCounter);
	}
}
