/*
 * Evaluate the sum of all the amicable numbers under 10000.
 * Solved May25, 2012
*/
public class Problem21{
	public static void main(String [] args){

		long total=0;
		for(int i=2;i<10000;i++){
			int runTotal=0;
			for(int x=1; x<i;x++){
				if(i%x==0){
					runTotal+=x;
				}
			}
			int runAgain=0;
			for(int x=1;x<runTotal;x++){
				if(runTotal%x==0){
					runAgain+=x;
				}
			}
			if(runAgain==i&&i!=runTotal){
				System.out.println(i+"     "+runTotal);
				total+=i;
			}
		}
		System.out.println(total);
	}
}
