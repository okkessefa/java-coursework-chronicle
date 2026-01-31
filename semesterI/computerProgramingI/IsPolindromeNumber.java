import java.util.Scanner;

public class JavaApplication8 {

    public static void main(String[] args) {
        // Cheching a number is whether a polindrome number or not  
        Scanner scan = new Scanner(System.in);

        // Getting user input
        System.out.println("Enter a number: ");
        int number = scan.nextInt();

        // declearing essential variable in 3 steps
        // 1-> Copying number as string to traverse it from end to begin
        String copyNumber = number + "";
        // 2-> Creating a empty string to adding reversed version of input
        String polindrome = "";
        // 3-> assinging a pointer to determine a char at index
        int index = copyNumber.length() - 1;

        while (index >= 0) {
            // Appliying 2nd and 3rd steps
            polindrome += (copyNumber.charAt(index--));
        }

        // At the end compearing original version with reversed version 
        if (number == Integer.parseInt(polindrome)) {
            System.out.println(number + " is a polindrome number");
        } else {
            System.out.println(number + " is not a polindrome number");
        }
    }
}
