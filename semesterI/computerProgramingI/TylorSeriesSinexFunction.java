public class TylorSeriesSinexFunction {
    public static void main(String[] args) {
        // Taylor (Maclaurin) series for sin(x):
        // sin(x) = x - x^3/3! + x^5/5! - x^7/7! + ...
        
        double x = 0.5;       // input of sine function (in radians)
        int termCount = 100;  // how many terms of the series we use
        double total = 0.0;   // running sum of the series

        // First term of the series is x (corresponding to i = 1)
        total += x;

        // i starts from 2 because the term for i = 1 (just x) is already added
        for (int i = 2; i <= termCount; i++) {

            // ---------- power part: x^(2*i - 1) ----------
            // We want exponents 3, 5, 7, ... for i = 2, 3, 4, ...
            double top = 1.0;                    // will become x^(2*i - 1)
            for (int j = 1; j <= (2 * i) - 1; j++) {
                top *= x;                        // multiply x (2*i - 1) times
            }

            // ---------- factorial part: (2*i - 1)! ----------
            double bottom = 1.0;                 // will become (2*i - 1)!
            for (int k = 1; k <= (2 * i) - 1; k++) {
                bottom *= k;                     // multiply 1 * 2 * ... * (2*i - 1)
            }

            // One term of the series: x^(2*i - 1) / (2*i - 1)!
            double temp = top / bottom;

            // ---------- alternating sign ----------
            // For i = 2 (term x^3/3!), the sign should be negative.
            // Pattern: -, +, -, + ...  so we flip sign when i is even.
            if (i % 2 == 0) {
                temp *= -1;                      // change sign for even i
            }

            // Add this term to the total sum
            total += temp;
        }

        // Print Taylor-series approximation of sin(x)
        System.out.println(total);

        // Print library value for comparison
        System.out.println(Math.sin(x));
    }
}
