/*
 * Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * 
 * Sovled May 27,2012
 */
import java.math.*;

public class Problem25{
	public static void main(String [] args){
		BigInteger [] bigNum=new BigInteger [2];
		bigNum[0]=bigNum[1]=BigInteger.valueOf(1L);
		
		boolean notLongEnough=true;

		for(int i=2;notLongEnough;i++){
			BigInteger [] hold=new BigInteger [bigNum.length+1];
			for(int x=0;x<bigNum.length;x++){
				hold[x]=bigNum[x];
			}
			hold[i]=hold[i-1].add(hold[i-2]);
			bigNum=hold;
			String check=bigNum[i].toString();
			if(check.length()==1000){
				System.out.println(i+1);
				notLongEnough=false;
			}
		}
	}
}
