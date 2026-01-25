import java.util.Scanner;
public class findingSecondDistinctNumber {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a number: ");
        int n = scan.nextInt();
        int[] arr= new int[n];
        
        for(int i =0; i<n; i++){
            System.out.println("Enter a numbeR: ");
            int number = scan.nextInt();
            arr[i]=number;
        }
        
        int max = Integer.MIN_VALUE;
        for(int i =0; i<n; i++){
            if(arr[i]> max) max = arr[i];
        }
        
        int SecondMax = Integer.MIN_VALUE;
        for(int i =0; i<n; i++){
            if(arr[i]< max && arr[i]> SecondMax){
                SecondMax = arr[i];
            }
        }
        
        System.out.println(SecondMax);
    }
}
