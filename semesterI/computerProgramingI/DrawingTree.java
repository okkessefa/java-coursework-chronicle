import java.util.Scanner;
public class DrawingTree {
    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter a length: ");
        // getting length of tree from user
        int length = scan.nextInt();
        // holding space count in another variable
        int space = length-1;
        
        
        for(int i = 0;i<length;i++){
            // space before each line draft
            for(int j = 0;j<space;j++){
                System.out.print(" ");
            }
            space--; // space count decrease in each line
            
            System.out.print("*"); // after each space printing process it start with *
            // after 1st line the - count corresponding with this rule 2xi-1
            for(int j = 0;j<i*2-1;j++){
                System.out.print("-");
            }
            // if i is greather than 0 add * as we already add - with determined rule above
            if(i>0){
                System.out.print("*");
            }
            System.out.println();
        }
        // additional step that adding long of tree 
        // there is no specific rule to adding or keeping length of longs of tree
        for(int i = 0;i<length-1;i++){
            for(int j = 0;j<length/2+1;j++){
                System.out.print(" ");
            }
            System.out.print("| |");
            System.out.println();
        }
    }
    
}