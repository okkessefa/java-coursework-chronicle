
import java.util.Scanner;
import java.util.Random;
public class amiralSunk {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        Random rand = new Random();

        //hidden map
        int[][] hidden = new int[5][5];
        // visual map
        char[][] visual = new char[5][5];

        boolean playAgain = false;
        
        do{
            // placing the ships randomly
            for(int i =0; i<5; i++){
                int row = rand.nextInt(5);
                int column = rand.nextInt(5);
                hidden[row][column] = 1;
            }
            for(int i =0; i<visual.length; i++){
                for(int j=0; j<visual[0].length; j++){
                    visual[i][j] = '-';
                }
            }
            int totalAttemp = 0;
            int sinkedShip = 0;
            System.out.println("**********Welcome to Amiral Sunk Game**********");
            
            // game is running here
            do{
                for(int i =0; i<visual.length; i++){
                    for(int j=0; j<visual[0].length; j++){
                        System.out.print(visual[i][j]+" ");
                    }
                    System.out.println();
                }
                boolean shot = false;
                do{
                    System.out.print("Enter a row number (1-5): ");
                    int userRow = scan.nextInt();
                    System.out.print("Enter a column number (1-5): ");
                    int userColumn = scan.nextInt();
                    if((userColumn>0 && userColumn<=5) && (userRow>0 && userRow<=5)){
                        if(hidden[userRow-1][userColumn-1] == 1){
                            System.out.println("One ship shunked, Good Shot 👌");
                            visual[userRow-1][userColumn-1] = 'X';
                            sinkedShip++;
                            
                        }
                        else{
                            System.out.println("Nice Attempts, Try again 😊 ");
                            visual[userRow-1][userColumn-1] = '*';
                        }
                        totalAttemp++;
                        System.out.println("You have credits " + (15 - totalAttemp+1) + " hurry up before it is running out!");
                        shot = true;
                    }
                    else{
                        System.out.println("Please enter a valid row and column number 😉");
                    }
                    
                }while(shot == false);
                
            }while(totalAttemp<16 && sinkedShip<=5);
            
            char userInput;
            do{
                System.out.println("Would you like to play again? (y for Yes / n for No)");
                String choice = scan.next().toLowerCase();
                userInput = choice.charAt(0);
                if(userInput == 'y'){
                    playAgain = true;
                }
                else{
                    System.out.println("Thank you for playing 🤗");
                }
            }while( userInput != 'y' && userInput != 'n');
        }while(playAgain);
    }
}