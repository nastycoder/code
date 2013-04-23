/*
	Find the sum of the digits in the number 100!
	April 2,2012
*/
import java.math.*;
public class Problem20{
	public static void main(String [] args){
		BigInteger pro=BigInteger.valueOf(1);
	
		for(int i=2;i<101;i++){
			pro=pro.multiply(BigInteger.valueOf(i));
		}
		int sum=0;
		while(pro.compareTo(BigInteger.valueOf(0))>0){
			int num=pro.mod(BigInteger.valueOf(10)).intValue();
			sum+=num;
			pro=pro.divide(BigInteger.valueOf(10));
		}
		System.out.println(sum);
	}
}
