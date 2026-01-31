import java.util.Scanner;
public class ReversingSidesofArrays{
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int size;
        while(true){
            System.out.print("How many number you want to enter: ");
            size = scan.nextInt();
            System.out.println();
            
            if(size<1 || size>100)
                System.out.println("Invalid input");
            else
                break;
        }
        
        int[] arr = new int[size];
        int idx = 0;
        while(idx<arr.length){
            System.out.print("Enter a number: ");
            int number = scan.nextInt();
            arr[idx++] = number;
        }
        
        System.out.println("Original Array");
        for(int a : arr){
            System.out.print(a + " ");
        }
        System.out.println();
        
        int beginning = 0;
        int ending = arr.length-1;
        while(beginning<ending){
            int temp = arr[beginning];
            arr[beginning] = arr[ending];
            arr[ending] = temp;
            
            beginning++; ending--;
        }
        int k =2;
        int beginning2 = 0;
        int ending2 = k-1;
        while(beginning2<ending2){
            int temp = arr[beginning2];
            arr[beginning2] = arr[ending2];
            arr[ending2] = temp;
            
            beginning2++; ending2--;
        }
        int beginning3 = k;
        int ending3 = arr.length-1;
        while(beginning2<ending2){
            int temp = arr[beginning3];
            arr[beginning3] = arr[ending3];
            arr[ending3] = temp;
            
            beginning3++; ending3--;
        }
        System.out.println("Reversed Array");
        for(int a : arr){
            System.out.print(a+" ");
        }
        
    }
}