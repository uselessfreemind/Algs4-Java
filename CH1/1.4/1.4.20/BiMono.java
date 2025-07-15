import edu.princeton.cs.algs4.StdOut;

import java.util.NoSuchElementException;

public class BiMono {
    public static int biMonoSch(int a[], int key) {
        int mid, peak = 0;
        int lmid, rmid;
        int lo = 0, hi = a.length - 1;
        while (lo <= hi) {
            mid = lo + (hi - lo) / 2;
            if (a[mid] < a[mid - 1])
                hi = mid - 1;
            else if (a[mid] < a[mid + 1])
                lo = mid + 1;
            else {
                peak = mid;
                break;
            }//determin peak value's index
        }

        if (key > a[peak]) throw new NoSuchElementException("key is larger than any elements\n");
        StdOut.printf("The peak value's index is %d\n", peak);
        if (a[peak] == key) return peak;
        else {
            hi = peak - 1;
            lo = 0;
            while (lo <= hi) {
                lmid = lo + (hi - lo) / 2;
                if (key < a[lmid]) hi = lmid - 1;
                else if (key > a[lmid]) lo = lmid + 1;
                else return lmid;
            }//search peak's leaf
            lo = peak + 1;
            hi = a.length - 1;
            while (lo <= hi) {
                rmid = lo + (hi - lo) / 2;
                if (key < a[rmid]) lo = rmid + 1;
                else if (key > a[rmid]) hi = rmid - 1;
                else return rmid;
            }//search peak right
        }
        return -1;
    }


    public static void main(String[] args) {
        int raw[] = {6, 8, 11, 36, 21, 10, 7, 4, 3, 1};
        int raw2[] = {11, 9, 8, 15, 23, 51};
        StdOut.printf("The key'index is %d", biMonoSch(raw2, 5));
    }
}

