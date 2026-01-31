public class nestedForLoopDrawingShape3 {
        public staticvoid main(String[] args){
        int max = 78;
        int current = 1;
        int spaces = 12;

        // Outer loop controls how many numbers per line
        for (int lineLen = 1; current <= max; lineLen++) {
            // spaces before each number printing lines
            for(int i =0;i<=spaces;i++){
                System.out.print(" ");
            }
            spaces--;
            // Inner loop prints exactly lineLen numbers (unless we hit max)
            for (int i = 0; i < lineLen && current <= max; i++) {
                System.out.print(current);

                // Print "-" between numbers on the same line
                if (i < lineLen - 1 && current < max) {
                    System.out.print("-");
                }

                current++;
            }
            System.out.println();
        }
    }
}    