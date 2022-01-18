public class Matrix {
    public static double dot(double x[], double y[]) {
        return x[0] * x[1] + y[0] * y[1];
    }

    public static double[][] mult(double x[][], double y[][]) {
        if (x[0].length != y.length)
            return null;
        double res[][] = new double[x.length][y[0].length];
        double temp = 0.0;
        int col = 0;
        while (col <= y[0].length - 1) //compute col by col
        {
            for (int i = 0; i <= x.length - 1; i++)//row
            {
                for (int j = 0; j <= x[0].length - 1; j++)//col
                    temp += x[i][j] * y[j][col];
                res[i][col] = temp;
                temp = 0.0;
            }
            col++;
        }
        return res;
    }

    public static double[][] transpose(double a[][]) {
        int m = a.length, n = a[0].length;
        double result[][] = new double[n][m];
        for (int i = 0; i <= n - 1; i++)
            for (int j = 0; j <= m - 1; j++)
                result[i][j] = a[j][i];
        return result;
    }

    public static double[] mult(double m[][], double v[]) {
        if (m[0].length != v.length)
            return null;
        double res[] = new double[m.length];
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)//col of m
                res[i] += m[i][j] * v[j];
        return res;
    }

    public static void main(String[] args) {
        /*double a[] = {2.0, 3.0};
        double b[] = {2.5, 1.5};
        StdOut.printf("%f, ", dot(a, b));driver program product*/

        /*double a[][] = {{2.0, 2.0}, {1.0, 3.0}, {2.5, 2.25}};
        double b[][] = {{4.0, 1.0, 1.25}, {1.5, 2.0, 5.20}};
        double res[][] = mult(a, b);
        for (int i = 0; i < a.length; i++)
            for (int j = 0; j < b[0].length; j++) {
                StdOut.printf("%f, ", res[i][j]);
                if (j == b[0].length - 1) StdOut.println();
            }driver program matrix multiply*/

       /*double a[][] = {{4.0, 1.0, 1.25}, {1.5, 2.0, 5.20}};
        double res[][] = transpose(a);
        for (int i = 0; i < res.length; i++)
            for (int j = 0; j < res[0].length; j++) {
                StdOut.printf("%f, ", res[i][j]);
                if (j == res[0].length - 1) StdOut.println();
                }
                driver program matrix transpose
        */

      /*  double a[][] = {{1.0, -1.0, 2.0}, {0.0, -3.0, 1.0}};
        double v[] = {2.0, 1.0, 0.0};
        double res[] = mult(a, v);
        for (int i = 0; i < res.length; i++)
            StdOut.printf("%f \n", res[i]);driver program matrix * vector*/
    }
}

