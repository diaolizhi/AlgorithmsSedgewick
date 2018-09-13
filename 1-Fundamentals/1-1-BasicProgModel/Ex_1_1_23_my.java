/**
 * 《算法 第四版》第 1.1.23 题
 * 根据另一个项目的代码，判断题目的意思是：
 * 让用户输入 + 或者 -：
 * 然后再输入一组数字，称这些数字为“白名单”
 * 如果输入的是：+，则打印出预先准备好的数字中不在“白名单”的值。比如预先准备的数字有：22，33。白名单只有：33，则打印 22。
 * 如果输入的是：-，则打印出 22。
 * 
 * 为了简单，所有内容都已经写死。
 * @author dlz
 *
 */
public class Ex_1_1_23_my {

	public static void main(String[] args) {

		int a[] = {1, 2, 3, 4, 5, 7, 9, 10, 11, 22, 33, 44};
		int b[] = {4, 5, 6, 33};

//		char arg = '-';
		char arg = '+';
		
		for(int i=0; i<a.length; i++) {
			rank(a[i], b, arg);
		}

	}

	public static void rank(int key, int a[], char arg) {
		
		int res = rank(key, a, 0, a.length-1);
		
		if (res == -1 && arg == '+') {
			System.out.println(key);
		} else if(res != -1 && arg == '-') {
			System.out.println(key);
		}
	}
	
	public static int rank(int key, int a[], int lo, int hi) {
		if(lo > hi) {
			return -1;
		}

		int pos = (hi + lo) / 2;
		int mid = a[pos];
		
		if(key < mid) {
			return rank(key, a, lo, pos-1);
		} else if(key > mid) {
			return rank(key, a, pos+1, hi);
		} else {
			return pos;
		}
	}

}
