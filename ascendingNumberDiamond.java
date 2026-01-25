import java.util.Scanner;
public class ascendingNumberDiamond {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int x = scan.nextInt();
        int mid = x/2;
        
        for(int i = 0; i<=mid;i++){
            // space count
            for(int j = 0; j<mid-i; j++){
                System.out.print(" ");
            }
            
            // 1 to r 
            for(int k = 1; k<=i+1; k++){
                System.out.print(k);
            }
            // r-1 to 1
            for(int k = i ;k>0 ; k--){
                System.out.print(k);
            }
            System.out.println();
        }
 
        for(int i = mid-1; i>=0;i--){
            // space count
            for(int j = 0; j<mid-i; j++){
                System.out.print(" ");
            }
            
            for(int k = 1; k<=i+1; k++){
                System.out.print(k);
            }
            for(int k = i ;k>0 ; k--){
                System.out.print(k);
            }
            
            System.out.println();
        }
    }
    
}