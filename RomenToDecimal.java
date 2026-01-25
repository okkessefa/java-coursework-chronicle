import java.util.Scanner;
public class RomenToDecimal {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        char[] symbols = {'I','V','X','L','C','D','M'};
        int[] values = { 1, 5,10,50,100,500,1000};
        
        
        System.out.print("Enter a Romen number: ");
        String userInput = scan.nextLine().trim().toUpperCase();
        
        if(userInput.isEmpty()){
            System.out.println("INvalid input");
            return;
        }
        
        int result = 0;
        int prevValue = 0;
        for(int i = userInput.length()-1; i>=0; i--){
            char tempSymbol = userInput.charAt(i);
            
            int currentValue = -1;
            
            for(int j =0; j<symbols.length; j++){
                if(tempSymbol == symbols[j]){
                    currentValue = values[j];
                    // stop seraqching whne find it
                    break;
                }
            }
            if(currentValue == -1){
                System.out.println("Invalid Romen Number: " + tempSymbol); 
            }
            
            // subsracting or addition like the differencies od IV and VI
            if(currentValue < prevValue){
                result -= currentValue;
            }
            else{
                result+=currentValue;
                prevValue = currentValue;
            }
            
        }
        System.out.println(result);
    }
}
