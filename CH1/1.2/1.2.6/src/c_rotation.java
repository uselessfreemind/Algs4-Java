import edu.princeton.cs.algs4.StdOut;

public class c_rotation {
    public static boolean cr(String a, String b) {
        if (a.length() != b.length() ||
                a.equals(b))
            return false;
        int start = a.indexOf(b.substring(0, 1));
        String rotate = a.substring(start, a.length());
        if (rotate.equals(b.substring(0, rotate.length())))
            return true;
        else return false;
    }


    public static void main(String[] args) {
        String a = args[0];
        String b = args[1];
        if (cr(a, b))
            StdOut.println("The two strings are circular rotation");
        else
            StdOut.println("The two strings are not circular rotation");

    }
}
