/**
 * �����������˵�ģ�Ӧ�ô��ı��ļ��л�����顣�� Ex_1_1_22a.jva
 * �����Ҳ����������ô��ȡ������ģ����� StdIn.isEmpty() ������ bug��
 * ���Խ�����д�ڴ����У�Ҫ�ҵ�����Ҳд����
 */

import java.util.Arrays;

public class Ex_1_1_22_my {

	public static void main(String[] args) {
		
//		int nums[] = {11, 22, 99, 88, 55, 66, 78, 54, 91, 23, 56, 82, 37};
		int nums[] = {11, 22, 23, 37, 54, 55, 56, 66, 78, 82, 88, 91, 99};

		Arrays.sort(nums);
		
		int res = rank(91, nums);
		System.out.println(res);
	}
	
	public static int rank(int key, int a[]) {
		
		return rank(key, a, 0, a.length-1, 0);
	}
	
	public static int rank(int key, int a[], int lo, int hi, int depth) {

		System.out.printf("%s%d%4d\n", repeat(depth, ' '), lo, hi);
		
		if(lo > hi) {
			return -1;
		}
		
		int p = (hi+lo)/2;
		int mid = a[p];
		
		if(key < mid) {
			return rank(key, a, lo, p-1, depth+1);
		} else if (key > mid) {
			return rank(key, a, p+1, hi, depth+1);
		} else {
			return p;
		}
	}
	
	/**
	 * ���� n ���ַ� c
	 * @param n
	 * @param c
	 * @return
	 */
	public static String repeat(int n, char c) {
		String s = "";
		for(int i=0; i<n; i++) {
			s += c;
		}
		return s;
	}

}
