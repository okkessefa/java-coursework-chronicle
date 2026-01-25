import java.util.Scanner;
public class validatingSimetricArrays {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a length value: ");
        int n = scan.nextInt();
        int[][] arr = new int[n][n];
        
        for(int i = 0; i<arr.length; i++){
            for(int j = 0; j<arr[0].length; j++){
                System.out.println("Enter a value: ");
                int a = scan.nextInt();
                arr[i][j] = a;
            }
        }
        boolean isSymmetric = true;
        for(int i =0; i<arr.length && isSymmetric; i++){
            for(int j = i+1; j<arr[0].length; j++){
                if(arr[i][j] != arr[j][i]){
                    isSymmetric = false;
                    break;
                }
            }
        }
        if(isSymmetric) System.out.println("Simetric");
        else System.out.println("Not simetric");
        
    }
}
