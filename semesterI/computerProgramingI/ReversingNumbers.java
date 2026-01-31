import java.util.Scanner;
public class ReversingNumbers {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a number: ");
        int number = scan.nextInt();
        int sign = 1;
        if(number<0){
            sign = -1;
            number = -number;
        }
        int result= 0;
        while(number!=0){
            int digit = number%10;
            result = result*10 + digit;
            number/=10;
        }
        result*=sign;
        System.out.println("result: "+ result);
    }
}
