import java.util.Scanner;
public class dayOfWeekSwitchCase {

    public static void main(String[] args) {
        // Switch case example about day of week depends on user input 
        Scanner scan = new Scanner(System.in);

        int gun = scan.nextInt();
        // declearing a day value as null as it is able to change in switch cases
        String day = null;

        // Creating a switch case body that 
        // process the gun value and determine the day value
        switch (gun){
            case 1 -> day = "Monday";
            case 2 -> day = "Tuesday";
            case 3 -> day = "Wednesday";
            case 4 -> day = "Thursday";
            case 5 -> day = "Friday";
            case 6 -> day = "Saturday";
            case 7 -> day = "Sunday";
            default -> System.out.println("Invalid Number");
        }
        // printing the value if entered day in the interval
        // if it is not process don't maintain anymore
        if(gun>0 && gun < 8){
            System.out.println("Entered day: "+ day);
        }
        scan.close();
        
    }
    
}
