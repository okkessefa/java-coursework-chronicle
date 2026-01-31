import java.util.Scanner;
public class ticketDiscountPtogram{
        public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        //Getting age and being student status informations from user 
        System.out.print("Enter your age: ");
        int age = scan.nextInt();
        System.out.print("Are you student: (true/false)");
        boolean IsStudent = scan.nextBoolean();
        //There are many methods to carry out this control process.
        // In this scenario, we created control blocks that 
        // depending on whether the user is a student or not, the price depends on this status value.if(IsStudent){
        if(IsStudent){
            if(age>=0 && age<=12) System.out.println("Ticket price is 5TL");
            else if(age>=13 && age<=17) System.out.println("Ticket price is 8 TL");
            else if(age>=18 && age<=64) System.out.println("Ticket price is 12 TL");
            else System.out.println("No student discount avaliable Your ticket price is 6 TL");
        }else{
            if(age>=0 && age<=12) System.out.println("Ticket price is 7 TL");
            else if(age>=13 && age<=17) System.out.println("Ticket price is 10 TL");
            else if(age>=18 && age<=64) System.out.println("Ticket price is  15 TL");
            else System.out.println("Ticket price is 6 TL");
        }
        scan.close(); 
    }
}