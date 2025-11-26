import java.util.Scanner;
public class menuSwitchCase{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        // Creating menu with 2 options
        System.out.println("____________________________");
        System.out.println("_____Welcome the Menu_______");
        System.out.println("____________________________");
        System.out.println("Options :                   ");
        System.out.println("1- Simple Calculator        ");
        System.out.println("2- Show Mark Equations      ");
        System.out.println("Your choice:                ");
        int choice = scan.nextInt();
        switch (choice){
            // 1st option is Simple calculator with 4 mathematical operator
            case 1:       
                System.out.println("Enter a number: ");
                double a = scan.nextDouble();
                System.out.println("Enter a number: ");
                double b= scan.nextInt();
                System.out.println("Enter an oparator: ");
                String op = scan.next();

                switch(op){
                    case "+":
                        System.out.println(a+b); break;
                    case "/":
                        // Always check the zero divison error exception and print the  result of the calculation if second value is different than 0
                        if(b == 0) System.out.println("Zero division error");
                        else System.out.println(a/b); 
                        break;
                    case "-":
                        System.out.println(a-b); break;
                    case "*":
                        System.out.println(a*b); break;
                    // If the user choice invalid operator warn the user
                    default:
                        System.out.println("Invalid oprator");
                }
                break;
            // 2nd option is calculating semester graduate mark with ordinary standarts
            case 2: 
                System.out.println("Enter midterm mark: ");
                int midterm = scan.nextInt();
                System.out.println("Enter final mark: ");
                int finalMark = scan.nextInt();
                // no matter you get the midterm and final marks as integer 
                // or any kind of value, after calculating 
                // the leastest value have to been determined as double data type as you multiplied it with fractional value 
                double totalMark = (midterm*0.4)+(finalMark*0.6);
                // Checing the anopraptiate value makes your program less complex 
                // and more understandable
                if(totalMark<0 || totalMark > 100) System.out.println("Invalid mark result");
                else{
                    if(totalMark <=100 && totalMark>90) System.out.println("AA");
                    else if(totalMark <=90 && totalMark>80) System.out.println("AB");
                    else if(totalMark <=80 && totalMark>70) System.out.println("BB");
                    else if(totalMark <=70 && totalMark>60) System.out.println("BC");
                    else if(totalMark <=60 && totalMark>50) System.out.println("CC");
                    else if(totalMark <=50 && totalMark>40) System.out.println("DC");
                    else System.out.println("FF");
                }
                break;
                
            default:
                System.out.println("Invalid Choice"); break;
        }
    }
}