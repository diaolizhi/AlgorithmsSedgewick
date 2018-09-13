
import java.util.Arrays;

// Based on class BinarySearch
public class Ex_1_1_22a
{
    // precondition: array a[] is sorted
    public static int rank(int key, int[] a)
    {
        int lo = 0,
            hi = a.length - 1,
            indent = 0;
        while (lo <= hi) {
            StdOut.printf("%s%-4d%d\n", repeat(4*indent++, ' '), lo, hi);
            
            // Key is in a[lo..hi] or not present.
            int mid = lo + (hi - lo) / 2;
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }
    
    private static String repeat(int n, char c)
    {
        String s = "";
        for (int i = 0; i < n; i++)
            s += c;
        return s;
    }
    
    public static void main(String[] args)
    {
//    	这里是通过文件来获得数组
//    	对于 Eclipse：右击文件->Run As->Run Configureations
//    	选择 Arguments，输入：tinyW.txt < tinyT.txt
        int[] whitelist = In.readInts(args[0]);

        Arrays.sort(whitelist);

        // read key; print if not in whitelist
        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            System.out.println(key);
            if (rank(key, whitelist) == -1)
                StdOut.println(key);
        }
    }
}
