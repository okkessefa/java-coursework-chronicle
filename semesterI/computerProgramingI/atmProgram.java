import java.util.Scanner;
public class atmProgram {
    public static void main(String[] args){
        // Declaring a global scanner objedct to use in the program
        Scanner scan= new Scanner(System.in); 
        int password = 1234;
        // an arbitrary account balance
        int account= 2000;
        // running status will be true until user deny to maintaining process
        boolean isRunning = true;
        System.out.println("enter your password :");
        int passwordU= scan.nextInt();
        // using for structure propoties that allow us to make it like while structure
        for(;isRunning;){

            // if the password matcing with determined value user may enter
            if (password == passwordU){
                // presenting the option of atm
                System.out.println("1-withdraw money\n2-deposit money\n3-show the money\n4-exit");
                // the most approachible data type for choice as options are limited and could not be greather that byte data type range 
                int choice=scan.nextByte();
                // directing the user to the relevant transaction 
                // do not forget to adding break at the end of the each case as we do not want to observe moment that all possible actions work sametime
                switch(choice){
                    // 1st choice was withdrawing money and also if the user want to execute this process balance must be seen
                    case 1: {
                        System.out.println("your balance :"+account);
                        System.out.print("enter the value for withdraw money :");
                        int withdraw =scan.nextInt();
                        // There is no way to withdraw money more than account balance
                        if (withdraw>account){
                            System.out.println("You can't enter value which is greater than balance.. ");
                        }

                        else{
                            account=account-withdraw;
                            System.out.println("reamained money :"+account);
                        }
                        break;
                    }
                    // 2nd choice was depositing money and also if the user want to execute this process balance must be seen
                    case 2 : {
                        System.out.println("your balance :"+account);
                        System.out.print("Please enter the value for deposit the money :");
                        int deposit=scan.nextInt();
                        // There is no way to deposit money that less than or equal to 0
                        if(deposit<=0){
                            System.out.println("you can't enter the number whhich less than or equal zero ");
                        }
                        else{
                            account=account+deposit;
                            System.out.println("your balance :"+ account);
                        }
                        break;
                    }
                    // 3rd choice wasoptional as allows to users to see the balance
                    case 3 :System.out.println("Your balance :"+ account); break;
                    // 4th choice was warning the user about  what will happen and changing the running status end break the for (seems like while)  loop condition 
                    case 4 : System.out.println("you are quiting..."); isRunning = false; break;
                    default : System.out.println("you can't select invalid choice.."); break;
                }
            }
            // if  password is not matched with real key , let the user what went wrong
            else{
                System.out.println("you enter wrong password so you can't doing anything in today");
            }
        }
        scan.close();
    }
}