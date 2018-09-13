import java.util.Arrays;

/**
 * 2018年9月11日 21:48:19
 * 这道题实属看不懂题目
 * 就当它是：删除一个数组中的重复元素。
 * @author dlz
 *
 */

public class Ex_1_1_28_my {

	public static void main(String[] args) {
		int whiteList[] = { 7, 1, 5, 1, 9, 5, 7, 7, 5, 1, 9, 9, 9, 11, 11, 11, 11, 11, 11, 11, 11 };
		
		Arrays.sort(whiteList);
		
		int a[] = f(whiteList);

		show(a);
//		show(whiteList);
	}
	
	public static void show(int a[]) {
		for(int i=0; i<a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

	/**
	 * 从数组第一位开始，如果这一位跟下一位结果相同。
	 * 那么从下一位的下一位开始，每一位向前挪一位，并且最后一位置为第一位的值 -1
	 * 如：1 1 5 5 7 -> 1 5 5 7 0 -> 1 5 7 0 0
	 * 注意点：最外层循环，i 最大的值为 len-remoNum-1。
	 * 2018年9月12日 21:28:11
	 * @param whiteList
	 * @return
	 */
	public static int[] f(int whiteList[]) {
		
		int remoNum = 0;
		int newNum = 0;
		int len = whiteList.length-1;
		
		/**
		 * 因为数组元素往前移动，并且最后一个元素没有处理，所以后面的元素全都是 9
		 * 
		 */
		
		for(int i=0; i<len-remoNum; i++) {
			while(whiteList[i] == whiteList[i+1]) {
//				避免后面全是 9
				whiteList[len-remoNum] = whiteList[0]-1;
				
				for(int j=i+1; j<len-remoNum; j++) {
					whiteList[j] = whiteList[j+1];
				}
				remoNum++;
			}
			newNum++;
		}
		
		int newList[] = new int[newNum];
		
		for(int i=0; i<newNum; i++) {
			newList[i] = whiteList[i];
		}
		
		return newList;
	}
}
