public class TylorSeriesxPowerofEulerNumber {
    public static void main(String[] args) {

        // x is the exponent in e^x
        int x = 12;

        // limit is the number of terms used in the Taylor (Maclaurin) series
        int limit = 100;

        // total will store the partial sum of the series for e^x
        double total = 0.0;

        // First term of the series is 1 (corresponding to x^0 / 0!)
        total += 1;

        // Loop over remaining terms: i = 1, 2, ..., limit
        for (int i = 1; i <= limit; i++) {

            // --------- compute x^i (the power) ----------
            double top = 1.0;          // start with 1, then multiply x i times
            for (int j = 1; j <= i; j++) {
                top *= x;              // after this loop: top = x^i
            }

            // --------- compute i! (the factorial) ----------
            double bottom = 1.0;       // start with 1, then multiply 1⋯i
            for (int k = 1; k <= i; k++) {
                bottom *= k;           // after this loop: bottom = i!
            }

            // One term of the series: x^i / i!
            double temp = top / bottom;

            // Add this term to the running total
            total += temp;
        }

        // Print the Taylor-series approximation of e^x
        System.out.println(total);

        // Print the exact value using the built-in Math library for comparison
        System.out.println(Math.pow(Math.E, x));
    }
}
