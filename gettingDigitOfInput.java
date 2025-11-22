
import java.util.Scanner;
public class CalculateSumOfDigitsOfNumber {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int input = scan.nextInt();
        if(input<=9999 && input<0){
            int digit1 = input%10%10%10;
            input/=10;
            int digit2 = input%10%10;
            input/=10;
            int digit3 = input%10;
            input/=10;
            int digit4 = input%10;
            int result = digit1 + digit2 +digit3 +digit4; 
            System.out.println("Sum of digits of number: " + result);
        }
        else{
            System.out.println("Enter valid number");
        }
        scan.close();
    }
}