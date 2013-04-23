//Prints and Empty diamond

import java.io.*;
import java.util.*;
public class EmptyDiamond{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        int inNum = 0;

        do{
            System.out.print("Enter an odd number. ");
            inNum = sc.nextInt();    
        }
        while (inNum % 2 == 0); //Continues when an od number is entered 

        for (int star1 = inNum/2+1, star2 = star1; star1 >= 1; star1--, star2 ++){
        
            for (int pos = 1; pos <= inNum; pos++){
                if (pos == star1 || pos == star2){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
        
        for (int star1 = 2, star2 = inNum-1; star1 <= inNum/2+1; star1++, star2--){

            for (int pos =1; pos<= inNum; pos++){

                if (pos ==star1 || pos == star2){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}
