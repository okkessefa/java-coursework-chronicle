
import java.util.Scanner;
public class gettingDigitOfInput{
    public static void main(String[] args){
        // declearing a scanner object to use in the program
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        // assigning the input into a value 
        int input = scan.nextInt();
        // chexing the inout whether it is approaching our interval
        if(input<=9999 && input<0){
            //the ones place of a number
            int digit1 = input%10%10%10;
            decrease the number by one step
            input/=10; 
            //the tens place of a number
            int digit2 = input%10%10;
            input/=10;
            //the hundreds place of a number
            int digit3 = input%10;
            input/=10;
            //the thousands place of a number
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