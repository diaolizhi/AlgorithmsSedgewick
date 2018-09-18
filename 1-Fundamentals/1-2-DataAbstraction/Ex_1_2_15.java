
public class Ex_1_2_15 {

	public static void main(String[] args) {

		int[] a = readInts("tinyT.txt");
		
		for(int i=0; i<a.length; i++) {
			System.out.println(a[i]);
		}
		
	}

	public static int[] readInts(String fileName) {
		In in = new In(fileName);
		String str = in.readAll();
		String[] strs = str.split("\\s+");
		
		int[] nums = new int[strs.length];
		for(int i=0; i<nums.length; i++) {
			nums[i] = Integer.parseInt(strs[i]);
		}
		
		return nums;
	}
}
