import java.util.Scanner;
import java.util.Random;
public class XOXgame.java {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        char[][] table = {
            {' ',' ',' '},
            {' ',' ',' '},
            {' ',' ',' '}
            };
        // user and computer choice
        char user = 'O';
        char computer = 'X';
        boolean isRunning = true;
        boolean askAgain = false;
        
        do{
            for(int i = 0; i<table.length; i++){
                System.out.println("- - - - - - - -");
                for(int j = 0; j< table.length; j++){
                    System.out.print("| ");
                    System.out.print(table[i][j]);
                    System.out.print(" |");
                }
                System.out.println();
            }
            boolean userChoice = true;
            boolean computerChoice = true;
            
            while(userChoice){
                System.out.print("Enter the column number: (1-3) ");
                int columnUser = scan.nextInt();
                System.out.print("Enter the row number: (1-3) ");
                int rowUser = scan.nextInt();
                if(table[columnUser-1][rowUser-1] != 'X' && table[columnUser-1][rowUser-1] != 'O'){
                    table[columnUser-1][rowUser-1] = 'O';
                    userChoice = false;
                }
                else
                    System.out.println("This cell is already occupied, choose another one!");
                
            }
            
            if(((table[0][0] == table[0][1]) && (table[0][1] == table[0][2])) && table[0][0] != ' '){
                
                if(table[0][0] == user){
                    System.out.println("You won");
                    askAgain = true;
                    computerChoice = false;
                    isRunning = false;
                }
                else{
                    System.out.println("Computer won");
                    askAgain = true;
                    computerChoice = false; 
                    isRunning = false;
                }
            }
            else if(((table[1][0] == table[1][1]) && (table[1][1] == table[1][2]) && table[1][0] != ' ')){
                if(table[1][0] == user){
                    System.out.println("You won");
                    askAgain = true;
                    computerChoice = false;
                    isRunning = false;
                }
                else{
                    System.out.println("Computer won");
                    askAgain = true;
                    computerChoice = false; 
                    isRunning = false;
                }
            }
            else if(((table[2][0] == table[2][1]) && (table[2][1] == table[2][2]) && table[2][0] != ' ')){
                if(table[2][0] == user){
                    System.out.println("You won");
                    askAgain = true;
                    computerChoice = false;
                    isRunning = false;
                }
                else{
                    System.out.println("Computer won");
                    askAgain = true;
                    computerChoice = false; 
                    isRunning = false;
                }
            }
            else if(((table[0][0] == table[1][0]) && (table[1][0] == table[2][0]) && table[0][0] != ' ')){
                if(table[0][0] == user){
                    System.out.println("You won");
                    askAgain = true;
                    computerChoice = false;
                    isRunning = false;
                }
                else{
                    System.out.println("Computer won");
                    askAgain = true;
                    computerChoice = false; 
                    isRunning = false;
                }
            }
            else if(((table[0][1] == table[1][1]) && (table[1][1] == table[2][1]) && table[0][1] != ' ')){
                if(table[0][1] == user){
                    System.out.println("You won");
                    askAgain = true;
                    computerChoice = false;
                    isRunning = false;
                }
                else{
                    System.out.println("Computer won");
                    askAgain = true;
                    computerChoice = false; 
                    isRunning = false;
                }
            }
            else if(((table[0][2] == table[1][2]) && (table[1][2] == table[2][2]) && table[0][2] != ' ')){
                if(table[0][2] == user){
                    System.out.println("You won");
                    askAgain = true;
                    computerChoice = false;
                    isRunning = false;
                }
                else{
                    System.out.println("Computer won");
                    askAgain = true;
                    computerChoice = false; 
                    isRunning = false;
                }
            }
            else if(((table[0][0] == table[1][1]) && (table[1][1] == table[2][2]) && table[0][0] != ' ')){
                if(table[0][0] == user){
                    System.out.println("You won");
                    askAgain = true;
                    computerChoice = false;
                    isRunning = false;
                }
                else{
                    System.out.println("Computer won");
                    askAgain = true;
                    computerChoice = false; 
                    isRunning = false;
                }
            }
            else if(((table[0][2] == table[1][1]) && (table[1][1] == table[2][0]) && table[0][2] != ' ')){
                if(table[0][2] == user){
                    System.out.println("You won");
                    askAgain = true;
                    computerChoice = false;
                    isRunning = false;
                }
                else{
                    System.out.println("Computer won");
                    askAgain = true;
                    computerChoice = false; 
                    isRunning = false;
                }
            }
            else
                System.out.println();
            
            while(computerChoice){
                int computerColumn = rand.nextInt(0,2);
                int computerRow = rand.nextInt(0,2);
                
                if(table[computerColumn][computerRow] != 'O' && table[computerColumn][computerRow] != 'X'){
                    table[computerColumn][computerRow] = 'X';
                    computerChoice = false;
                }
                
                
            }
            if(askAgain == false){
                if(((table[0][0] == table[0][1]) && (table[0][1] == table[0][2]) && table[0][0] != ' ')){

                    if(table[0][0] == computer){
                        System.out.println("Computer won");
                        askAgain = true;
                        computerChoice = false;
                        isRunning = false;
                    }
                    else{
                        System.out.println("You won");
                        askAgain = true;
                        computerChoice = false; 
                        isRunning = false;
                    }
                }
                else if(((table[1][0] == table[1][1]) && (table[1][1] == table[1][2]) && table[1][0] != ' ')){
                    if(table[1][0] == computer){
                        System.out.println("Computer won");
                        askAgain = true;
                        computerChoice = false;
                        isRunning = false;
                    }
                    else{
                        System.out.println("You won");
                        askAgain = true;
                        computerChoice = false; 
                        isRunning = false;
                    }
                }
                else if(((table[2][0] == table[2][1]) && (table[2][1] == table[2][2]) && table[2][0] != ' ')){
                    if(table[2][0] == computer){
                        System.out.println("Computer won");
                        askAgain = true;
                        computerChoice = false;
                        isRunning = false;
                    }
                    else{
                        System.out.println("You won");
                        askAgain = true;
                        computerChoice = false; 
                        isRunning = false;
                    }
                }
                else if(((table[0][0] == table[1][0]) && (table[1][0] == table[2][0]) && table[0][0] != ' ')){
                    if(table[0][0] == computer){
                        System.out.println("Computer won");
                        askAgain = true;
                        computerChoice = false;
                        isRunning = false;
                    }
                    else{
                        System.out.println("You won");
                        askAgain = true;
                        computerChoice = false; 
                        isRunning = false;
                    }
                }
                else if(((table[0][1] == table[1][1]) && (table[1][1] == table[2][1]) && table[0][1] != ' ')){
                    if(table[0][1] == computer){
                        System.out.println("Computer won");
                        askAgain = true;
                        computerChoice = false;
                        isRunning = false;
                    }
                    else{
                        System.out.println("You won");
                        askAgain = true;
                        computerChoice = false; 
                        isRunning = false;
                    }
                }
                else if(((table[0][2] == table[1][2]) && (table[1][2] == table[2][2]) && table[0][2] != ' ')){
                    if(table[0][2] == computer){
                        System.out.println("Computer won");
                        askAgain = true;
                        computerChoice = false;
                        isRunning = false;
                    }
                    else{
                        System.out.println("You won");
                        askAgain = true;
                        computerChoice = false; 
                        isRunning = false;
                    }
                }
                else if(((table[0][0] == table[1][1]) && (table[1][1] == table[2][2])) && table[0][0] != ' '){
                    if(table[0][0] == computer){
                        System.out.println("Computer won");
                        askAgain = true;
                        computerChoice = false;
                        isRunning = false;
                    }
                    else{
                        System.out.println("You won");
                        askAgain = true;
                        computerChoice = false; 
                        isRunning = false;
                    }
                }
                else if(((table[0][2] == table[1][1]) && (table[1][1] == table[2][0]) && table[0][2] != ' ')){
                    if(table[0][2] == computer){
                        System.out.println("Computer won");
                        askAgain = true;
                        computerChoice = false;
                        isRunning = false;
                    }
                    else{
                        System.out.println("You won");
                        askAgain = true;
                        computerChoice = false; 
                        isRunning = false;
                    }
                }
            }
            
            if(askAgain == true){
                String playAgain = "";
                do{
                    System.out.println("Would you like to play again (Y/y for yes || N/n for no)");
                    playAgain = scan.next();
                    if(playAgain.toLowerCase().equals("y")){
                        isRunning = true;
                    }
                    else if(playAgain.toLowerCase().equals("n")){
                        System.out.println("Thank you for Playing, Byeee!!");
                    }
                    else{
                        System.out.println("Pay attention to instruction and enter valid input");
                    }
                }while(playAgain.toLowerCase().equals("y") || playAgain.toLowerCase().equals("y"));
            }
        }while(isRunning);
    }
}