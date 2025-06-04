public class ThreesumOverflow {

    public static int count(int[] a) {
        //Count triples that sum to 0
        int N = a.length;
        int cnt = 0;
        long sum;
        for (int i = 0; i < N; i++)
            for (int j = i + 1; j < N; j++)
                for (int k = j + 1; k < N; k++) {
                    sum = a[i] + a[j] + a[k];
                    if (sum == 0)
                        cnt++;
                }
        return cnt;
    }

    public static void main(String[] args) {


    }
}
