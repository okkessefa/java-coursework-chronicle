
import java.util.Scanner;
public class PaintingSquares {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        
        // to inrease the visibility those chars selected
        final char first = '1';
        final char second = '2';
        final char common = 'X';
        final char empty = '0';
        
        // creating an empty table but for visibility all points marked as X
        char[][] table = new char[10][10];
        for(int i =0;i<table.length;i++){
            for(int j =0; j<table[0].length;j++){
                table[i][j] = empty;
            }
        }
        
        System.out.print("Enter the X starting point of First Sqaure: ");
        int firstXPoint = scan.nextInt();
        System.out.print("Enter the X starting point of First Sqaure: ");
        int firstYPoint = scan.nextInt();
        System.out.print("Enter the length  of First Sqaure: ");
        int firstSquareLength = scan.nextInt();
        
        System.out.print("Enter the starting point of Second Sqaure: ");
        int secondXPoint = scan.nextInt();
        System.out.print("Enter the starting point of Second Sqaure: ");
        int secondYPoint = scan.nextInt();
        System.out.print("Enter the length of sqaures of Second Sqaure: ");
        int secondSquareLength = scan.nextInt();
        
        // painting area of first square 
        for(int i = firstXPoint; i<Math.min(firstXPoint+firstSquareLength, table.length); i++){
            for(int j = firstYPoint; j<Math.min(firstYPoint+firstSquareLength, table.length); j++){
                // table is already empty so that mark the requested areas
                table[i][j] = first;
            }
        }
        
        // painting area of second sqaure 
        for(int i = secondXPoint; i<Math.min(secondXPoint+secondSquareLength, table.length); i++){
            for(int j = secondYPoint; j<Math.min(secondYPoint+secondSquareLength, table[0].length); j++){
                // if the point i,j is occupied mark as common area
                if(table[i][j] == first){
                    table[i][j] = common;
                // else mark as area Second    
                }else{
                    table[i][j] = second;
                }
            }
        }
        // Printing the table
        for(int i = 0; i<table.length; i++){
            for(int j =0; j<table.length; j++){
                System.out.print(table[i][j] + " ");
            }
            System.out.println();
        }
        scan.close();
    }
}