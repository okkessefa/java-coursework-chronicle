/*
 * Maclaurin series approximation of ln(1 + x)
 * ln(1 + x) = x - x^2/2 + x^3/3 - x^4/4 + ...
 * Valid for -1 < x <= 1
 */

/**
 * Approximates ln(1 + x) using its Taylor/Maclaurin series
 * and compares it with Math.log1p(x).
 *
 * @author okkes
 */
public class logarithmOneplusxbasedonE {
    public static void main(String[] args) {

        // x is the input for ln(1 + x)
        double x = 0.7;

        // limit is the number of terms we use in the series
        int limit = 100;

        // total will accumulate the series sum
        double total = 0.0;

        // First term of the series is x (n = 1)
        total += x;

        // Add remaining terms from n = 2 up to n = limit
        for (int i = 2; i <= limit; i++) {

            // -------- power part: x^i --------
            double top = 1.0;      // will become x^i
            for (int j = 1; j <= i; j++) {
                top *= x;          // multiply x i times
            }

            // -------- divide by i to get x^i / i --------
            top /= i;

            // -------- alternating sign --------
            // ln(1 + x) = x - x^2/2 + x^3/3 - x^4/4 + ...
            // Signs: +, -, +, -, ...  i.e. (-1)^(i+1)
            // For even i, term should be negative
            if (i % 2 == 0) {
                top *= -1;
            }

            // Add this term to the cumulative total
            total += top;
        }

        // Print Taylor-series approximation of ln(1 + x)
        System.out.println(total);

        // Print library value of ln(1 + x) for comparison
        System.out.println(Math.log1p(x));
    }
}
