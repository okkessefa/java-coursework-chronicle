
import java.util.Scanner;
public class PrimeNumber {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        double number1;
        double number2;
        String operator;
        
        System.out.print("Enter a number: ");
        number1 = scan.nextInt();
        System.out.print("Enter a operator: ");
        operator = scan.next();
        System.out.print("Enter a number: ");
        number2 = scan.nextInt();
        
        switch (operator){
            case "+":
                System.out.println("Result ->" + (number1 + number2));
                break;
            case "-":
                System.out.println("Result ->" + (number1 - number2));
                break;
            case "*":
                System.out.println("Result ->" + (number1 * number2));
                break;
            case "/":
                if(number2 == 0) {
                    System.out.println("You can not divide any number to zero");
                }
                else {
                    System.out.println("Result ->" + (number1/ number2));
                }
                break;
            default:
                System.out.println("Invalid oprator choice");
        }
        scan.close();        
    }
    
}
