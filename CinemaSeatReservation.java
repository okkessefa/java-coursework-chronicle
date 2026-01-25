
import java.util.Scanner;

public class CinemaSeatReservation {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[][] hallHidden = new int[5][7];
        char[][] hallVisual = new char[5][7];
        char[] rowLabel = {'A','B','C','D','E'};
        
        for(int i = 0; i<hallVisual.length; i++){
            for(int j= 0; j<hallVisual[0].length; j++){
                hallVisual[i][j] = '0';
            }
         }
        int userRow =-1;
        int userColumn = -1;
        int price = 0;
        boolean isRunning = true;
        do{
            System.out.println();
            System.out.print("\\ ");
            for(int i =0; i<hallVisual[0].length; i++){
                System.out.print(hallVisual[0].length-i + " ");
            }
            System.out.println();
            for(int i = hallVisual.length-1; i>=0; i--){
                
                System.out.print(rowLabel[i]+" ");
                for(int j= hallVisual[0].length-1; j>=0; j--){
                    System.out.print(hallVisual[i][j] + " ");
                }
                System.out.println();
            }
            System.out.println();
            System.out.print("Enter a row number (For quiting Enter -1): ");
            userRow = scan.nextInt();
            System.out.print("Enter a row number (For quiting Enter -1): ");
            userColumn = scan.nextInt();
            
            if(userRow == -1 && userColumn == -1) {
                isRunning = false;
                break;
            } 
            if (userRow < 1 || userRow > 4 || userColumn < 1 || userColumn > 4) {
                System.out.println("Please enter a valid seat number!");
                continue;
            }
            if(hallHidden[userRow-1][userColumn-1] == 1){
                System.out.println("This seat is booked, Choose another one ");
                continue;
            }
            switch(userRow){
                case 1, 2 -> {
                    price+=100;
                    hallHidden[userRow-1][userColumn-1] = 1;
                    hallVisual[userRow-1][userColumn-1] = 'X';
                }
                case 3, 4 ->  { 
                    price+=50;
                    hallHidden[userRow-1][userColumn-1] = 1;
                    hallVisual[userRow-1][userColumn-1] = 'X';
                }
                default -> {
                    System.out.println("Please enter a valid seat number!");
                    continue;
                }    
            }
        }while(isRunning);
        
        if(price>0){
            System.out.println("Total Price is :" + price);
            System.out.println("Booked Seat(s): ");
            for(int i = 0; i<hallVisual.length; i++){
                for(int j= 0; j<hallVisual[0].length; j++){
                    if(hallHidden[i][j] == 1){
                        System.out.print(rowLabel[i] + " " +j + " / ");
                    }
                }
            }
        }
    }
}
