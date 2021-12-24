import edu.princeton.cs.algs4.StdOut;

public class BioDstrn {
    /*public static double binomial(int n, int k, double p, int lv) {
        StdOut.printf("%d\n", lv);
        if (n == 0 && k == 0) return 1.0;
        if (n < 0 || k < 0) return 0.0;
        return (1.0 - p) * binomial(n - 1, k, p, ++lv) + p * binomial(n - 1, k - 1, p, ++lv);
    }*/
    public static double binomial(int n, int k, double p) {
        double res[][] = new double[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            res[i][0] = 1.0;
        double pT = 1.0, pF = 1.0;
        for (int i = k; i > 0; i--)//p success
            pT *= p;
        for (int i = n - k; i > 0; i--)
            pF *= 1 - p;//p failure
        for (int i = 1; i <= n; i++)//coe
            for (int j = 1; j <= k; j++) {
                res[i][j] = res[i - 1][j - 1] + res[i - 1][j];
            }
        return res[n][k] * pF * pT;//binomial
    }

    public static void main(String[] args) {
        StdOut.printf("The probability of  100, 50, 0.25 is %e", binomial(100, 50, 0.25));
    }
}
