import java.lang.Object;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;
public class ToBinString
        {
        public static String TBS(int N)
        {
           String s="";
           for(int n=N;n>0;n/=2)
               s=(n%2)+s;
return s;
        }


public static void main(String[]args)
        {
            int src;
                        StdOut.println("Enter the source the number");
            src=StdIn.readInt();
            StdOut.printf("Here's the binary result %s",TBS(src));
        }
        }
