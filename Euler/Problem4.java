/*
	Find the largest palindrome made from the product of two 3-digit numbers.
	March 27,2012
*/

public class Problem4{
	public static void main(String [] args){
		int val=0,newVal=0,temp=0,max=0;
		for (int i=100;i<1000;i++){
			for(int x=100;x<1000;x++){
				val=i*x;
				int hold=val;
				newVal=0;
				while(val>0){
					temp=val%10;
					newVal=newVal*10+temp;
					val/=10;
				}
				if(newVal==hold &&
					 newVal>max){
					max=newVal;
				}
			}
		}
		System.out.println(max);
	}
}
