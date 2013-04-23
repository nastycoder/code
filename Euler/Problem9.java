/*
	Find the products of Pythagorean triplet that the sum of equal 1000
	March 28,2012
*/

public class Problem9{
	public static void main(String [] args){
		for(int a=1;a<1000;a++){
			for(int b=a+1;b<1000;b++){
				for(int c=b+1;c<1000;c++){
					if(a+b+c==1000&&
						 (a*a)+(b*b)==(c*c)){
						System.out.println(a+"  "+b+"  "+c+"\n"+(a*b*c));
					}
				}
			}
		}
	}
}
