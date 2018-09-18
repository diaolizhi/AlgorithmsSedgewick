import java.util.Arrays;

public class Ex_1_2_09 extends BinarySearch{

	public static void main(String[] args) {
		
		int[] a = {1, 2, 8, 9, 5, 77, 6, 4, 33, 12, 23, 69};
		
		Arrays.sort(a);
		
		int key = 77;

		Counter c = new Counter("myCounter");
		
		rank(key, a, c);
		
		System.out.println(c);

	}

	// 修改 BinarySearch 中的 rank 方法
    public static int rank(int key, int[] a, Counter c) {
        int lo = 0;
        int hi = a.length - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            c.increment();
            if      (key < a[mid]) hi = mid - 1;
            else if (key > a[mid]) lo = mid + 1;
            else return mid;
        }
        return -1;
    }

}
