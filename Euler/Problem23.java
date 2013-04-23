/*
 *	Find the sum of all positive integer which cannot be written as the sum of 
 *	two abundant numbers
 *
 */
public class Problem23{
	public static void main(String [] args){
	
		int [] abund=new int [0];
		for(int i=11;i<28123;i++){
			int sumDivsor=0;
			for(int x=1;x<i;x++){
				if(i%x==0){
					sumDivsor+=x;
				}
			}
			if(sumDivsor>i){
				int [] hold=new int [abund.length+1];
				for(int x=0;x<abund.length;x++){
					hold[x]=abund[x];
				}
				hold[abund.length]=i;
				abund=hold;
			}
		}
		System.out.println(abund[0]);
		System.out.println(abund[1]);
		System.out.println(abund[2]);
	}
}
