public class GCDandLCM {
    public static void main(String[] args){
        // Two arbitrary values
        int a = 36;
        int b = 24;
        // copying the real values to Shoeing what change at the end of the code 
        int tempA = a;
        int tempB = b;
        int GCD = 1;
        int LCM = 1;
        // the increment part of the for removed and added into the else block 
        // so that denumerator ıncreases only two values divided same vales simultaneously
        for(int i = 2;i<= Math.max(a,b);){
            // GCD increase if only if two input values divided same time
            if(a%i == 0 && b%i==0){
                LCM*=i; 
                GCD*=i; 
                a/=i;
                b/=i;
            }
            // LCM increment depends on whether any value is divisible by the denominator
            else if(a%i == 0 && b%i !=0){
                LCM*=i; 
                a/=i;
            }
            //LCM increment depends on whether any value is divisible by the denominator
            else if(a%i != 0 && b%i ==0){
                LCM*=i; 
                b/=i;
            }else{
                i++;
            }
        } 
        System.out.println("LCM: "+LCM + "-|" + tempA + " " + tempB);
        System.out.println("GCD: "+GCD + "-|" + tempA + " " + tempB);
    }
}