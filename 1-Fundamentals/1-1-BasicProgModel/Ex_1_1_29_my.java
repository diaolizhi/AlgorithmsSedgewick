/**
 * 怎么硕呢？这个答案还是跑题了。
 * rank 方法返回的是小于 key 的个数
 * cout 方法返回的是等于 key 的个数
 */

import java.util.Arrays;

public class Ex_1_1_29_my {

	public static void main(String[] args) {
		
		int nums[] =  { 7, 1, 5, 1, 9, 5, 7, 7, 5, 1, 8, 5, 4, 3, 2, 10 ,99, 100 };

		Arrays.sort(nums);

		int key = 7;

		int i = rank(key, nums);
		int j = count(key, nums);
		
		for(int k=i; k<=i+j-1; k++) {
			System.out.print(nums[k] + " ");
		}
		System.out.println();
		
		
	}
	
	public static int rank(int key, int a[]) {
		
		int i;
		
		for(i=0; a[i] < key; i++) {
			
		}
		
		return i;
	}

	public static int count(int key, int a[]) {

		int num = 0;
		
		for(int i=0; i<a.length-1 && a[i]<=key; i++) {
			if(a[i] == key) {
				num++;
			}
		}
		
		return num;
	}

}
