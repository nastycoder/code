/*
	How many Sundays fell on the first of the month during the twentieth 
	century (1 Jan 1901 to 31 Dec 2000)?
	
*/
public class Problem19{
	public static void main(String [] args){
		int [] month={31,28,31,30,31,30,31,31,30,31,30,31};
//		String [] day={"Sun","Mon","Tue","Wed","Thur","Fri","Sat"}
		int firstMonthOnSunday=0;
		int year=1900,d=1;
		for(;year<2001;year++){
			if(year%4==0){
				month[1]=29;
			}else{
				month[1]=28;
			}
			for(int mon=0;mon<month.length;mon++){
				if(d==0&&year>=1901){
					firstMonthOnSunday++;
					System.out.println(year);
				}
				for(int i=0;i<month[mon];i++){
					d++;
					if(d>6)
						d=0;
				}
			}
		}
		System.out.println(firstMonthOnSunday);
	}
}
