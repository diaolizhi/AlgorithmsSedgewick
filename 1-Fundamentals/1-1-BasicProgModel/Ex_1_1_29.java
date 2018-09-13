
import java.util.Arrays;

public class Ex_1_1_29
{
   public static int rank(int key, int[] a)
   {
       return rank(key, a, true);
   }
   
   /**
    * 方法内的 while 循环跟之前递归的 rank 方法有点像，但是这里并不是查找一个数。
    * 另外这个 boolean trace 参数并没有使用（被注释掉了），难道是为了重载 rank 方法？
    * @param key
    * @param a
    * @param trace
    * @return
    */
   public static int rank(int key, int[] a, boolean trace)
    {
        int lo = 0;
        int hi = a.length - 1;
        
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            
//            if (trace)
//                StdOut.printf("%4d%4d -> %4d\n", lo, hi, mid);
            
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else
            {
//            	如果当前位置上的数字等于 key，那么下标 mid 往前移动一位。
//            	要么到 mid 为 -1，或者当前位置的值小于 key
//            	至于为什么 return 的是 mid+1，因为下标从 0 开始。
//            	假设下标为 4 的数字是 key 的前一位，那么 0 1 2 3 4 一共有五位数字
                while (--mid >= 0 && a[mid] == key);
                return mid+1;
            }
        }
        return 0;
    }
    
    public static int count(int key, int[] a)
    {
        int c = 0;
//        利用 rank 方法找到第一个 key 的下标。
//        实际上 rank 返回的是比 key 小的个数，但刚好是第一个 key 的下标
        for (int i = rank(key, a, false); i < a.length && a[i] == key; i++)
            c++;
        return c;
    }
    
    private static boolean verify(int r, int c, int key, int[] a)
    {
        for (int i = 0; i < a.length; i++)
            if ((i <  r || i >  r+c-1) && a[i] == key ||
                (i >= r && i <= r+c-1) && a[i] != key)
                return false;
        return true;
    }

    public static void main(String[] args)
    {
        int[] whitelist = In.readInts(args[0]);

        Arrays.sort(whitelist);
        
        String indices = "",
               values = "";
        for (int i = 0; i < whitelist.length; i++)
        {
            indices += String.format("%4d", i);
            values += String.format("%4d", whitelist[i]);
        }
        StdOut.println(indices + "\n" + values);

        while (!StdIn.isEmpty()) {
            int key = StdIn.readInt();
            int r = rank(key, whitelist);
            int c = count(key, whitelist);
            StdOut.printf("(%d, %d) - %s\n", r, c, verify(r, c, key, whitelist));
        }
    }
}
