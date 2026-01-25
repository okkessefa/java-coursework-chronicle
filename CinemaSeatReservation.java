
import java.util.Scanner;

public class NewClass9 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] seats = new int[5][6]; // 5 rows (A-E), 6 columns (1-6)
        char[] label = {'A','B','C','D','E'};
        boolean running = true;
        int price = 0;
        do {
            // 1. Print Layout using Nested Loops
            System.out.println("  6  5  4  3  2  1"); // Column headers
            for (int i = seats.length-1; i>=0; i--) {
                System.out.print(label[i] + " "); // Row labels A, B, C...
                for (int j = seats[0].length-1; j>=0; j--) {
                    if(seats[i][j] == 0){
                        System.out.print("O  ");
                    }
                    else{
                        System.out.print("X  ");
                    }
                }
                System.out.println();
            }

            // 2. Get User Input
            System.out.print("\nEnter seat code : ");
            String row  = scan.next().toUpperCase().trim();
            System.out.print("Enter column number: ");
            int column = scan.nextInt();
            String labels = "ABCDE";
            if (labels.contains(row) == false || row.length() != 1 || column < 1 || column > 6) {
                System.out.println("Seat out of bounds!");
                continue;
            }
            else{
                if (seats[labels.indexOf(row)][column-1] == 1) {
                    System.out.println("Seat already occupied!");
                } else {
                    seats[labels.indexOf(row)][column-1] = 1;
                    if(labels.indexOf(row)<2){
                        price+=120;
                    }
                    else{
                        price+=70;
                    }
                    System.out.println("Seat booked successfully!");
                }
            }
            do{
                System.out.print("Want to book again: ");
                char choice = scan.next().trim().toUpperCase().charAt(0);
                if(choice == 'Y'){
                    break;
                }
                else if(choice == 'N'){
                    System.out.println("Bye...");
                    running = false;
                    break;
                }
                else{
                    System.out.println("Enter valid input!");
                }
            }while(true);
        }while (running);
        System.out.println("Total price => "+ price);
        System.out.println("Booked seats: ");
        for(int i =0; i<seats.length; i++){
            for(int j=0; j<seats[0].length; j++){
                if(seats[i][j] == 1){
                    System.out.print(label[i]);
                    System.out.print(j + " / ");
                }
            }
        }
    }
}
