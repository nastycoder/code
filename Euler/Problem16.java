/*
	What is the sum of the digits of the number 21000?\
	April 1,2012
*/
import java.math.*;
public class Problem16{
	public static void main(String [] args){
		BigInteger num=BigInteger.valueOf(2);
		num=num.pow(1000);
		String bigNum=num.toString();
		int sum=0;
		for(int i=0;i<bigNum.length();i++){
			sum+=Integer.parseInt(bigNum.substring(i,i+1));
		}
		System.out.println(sum);
	}
}
