
import java.util.Scanner;
import java.util.Random;
public class TreasureHuntGame {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        
        boolean isRunning = true;
        // outher game body
        do{
            int userPoint = 0;
            // initalizing the maps
            char[][] hiddenMap = new char[5][5];
            char[][] visualMap = new char[5][5];
            

            // creating visual map for user
            for(int i=0;i<visualMap.length; i++){
                for(int j =0; j<visualMap[0].length; j++){
                    visualMap[i][j] = '?';
                }
            }
            // placing trap or treasure randomly
            for(int i=0;i<visualMap.length; i++){
                for(int j =0; j<visualMap[0].length; j++){
                    hiddenMap[i][j] = '.';
                }
            }
            for(int i=0;i<3;){
                int row = rand.nextInt(5);
                int column = rand.nextInt(5);
                if(hiddenMap[row][column] == '.'){
                    hiddenMap[row][column] = 'H';
                    i++;
                }
            }
            int Trow;
            int Tcolumn;
            do{
                Trow = rand.nextInt(5);
                Tcolumn = rand.nextInt(5);
            }while(hiddenMap[Trow][Tcolumn] != '.');
            hiddenMap[Trow][Tcolumn] = 'T';
            
            System.out.println("Welcome the treasure Hunt Game");
            boolean isPlaying = true;
            do{
                System.out.println("You found " + userPoint + " treasure");
                
                System.out.println();
                System.out.print("\\ ");
                for(int i =0;i<visualMap.length; i++){
                    System.out.print(i+1+ " ");
                }
                System.out.println();
                // print map in reverse way
                for(int i=0;i<visualMap.length; i++){
                    System.out.print(i+1 + " ");
                    for(int j =0; j<visualMap[0].length; j++){
                        System.out.print(visualMap[i][j]+" ");
                    }
                    System.out.println();
                }
                
                int userRow = 0, userColumn = 0;
                
                while(true){
                    System.out.print("Enter row number (1-5): ");
                    userRow = scan.nextInt();
                    System.out.print("Enter column number (1-5): ");
                    userColumn = scan.nextInt();
                    if((userRow > 0 && userRow<6) && (userColumn>0 && userColumn<6)){
                        break;
                    }
                    else{
                        System.out.println("Please enter a value in the intervals");
                    }
                }
                userRow--;
                userColumn--;
                if(hiddenMap[userRow][userColumn] == 'H'){
                    visualMap[userRow][userColumn] = 'H';
                    userPoint++;
                }
                else if(hiddenMap[userRow][userColumn] == 'T'){
                    System.out.println("You felt into the trap");
                    isPlaying = false;
                }
                else{
                    System.out.println("There is no neither treasure or trap");
                    visualMap[userRow][userColumn] = '*';
                }
            }while(isPlaying && userPoint!=3);

            char playAgain;
            do{
                System.out.print("Would you like to play again? (Y for yes / N for no):"); 
                playAgain = scan.next().toUpperCase().trim().charAt(0);
                if(playAgain == 'Y'){
                    System.out.println("New Game is loading...");
                }
                else if(playAgain == 'N'){
                    System.out.println("Thank you for playing, Byeee..");
                    isRunning = false;
                }
                else{
                    System.out.println("Enter a valid input");
                }
            }while(playAgain !='N' && playAgain !='Y');
        }while(isRunning);
    }
}