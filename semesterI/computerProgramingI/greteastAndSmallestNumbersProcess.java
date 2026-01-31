import java.util.Scanner;
public class greteastAndSmallestNumbersProcess{
    // MAin purpose is finding greteast and smallest value among 4 for this example
    public static void main(String[] args) {
        var input = new Scanner(System.in);
        
        // Requesting the values from user
        System.out.print("Enter the first number: ");
        double n1 = input.nextDouble();
        
        System.out.print("Enter the second number: ");
        double n2 = input.nextDouble();
        
        System.out.print("Enter the third number: ");
        double n3 = input.nextDouble();
        
        System.out.print("Enter the fourth number: ");
        double n4 = input.nextDouble();
        
        // Find the maximum and minimum with a way that most efficient without any build in or extra function
        // main idea is assuming any value as max or min value and compearing with it remainds  
        double max = n1;
        if (n2 > max) max = n2;
        if (n3 > max) max = n3;
        if (n4 > max) max = n4;
        
        double min = n1;
        if (n2 < min) min = n2;
        if (n3 < min) min = n3;
        if (n4 < min) min = n4;
        
        // the most ranged interval will lie between max and min value
        double difference = max - min;
        
        System.out.println("The largest number is: " + max);
        System.out.println("The smallest number is: " + min);
        System.out.println("The difference between them is: " + difference);
        
        input.close();
    }    
}