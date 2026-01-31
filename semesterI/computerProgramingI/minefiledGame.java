
import java.util.Scanner;
import java.util.Random;
public class minefiledGame.java{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in); 
        Random rand = new Random();
        
        int[][] hiddenMap = new int[5][5];
        char[][] visualMap = new char[5][5];
        
        
        int totalAttemp;
        boolean expladed;
        boolean playAgain = true;
        do{
            for(int i=0; i<5; i++){
                int a = rand.nextInt(5);
                int b = rand.nextInt(5);
                hiddenMap[a][b] = 1;
            }

            for(int i =0; i<5; i++){
                for(int j=0; j<5; j++){
                    visualMap[i][j] = '-';
                }
            }    
            totalAttemp = 0;
            expladed = false;
            System.out.println("*******************MineFiled Game*******************");
            do{
                
                for(char a[] : visualMap){
                    for(char b : a){
                        System.out.print(b+" ");
                    }
                    System.out.println();
                }
                System.out.println("-----------------------------------------------------");
                
                int userRow;
                int userColumn;
                // get x,y point from user and control them whether mstched or not    
                do{
                    System.out.print("Enter a number (1-5): ");
                    userRow = scan.nextInt();
                    System.out.print("Enter a number (1-5): ");
                    userColumn = scan.nextInt();
                    if((userRow<0 || userRow>6) || (userColumn<0 || userColumn>6)){
                        System.out.println("Please enter a valid input!");
                    }
                    
                }while((userRow<0 ||userRow>6) ||(userColumn<0 || userColumn>6));
                System.out.println("-----------------------------------------------------");

                                
                if(hiddenMap[userRow-1][userColumn-1] ==1){
                    System.out.println("THe was a boomb. Ups!!");
                    expladed = true;
                    visualMap[userRow-1][userColumn-1] = 'X';
                    for(char a[] : visualMap){
                        for(char b : a){
                            System.out.print(b+" ");
                        }
                        System.out.println();
                    }
                }
                else{
                    System.out.println("That was good shot");
                    visualMap[userRow-1][userColumn-1] = '*';
                    totalAttemp++;
                }

                

                
            }while(totalAttemp<21 && expladed == false);
            
            do{
                System.out.print("Would you like to play again? (y for yes / n for No) : ");
                String userChoice = scan.next().toLowerCase();
                if(userChoice.charAt(0) == 'n'){
                    System.out.println("Thank you for playing, See you again");
                    playAgain = false;
                    break;
                }
                else if(userChoice.charAt(0) == 'y'){
                    System.out.println("New Game is loading...");
                    break;
                }
                else{
                    System.out.println("Enter a valid choice , either yes or no");
                }
            }while(true);
            
        }while(playAgain);
    }
}
