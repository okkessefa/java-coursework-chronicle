import java.util.Scanner;
public class IsPrimeNumber{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int a = scan.nextInt();
        // For checing any number is prime or not 
        // here is my method for this program, in the beginning of the program assume that 
        // user entered a prime number and if we chatch any exception that is not stisfiying being prime number 
        // proporties change the variable as Not Prime
        String isPrime = "Prime";
        
        if (a < 2) isPrime = "NotPrime";           // 0, 1 and negatives are not prime
        if (a == 2) isPrime = "NotPrime";           // 2 is the smallest prime
        if (a % 2 == 0) isPrime = "NotPrime";   // eliminate even numbers > 2

        int limit = a/2+1;
        // A integer value can not divided by a value that greather than its half plus one
        for (int i = 3; i <= limit; i += 2) {
            // increment part is increaing by 2 each step 
            // as we eliminate the even value before
            if (a % i == 0) {
                // For example user insert those values:
                // the loop is not starting since the initialized value is 3 and condition is not satisfied
                // inserted value ------- condition   ----- result 
                //      3                   3<=2            loop did not work     
                //      5                   3<=3            loop did  work            
                //      7                   3<=4            loop did  work            
                isPrime = "NotPrime";
            }
        }
        System.out.println(a + " " + isPrime);
    }
}