/*
If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?

sovled may 24, 2012

*/


public class Problem17{
	public static void main(String [] args){
		int sum=0, total=0, counter;
		int [] nums={0,1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19};
		String [] words={"","one","two","three","four","five","six","seven","eight","nine","ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen","hundred","thousand"};
		for(int i=1;i<102;i++){
			counter=i;
			sum=0;
			if(i/100>0&&i%100>0){
				sum+=words[20].length()+3;
			}else if(i/100%10!=0){
				sum+=words[20].length();
			}
			if(i/1000>0){
				sum+=words[21].length();
			}
			int tens=counter%100;
			if(tens<20){
				sum+=words[tens].length();
			}else if(tens<40){
				sum+=6+words[tens%10].length();
			}else if(tens<60){
				sum+=5+words[tens%10].length();
			}else if (tens>79&&tens<90){
				sum+=words[tens%10].length()+words[tens/10].length()+1;
			}else{
				sum+=words[tens%10].length()+words[tens/10].length()+2;
			}
			counter/=100;
			while(counter>0){
				sum+=words[counter%10].length();
				counter/=10;
			}
			total+=sum;
			System.out.println(sum+"    "+i);
		}
		System.out.println(total);
	}
}
