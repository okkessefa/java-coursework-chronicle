import java.util.Scanner;
public class butterflyShape {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int x = scan.nextInt();
        int backStep = 0;
        int mid = x/2;
        for(int i = 0; i<=mid; i++){
            for(int j=0; j<i; j++){
                System.out.print(" ");
            }
            for(int j = 0; j<=i; j++){
                System.out.print("*");
            }
            for(int j = 0; j<2*x-1-backStep; j++){
                System.out.print(" ");
            }
            backStep+=4;
            for(int j = 0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
        int forwardStep = 5;
        for(int i = mid-1; i>=0; i--){
            for(int j = 0; j<i; j++){
                System.out.print(" ");
            }
            for(int j = 0; j<=i; j++){
                System.out.print("*");
            }
            for(int j = 0; j<forwardStep; j++){
                System.out.print(" ");
            }
            forwardStep+=4;
            for(int j = 0; j<=i; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
}