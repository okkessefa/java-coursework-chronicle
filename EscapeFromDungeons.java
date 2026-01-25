import java.util.Scanner;
import java.util.Random;
public class EscapeFromDungeons {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();
        
        boolean isRunning = true;
        
        do{
            // Crating visual map
            char[][] map = new char[10][10];
            for(int i = 0; i<map.length; i++){
                for(int j =0; j<map[0].length; j++){
                    map[i][j] = '.';
                }
            }
            // placing walls randomly ,exit and player
            int playerRow;
            int playerColumn;
            int ExitRow;
            int ExitColumn;
            
            for(int i =0; i<25;i++){
                int row = rand.nextInt(10);
                int column = rand.nextInt(10);
                map[row][column] = '#';
            } 
            
            do{
                ExitRow = rand.nextInt(10);
                ExitColumn = rand.nextInt(10);
                
            }while(map[ExitRow][ExitColumn]!='.');
            map[ExitRow][ExitColumn] = 'E';
            
            do{
                playerRow = rand.nextInt(10);
                playerColumn = rand.nextInt(10);
            }while(map[playerRow][playerColumn]!='.');
            map[playerRow][playerColumn] = 'P';
            
            

            
            boolean isPlaying  = true;
            System.out.println("Welcome to Dungeon Escape Game");
            do{
                for(int i = 0; i<map.length; i++){
                    for(int j =0; j<map[0].length; j++){
                        System.out.print(map[i][j] + " ");
                    }
                    System.out.println();
                }
                System.out.println("Enter W for move up\nEnter A for move left\nEnter S for move down\nEnter D for move right\n");
                System.out.print("Enter you moveing direction: ");
                char Userdirection = scan.nextLine().toUpperCase().trim().charAt(0);
                
                if(Userdirection == 'W'){
                    if(playerRow-1<0  || map[playerRow-1][playerColumn] == '#'){
                        System.out.println("Invalid attemps");
                    }
                    else{
                        map[playerRow][playerColumn] = '.';
                        map[playerRow-1][playerColumn] = 'P';
                        playerRow--;
                    }
                }
                else if(Userdirection == 'A'){
                    if(playerColumn-1<0 || map[playerRow][playerColumn-1] == '#'){
                        System.out.println("Invalid attemps");
                    }
                    else{
                        map[playerRow][playerColumn] = '.';
                        map[playerRow][playerColumn-1] = 'P';
                        playerColumn--;
                    }
                }
                else if(Userdirection == 'S'){
                    if(playerRow+1>=map.length || map[playerRow+1][playerColumn] == '#'){
                        System.out.println("Invalid attemps");
                    }
                    else{
                        map[playerRow][playerColumn] = '.';
                        map[playerRow+1][playerColumn] = 'P';
                        playerRow++;
                    }
                }
                else if(Userdirection == 'D'){
                    if(playerColumn+1>=map.length|| map[playerRow][playerColumn+1] == '#'){
                        System.out.println("Invalid attemps");
                    }
                    else{
                        map[playerRow][playerColumn] = '.';
                        map[playerRow][playerColumn+1] = 'P';
                        playerColumn++;
                    }
                }
                else System.out.println("Invalid Input Try again");
                    
                if(playerRow == ExitRow && playerColumn == ExitColumn){
                    System.out.println("You escaped from the dungeon");
                    isPlaying = false;
                }

            }while(isPlaying);
            
            do{
                System.out.print("Would you like to play again: (Y for yes / N for no)");
                char UserChoice = scan.nextLine().toUpperCase().charAt(0);
                if(UserChoice == 'Y'){
                    System.out.println("New Game is starting...");
                    break;
                }
                else if(UserChoice == 'N'){
                    System.out.println("Thank you for playing byee...");
                    isRunning = false;
                    break;
                }
                else{
                    System.out.println("Invalid Input, pay Attention to instrutiors");
                }
            }while(true);
            
        }while(isRunning);
    }
}