package cmps390.app1.p2;

public class CMPS390App1P2 {
    public static void main(String[] args) {
        
        //Task 3.-------------------------------------------------------------------------------------
        double rad = 0;
        double[] sine = new double[73];
        
        for(int i=0; i<73; i++){
            //sine[i]=i;
            rad=(i*5*Math.PI)/180;
            sine[i]=Math.sin(rad);
            System.out.println(sine[i]);
        }
        
        System.out.println();
        
        double[] brokenSine = new double[73];
        
        
        //Task 4.-------------------------------------------------------------------------------------
        for(int i=0; i<73; i++){
            brokenSine[i] = sine[i];
        }
        
        brokenSine[2]=10;
        brokenSine[5]=-15;
        brokenSine[20]=5;
        
        for(int i=0; i<73; i++){
            System.out.println(brokenSine[i]);
        }
        
        System.out.println();
        //Task 5.a)-------------------------------------------------------------------------------------
        double sum = 0;
        double avg = 0;
        double sdElement = 0;
        double standardD = 0;
        
        for(int i=0; i<73; i++){
            sum = sum + sine[i];
        }
        
        avg = sum/73;
        
        for(int i=0; i<73; i++){
            sdElement = sdElement + Math.pow((sine[i]-avg),2)/72;
        }
        System.out.println("The sdElement is "+sdElement);
        
        standardD = Math.sqrt(sdElement);
        System.out.println("The standard deviation is "+standardD);
        
        for(int i=0; i<73; i++){
            if ((brokenSine[i]>(standardD*3)||brokenSine[i]<(standardD*(-15)))){
                System.out.println("There is an outlier at y= "+(brokenSine[i]));
            }
        }
        System.out.println();
        //Task 5.b)------------------------(ATTEMPT 1)
        
        for(int i=0; i<73; i++){
            sum = 0;
            avg = 0;
            sdElement = 0;
            standardD = 0;
            if(i<3){
                sum = brokenSine[i] + brokenSine[i+1] + brokenSine[i+2] + brokenSine[i+3] + brokenSine[i+4];
                avg = sum/5;
                for(i=0; i<=2; i++){
                    sdElement = sdElement + Math.pow((brokenSine[i]-avg),2)/4;
                }
            }
            else if(i>70){
                sum = brokenSine[i-4] + brokenSine[i-3] + brokenSine[i-2] + brokenSine[i-1] + brokenSine[i];
                avg = sum/5;
                for(i=i-2; i<72; i++){
                    sdElement = sdElement + Math.pow((brokenSine[i]-avg),2)/4;
                }
            }
            else{
                sum = brokenSine[i-2] + brokenSine[i-1] + brokenSine[i] + brokenSine[i+1] + brokenSine[i+2];
                avg = sum/5;
                sdElement = (Math.pow((brokenSine[i-2]-avg),2)+Math.pow((brokenSine[i-1]-avg),2)+Math.pow((brokenSine[i]-avg),2)+Math.pow((brokenSine[i+1]-avg),2)+Math.pow((brokenSine[i+2]-avg),2))/4;
            }
            standardD = Math.sqrt(sdElement);
       
            if ((brokenSine[i]>(standardD*3)||brokenSine[i]<(standardD*-3))){
                System.out.println("There is an outlier at y= "+(brokenSine[i]));
            }
        }
        
        System.out.println();
        //Task 5.b)------------------------(ATTEMPT 2)
        for(int i=0; i<73; i++){
            if(i>0&&i<72){
                if (brokenSine[i-1]-brokenSine[i]>2||brokenSine[i-1]-brokenSine[i]<-2||brokenSine[i]-brokenSine[i+1]>2||brokenSine[i]-brokenSine[i+1]<-2){
                    System.out.println("There is an outlier at y= "+(brokenSine[i]));
                }
            }
        }
    }
}
