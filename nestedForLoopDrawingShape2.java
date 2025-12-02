import java.util.Scanner;
// Here is the target shape for 7 as input
/*
#######
##   ##
# # # #
#  #  #
# # # #
##   ##
#######
*/

public class nestedForLoopDrawingShape2 {
    public static void main(String[] args) {
        // Create a Scanner object to read input from the keyboard
        Scanner scan = new Scanner(System.in);

        // Ask the user for the size of the square (number of rows/columns)
        System.out.print("Enter edge count: ");
        int edge = scan.nextInt();

        // Outer loop: iterates over each row (0 to edge-1)
        for (int i = 0; i < edge; i++) {

            // Inner loop: iterates over each column (0 to edge-1)
            for (int j = 0; j < edge; j++) {

                // We print '#' in three situations:
                // 1) On the border of the square:
                //      - top row:    i == 0
                //      - bottom row: i == edge - 1
                //      - left col:   j == 0
                //      - right col:  j == edge - 1
                //
                // 2) On the main diagonal (top-left to bottom-right):
                //      j == i
                //
                // 3) On the anti-diagonal (top-right to bottom-left):
                //      i + j == edge - 1
                //
                // This creates a square frame with an 'X' inside.
                if ( (i == 0 || j == 0 || i == edge - 1 || j == edge - 1)  // border
                        || (j == i || (i + j == edge - 1)) ) {             // diagonals
                    System.out.print("#");
                } else {
                    // All other cells are printed as spaces
                    System.out.print(" ");
                }
            }

            // Move to the next line after finishing one row
            System.out.println();
        }

        // Close the scanner (good practice)
        scan.close();
        
    }
}
