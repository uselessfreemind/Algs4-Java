import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.util.Arrays;

public class StaticSETofInts {
    private int[] temp;

    public StaticSETofInts(int[] a) {
        temp = new int[a.length];
        for (int i = 0; i < a.length; i++)
            temp[i] = a[i];
        Arrays.sort(temp);
        for (int i : temp)
            StdOut.println(i);
    }

    boolean contains(int key, int hi, int lo) {
        return (rank(key, hi, lo) != -1);
    }

    private int rank(int key, int hi, int lo) {
        int mid = 0;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (key < temp[mid])
                hi = mid - 1;
            else if (key > temp[mid])
                lo = mid + 1;
            else return mid;
        }
        return -1;
    }

    public int howMany(int key, int hi, int lo) {// a,b,c,d,d,d,e
        int idmax = 0, idmin = 0;//    find how many keys at right and left of [mid] respectively
        int m = rank(key, hi, lo);//   and sum the two-1
        int n = rank(key, hi, lo);// Apparently it's O(NlogN) not logN. To achieve that, binarysearch
        while (m != -1) {         // must be modified and separated to two methods to calculate idmin and idmax
            idmin++;              // which are O(logN).
            m = rank(key, m - 1, lo);
        }
        while (n != -1) {
            idmax++;
            n = rank(key, hi, n + 1);
        }
        return idmax + idmin - 1;
    }

    public static void main(String[] args) {
        int source[] = new int[10];
        for (int i = 0; i < 10; i++)
            source[i] = StdRandom.uniformInt(0, 10);
        StaticSETofInts raw = new StaticSETofInts(source);
        StdOut.printf("there are %d keys in the array", raw.howMany(8, 9, 0));
    }
}
