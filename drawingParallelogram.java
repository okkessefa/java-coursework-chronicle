import java.util.Scanner;  // Import the Scanner class for user input

public class drawingParallelogram {
    public static void main(String[] args) {
        // Create a Scanner object to read from the keyboard (standard input)
        Scanner scan = new Scanner(System.in);

        // ----- Read side lengths from the user -----
        System.out.print("Enter a long edge: ");
        int longedge = scan.nextInt();   // Number of '#' characters in each row

        System.out.print("Enter a short edge: ");
        int shortedge = scan.nextInt();  // Number of rows (height of the parallelogram)

        // short1 will control the number of leading spaces in the first row
        // We start with shortedge - 1 spaces, then decrease each row
        int short1 = shortedge - 1;

        // ----- Draw the parallelogram row by row -----
        for (int i = 1; i <= shortedge; i++) {

            // First row: shifted to the right with spaces, then a full line of '#'
            if (i == 1) {
                // " ".repeat(short1)  -> leading spaces to tilt the top edge
                // "#".repeat(longedge) -> full horizontal edge of '#'
                System.out.println(" ".repeat(short1) + "#".repeat(longedge));
            }
            // Last row: printed at the far left with no leading spaces
            else if (i == shortedge) {
                // Just the bottom horizontal edge, aligned to the left
                System.out.println("#".repeat(longedge));
            }
            // Middle rows: slanted, with '#' at both ends and spaces inside
            else {
                // "--short1" decreases short1 before using it,
                // so each next row starts with one fewer space (shifting left)
                System.out.println(
                        " ".repeat(--short1) +       // leading spaces to give the tilt
                        "#" +                        // left border of the parallelogram
                        " ".repeat(longedge - 2) +   // inner spaces between the borders
                        "#"                          // right border of the parallelogram
                );
            }
        }

        // Close the scanner (good practice)
        scan.close();
    }
}
