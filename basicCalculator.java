
import java.util.Scanner;
public class PrimeNumber {

    public static void main(String[] args) {
        // devlearing a scanner object
        Scanner scan = new Scanner(System.in);
        
        double number1;
        double number2;
        String operator;
        

        // GEtting and assigning input into values
        System.out.print("Enter a number: ");
        number1 = scan.nextInt();
        System.out.print("Enter a operator: ");
        operator = scan.next();
        System.out.print("Enter a number: ");
        number2 = scan.nextInt();
        
        // checking conditions with switch case structure
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
            // division has special case its inside, you can not divide any value with 0
            case "/":
                // if 2nd  value is 0 , process is not worked
                if(number2 == 0) {
                    System.out.println("You can not divide any number to zero");
                }
                // else process maintains
                else {
                    System.out.println("Result ->" + (number1/ number2));
                }
                break;
            // for any unacceptable input warn the user    
            default:
                System.out.println("Invalid oprator choice");
        }
        scan.close();        
    }
    
}
