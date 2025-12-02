import java.util.Scanner;
// basic number guess game template
public classs NumberGuessGame{
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);        
        // Determine a target number by using math random function
        // it return a value that lies down in this interval [0,1]
         
        int number = (int)(Math.random()*100);
        boolean situation = false;
        for(int i = 0;i<5;i++){
            // Get a input from user to check it with target value  
            System.out.println("Enter a number");
            int prediction = scan.nextInt();
            // There are 3 conditions: equal, less or greather
            if(prediction==number){
                // if the guess matched with target number
                System.out.println("Good Shot");
                // change the winning situation 
                situation = true;
                break;
            }else if(prediction<number){
                System.out.println("Increase your pre, remain attempt count is " + (4-i));   
            }else if(prediction>number){
                System.out.println("Decrase your pre, remain attempt count is " + (4-i));  
            }
        }
        // and print the final situation depends on the situation value 
        if(situation){
            System.out.println("You win");   
        }else{
            System.out.println("You loose, number was " + number);
        }
        
    }
}