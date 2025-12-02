/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author okkes
 */
public class nestedForLoopsDrawingShape1 {
    public static void main(String[] args) {
        /*
        
        1st draw
            *
           * *
          *   *
         *     *
        * * * * *
        * * - * *
        * - - - *
        - - - - -
        * * * * *
        */
        
        // ---------------- TOP OF SHAPE (1st piece: hollow triangle) ----------------
        /*
            *
           * *
          *   *
         *     *
        */
        for (int i = 0; i < 4; i++) {                 // i = current row (0..3)
            // Print leading spaces to shift the triangle to the right
            for (int k = 0; k < 4 - i; k++) {
                System.out.print(" ");
            }

            if (i == 0) {
                // First row: a single '*'
                System.out.print("*");
            } else {
                // Other rows: star, inner spaces, star
                System.out.print("*");                // left edge of triangle

                // inner spaces between the two stars
                for (int j = 1; j <= 2 * i - 1; j++) {
                    System.out.print(" ");
                }

                System.out.print("*");                // right edge of triangle
            }

            // Move to next line after finishing one row
            System.out.println();
        }

        // ---------------- BOTTOM OF SHAPE (2nd piece: block + last line) ----------------
        /*
        2nd piece
        * * * * *
        * * - * *
        * - - - *
        - - - - -
        * * * * *
        */
        for (int i = 0; i <= 4; i++) {                // i = row index (0..4)
            for (int j = 0; j <= 4; j++) {            // j = column index (0..4)

                // First and last rows are full of '*'
                if (i == 0 || i == 4) {
                    System.out.print("* ");
                } else {
                    // Middle rows: decision between '*' and '-'
                    // Region where we print '-' grows as i increases:
                    // row 1: j in [2,2]
                    // row 2: j in [1,3]
                    // row 3: j in [0,4]
                    if (j >= 3 - i && j < 2 + i) {
                        System.out.print("- ");
                    } else {
                        System.out.print("* ");
                    }
                }
            }
            // End of current row
            System.out.println();
        }

        ////////////////////////////////////////////////////////
        // Separator lines between the first and second drawings
        System.out.println("____________________________________________________________");
        System.out.println("____________________________________________________________");
        System.out.println("____________________________________________________________");
        System.out.println("____________________________________________________________");
        System.out.println("____________________________________________________________");

        /*
        2nd draw
        * * * * *
        *       *
        * *   * *
        * * * * *
        */

        // ---------------- 2nd DRAW: frame with inner pattern ----------------
        for (int i = 0; i <= 3; i++) {                // i = row index (0..3)
            for (int j = 0; j <= 4; j++) {            // j = column index (0..4)

                // First and last rows are solid '*'
                if (i == 0 || i == 3) {
                    System.out.print("* ");
                } else {
                    // Middle rows (i = 1 or 2):
                    // We create a "hole" (spaces) in the middle depending on the row.
                    // Condition j >= i && j <= 4 - i defines the blank region.
                    if (j >= i && j <= 4 - i) {
                        System.out.print("  ");       // two spaces = one "empty cell"
                    } else {
                        System.out.print("* ");
                    }
                }
            }
            // Move to next line after finishing the row
            System.out.println();
        }
    }
}
