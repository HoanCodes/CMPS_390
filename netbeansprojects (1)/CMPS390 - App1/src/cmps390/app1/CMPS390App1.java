package cmps390.app1;
import java.util.Scanner;

public class CMPS390App1 {
    public static void main(String[] args) {
        
        //Task 1.a)-------------------------------------------------------------------------------------
        double sum=0;
        int i;
        int j=0;
                
        for(i=0; i<11; i++){
            sum=sum+i;
        }
        
        System.out.println(sum);
        
        //Task 1.b)------------------------
        sum=0;
        
        while (j<11){
            sum=sum+j;
            j++;    
        }
        
        System.out.println(sum);
        
        //Task 1.d)------------------------
        sum=0;
        double avrg=0;
        
        for(i=0; i<11; i++){
            if (i==10){
                sum=sum+i;
                avrg=sum/10;
            }
            else{
                sum=sum+i;
            };            
        }
        
        System.out.println(avrg);
    
        //Task 2.a)-------------------------------------------------------------------------------------
        int counter=0;
        int countTime=0;
        
        while(counter<=360){
            if (counter==360&&countTime<=3){
                System.out.println("Function has counted to 360 once--");
                countTime++;
                counter=0;
            }
            else if (countTime==3){
                System.out.println("Function has counted to 360 " + countTime + " times!");
                counter=361;
            }
            else{
                counter=counter+5;
            }
        }
        
        //Task 2.b------------------------
        counter=0;
        countTime=0;
        int inputTime=0;
        Scanner input = new Scanner(System.in);
        
        System.out.println ("Please give a number of times you want the function to count to 360:");
        inputTime =input.nextInt();
        while(counter<=360){
            if (counter==360&&countTime<=inputTime){
                System.out.println("Function has counted to 360 once--");
                countTime++;
                counter=0;
            }
            else if (countTime==inputTime){
                System.out.println("Function has counted to 360 " + countTime + " times!");
                counter=361;
            }
            else{
                counter=counter+5;
            }
        }
    }
}
