import java.util.Scanner; 
import java.util.Random;
record Position(int row, int column){}

public class EscapeFromDungeonsV3 {
    
    // change it for player, exit and ghost 
    static Position placeVariables(char[][] map, Random random, char variable){
        int row, column;
        do{
            row = random.nextInt(map.length);
            column = random.nextInt(map[0].length);

        }while(map[row][column] != '.');
        map[row][column] = variable;
        return new Position(row, column);
    }
    // printing map 
    static void printMap(char[][] map){
        for(int i = 0; i<map.length; i++){
            for(int j =0; j<map[0].length; j++){
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }
    // getting user choice
    static String GetUserChioice(char[][] map, Scanner scan){
        
        String userChoice;
        do{
            System.out.println("Enter W for move up\nEnter A for move left\nEnter S for move down\nEnter D for move right\n");
            System.out.print("Enter you moveing direction: ");
            userChoice = scan.nextLine().toUpperCase().trim();
            if(userChoice.isEmpty()){
                System.out.println("Invalid input!");
                printMap(map);
            }
            else {
                break;
            }
        }while(true);
        return userChoice;
    }
    static int[] moveVariable(char[][] map, Random random, char variable, int row, int column){
        int DeathFlag = 0;
        // declearing array and named it as cards
        int[][] cards = {
            {0,-1}, // left
            {0, 1}, // right
            {-1,0}, // up
            {1,0}  // down
        };
        
        // shutfling the possibilies
        for(int i = cards.length-1; i>=0; i--){
            int j = random.nextInt(i+1);
            int[] temp = cards[i];
            cards[i] = cards[j];
            cards[j] = temp;
        }
        // placing ghosts to the their new places
        for(int[] d : cards){
            
            int newRow = row + d[0];
            int newColumn = column + d[1];
            char Target;
            // if values of new coordinates are greather than dundgeon length , do not validate it
            if(newRow<0 || newRow>= map.length || newColumn < 0 || newColumn >= map[0].length){
                continue;
            }
            // else confirm
            else{
                 Target = map[newRow][newColumn];
            }
            // if there is a valid move swap the ghost with empty space
            if(Target == '.'){
               map[row][column] = '.';
               map[newRow][newColumn] = variable;
               return new int[] {newRow, newColumn, DeathFlag};
            }
            // if valid movement is matching with player, mark the death  flag as 1 which means user is death
            else if (Target == 'P'){
                DeathFlag = 1;
                return new int[] {newRow, newColumn, DeathFlag};
            }
        }
        
        // if there is no valid move ghost must stay still there
        
        return new int[] {row, column, DeathFlag};
    }
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
            Position p1 = placeVariables(map, rand, 'P');
            Position e1 = placeVariables(map, rand, 'E');
            Position g1 = placeVariables(map, rand, 'G');
            Position g2 = placeVariables(map, rand, 'G');
            Position g3 = placeVariables(map, rand, 'G');
            Position g4 = placeVariables(map, rand, 'G');
            Position k1 = placeVariables(map, rand, 'K');
            
            
            int playerRow = p1.row();
            int playerColumn = p1.column();
            
            int keyRow = k1.row();
            int  keyColumn = k1.column();
            
            int ExitRow;
            int ExitColumn; 
            // pay attention for placement of variables as exit must not been placed onto the player's coordinates
            do{
                ExitRow = e1.row();
                ExitColumn = e1.column();
            }while(ExitRow == playerRow && ExitColumn == playerColumn);
            
            
            // placing ghosts
            int Ghost1Row = g1.row();
            int Ghost1Column = g1.column();
            int Ghost1Catched = 0;
            int Ghost2Row = g2.row();
            int Ghost2Column = g2.column();
            int Ghost2Catched = 0;
            int Ghost3Row = g3.row();
            int Ghost3Column = g3.column();
            int Ghost3Catched = 0;
            int Ghost4Row = g4.row();
            int Ghost4Column = g4.column();
            int Ghost4Catched = 0;
            
            int i =0;
            // pay attention for placement of variables as walls must been placed onto the empty places
            do{
                int row = rand.nextInt(10);
                int column = rand.nextInt(10);
                if(map[row][column] == '.'){   
                    map[row][column] = '#';
                    i++;
                }    
            }while(i<=25);
            
            boolean keyObtained = false;
            boolean isPlaying  = true;
            boolean userDied = false;
            System.out.println("Welcome to Dungeon Escape Game");
            do{
                printMap(map);

                char Userdirection = GetUserChioice(map, scan).charAt(0);
                
                //  user input matching with which direction up, down, left, right or nothing
                if(Userdirection == 'W'){
                    if(playerRow-1<0){
                        System.out.println("Invalid attemps");
                    }
                    else if(map[playerRow-1][playerColumn] == '#'){
                        System.out.println("Invalid attemps");
                    }
                    else if(map[playerRow-1][playerColumn] == 'G'){
                        System.out.println("You died");
                        userDied = true;
                        isPlaying = false;
                    }
                    else if(map[playerRow-1][playerColumn] == 'K'){
                        System.out.println("You got key, Now move to the Exit");
                        keyObtained = true;
                        map[playerRow][playerColumn] = '.';
                        map[playerRow-1][playerColumn] = 'P';
                        playerRow--;
                    }
                    else if(map[playerRow-1][playerColumn] == 'E'){
                        // if user want to reach exit there are two options
                        // Does user have key to open the gate
                        if((playerRow-1 == ExitRow && playerColumn == ExitColumn)){
                            // Yes user does
                            if(keyObtained){
                                System.out.println("You escaped from the dungeon");
                                isPlaying = false;
                            }
                            // No, user does not
                            else{
                                System.out.println("Before reaching gate, you have to get the key");
                            }
                        }
                    }
                    else{
                        map[playerRow][playerColumn] = '.';
                        map[playerRow-1][playerColumn] = 'P';
                        playerRow--;
                    }
                }
                        
                else if(Userdirection == 'A'){
                    if(playerColumn-1<0){
                        System.out.println("Invalid attemps");
                    }
                    else if(map[playerRow][playerColumn-1] == '#'){
                        System.out.println("Invalid attemps");
                    }
                    else if(map[playerRow][playerColumn-1] == 'G'){
                        System.out.println("You died");
                        userDied = true;
                        isPlaying = false;
                    }
                    else if(map[playerRow][playerColumn-1] == 'K'){
                        System.out.println("You got key, Now move to the Exit");
                        keyObtained = true;
                        map[playerRow][playerColumn] = '.';
                        map[playerRow][playerColumn-1] = 'P';
                        playerColumn--;
                    }
                    else if(map[playerRow][playerColumn-1] == 'E'){
                        // if user want to reach exit there are two options
                        // Does user have key to open the gate
                        if((playerRow == ExitRow && playerColumn-1 == ExitColumn)){
                            // Yes user does
                            if(keyObtained){
                                System.out.println("You escaped from the dungeon");
                                isPlaying = false;
                            }
                            // No, user does not
                            else{
                                System.out.println("Before reaching gate, you have to get the key");
                            }
                        }
                    }
                    else{
                        map[playerRow][playerColumn] = '.';
                        map[playerRow][playerColumn-1] = 'P';
                        playerColumn--;
                    }
                }
                else if(Userdirection == 'S'){
                    if(playerRow+1>=map.length){
                        System.out.println("Invalid attemps");
                    }
                    else if(map[playerRow+1][playerColumn] == '#'){
                        System.out.println("Invalid attemps");
                    }
                    else if(map[playerRow+1][playerColumn] == 'G'){
                        System.out.println("You died");
                        userDied = true;
                        isPlaying = false;
                    }
                    else if(map[playerRow+1][playerColumn] == 'K'){
                        System.out.println("You got key, Now move to the Exit");
                        keyObtained = true;
                        map[playerRow][playerColumn] = '.';
                        map[playerRow+1][playerColumn] = 'P';
                        playerRow++;
                    }
                    else if(map[playerRow+1][playerColumn] == 'E'){
                        // if user want to reach exit there are two options
                        // Does user have key to open the gate
                        if((playerRow+1 == ExitRow && playerColumn == ExitColumn)){
                            // Yes user does
                            if(keyObtained){
                                System.out.println("You escaped from the dungeon");
                                isPlaying = false;
                            }
                            // No, user does not
                            else{
                                System.out.println("Before reaching gate, you have to get the key");
                            }
                        }
                    }
                    else{
                        map[playerRow][playerColumn] = '.';
                        map[playerRow+1][playerColumn] = 'P';
                        playerRow++;
                    }
                }
                else if(Userdirection == 'D'){
                    if(playerColumn+1>=map[0].length){
                        System.out.println("Invalid attemps");
                    }
                    else if(map[playerRow][playerColumn+1] == '#'){
                        System.out.println("Invalid attemps");
                    }
                    else if(map[playerRow][playerColumn+1] == 'G'){
                        System.out.println("You died");
                        userDied = true;
                        isPlaying = false;
                    }
                    else if(map[playerRow][playerColumn+1] == 'K'){
                        System.out.println("You got key, Now move to the Exit");
                        keyObtained = true;
                        map[playerRow][playerColumn] = '.';
                        map[playerRow][playerColumn+1] = 'P';
                        playerColumn++;
                    }
                    else if(map[playerRow][playerColumn+1] == 'E'){
                        // if user want to reach exit there are two options
                        // Does user have key to open the gate
                        if((playerRow == ExitRow && playerColumn+1 == ExitColumn)){
                            // Yes user does
                            if(keyObtained){
                                System.out.println("You escaped from the dungeon");
                                isPlaying = false;
                            }
                            // No, user does not
                            else{
                                System.out.println("Before reaching gate, you have to get the key");
                            }
                        }
                    }
                    else{
                        map[playerRow][playerColumn] = '.';
                        map[playerRow][playerColumn+1] = 'P';
                        playerColumn++;
                    }
                }
                else System.out.println("Invalid Input Try again");
         

                // if user has been escaping from dungeons , there is no reason for  moving ghosts 
                if ( !((playerRow == ExitRow && playerColumn == ExitColumn) && keyObtained) ){
                    int[] newPosition1 = moveVariable(map, rand, 'G', Ghost1Row, Ghost1Column);
                    Ghost1Row = newPosition1[0];
                    Ghost1Column = newPosition1[1];
                    Ghost1Catched = newPosition1[2];

                    int[] newPosition2 = moveVariable(map, rand, 'G', Ghost2Row, Ghost2Column);
                    Ghost2Row = newPosition2[0];
                    Ghost2Column = newPosition2[1];
                    Ghost2Catched = newPosition2[2];

                    int[] newPosition3 = moveVariable(map, rand, 'G', Ghost3Row, Ghost3Column);
                    Ghost3Row = newPosition3[0];
                    Ghost3Column = newPosition3[1];
                    Ghost3Catched = newPosition3[2];

                    int[] newPosition4 = moveVariable(map, rand, 'G', Ghost4Row, Ghost4Column);
                    Ghost4Row = newPosition4[0];
                    Ghost4Column = newPosition4[1];  
                    Ghost4Catched = newPosition4[2];
                }
                // after ghosts move, check the condition that whether is user death or not
                if(Ghost1Catched == 1 || Ghost2Catched == 1 || Ghost3Catched == 1 || Ghost4Catched ==1){
                    System.out.println("You died");
                    userDied = true;
                    isPlaying = false;
                }

            }while(isPlaying && !userDied);
            
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