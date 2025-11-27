import java.uril.Scanner;
public class fibonacciSeries{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int fib = scan.nextInt();
        //The Fibonacci series is a sequence of 
        // numbers where each number is the sum of 
        // the two preceding ones. It starts 
        // from 0 and 1, and the sequence goes as follows: 
        // 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, and so on.
        int a = 0;
        int b = 1;
        for(int i = 3;i<=fib;i++){
            int c = a+b;
            System.out.print(c + " ");
            a = b;
            b = c;
        }
    }
}