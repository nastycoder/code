/*
	Find the first triangle number if 500 divisors
	March 29,2012
*/

public class Problem12{
	public static void main(String [] args){
		long value=2162160;
		for(int i=2080;;i++){
			value+=i;
			int counter=2;
			int sqrt=(int)Math.sqrt(value);
			for(int x=2;x<=sqrt;x++){
				if(value%x==0){
					counter+=2;
				}
				if(sqrt*sqrt==value){
					counter--;
				}
			}
			if(counter>500){
				System.out.println(value+"   "+i);
				break;
			}
		}
	}
}
