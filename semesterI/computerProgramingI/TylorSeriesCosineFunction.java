/*
 * Taylor series approximation for cos(x)
 * cos(x) = 1 - x^2/2! + x^4/4! - x^6/6! + ...
 */

public class TylorSeriesCosineFunction {
    public static void main(String[] args) {

        // x is the input angle in radians for which we approximate cos(x)
        double x = 0.5;

        // limit is the number of terms we include in the Taylor series
        int limit = 100;

        // total will accumulate the sum of the series
        double total = 0.0;

        // First term of the cos(x) series is 1 (corresponding to x^0 / 0!)
        total += 1;

        // Loop over the remaining terms: i = 1, 2, ..., limit
        // For each i we compute the term x^(2i) / (2i)! with alternating signs
        for (int i = 1; i <= limit; i++) {

            // -------- power part: x^(2i) --------
            double top = 1.0;           // will become x^(2i)
            for (int j = 1; j <= 2 * i; j++) {
                top *= x;               // multiply x 2*i times
            }

            // -------- factorial part: (2i)! --------
            double bottom = 1.0;        // will become (2i)!
            for (int k = 1; k <= 2 * i; k++) {
                bottom *= k;            // multiply 1 * 2 * ... * (2i)
            }

            // One term of the series: x^(2i) / (2i)!
            double temp = top / bottom;

            // -------- alternating sign --------
            // cos(x) = 1 - x^2/2! + x^4/4! - x^6/6! + ...
            // Signs: -, +, -, + ... starting with minus when i = 1
            if (i % 2 == 1) {
                temp *= -1;             // flip sign for odd i
            }

            // Add this term to the running total
            total += temp;
        }

        // Print the Taylor-series approximation of cos(x)
        System.out.println(total);

        // Print the library value of cos(x) for comparison
        System.out.println(Math.cos(x));
    }
}
