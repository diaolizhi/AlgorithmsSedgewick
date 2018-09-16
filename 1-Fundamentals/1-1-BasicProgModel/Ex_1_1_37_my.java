/**
 * 在 Ex_1_1_36_my 中定义 MyShuffle 接口，一个原因是为了在这个程序中再次使用。
 * 这道题主要是重写 StdRandom 的 shuffle 方法
 * 这说明，打乱一个数组的正确方法就应该跟 StdRandom.shuffle 一样。
 * 2018年9月16日 13:16:07
 * @author dlz
 *
 */

public class Ex_1_1_37_my {

	public static void main(String[] args) {
		
		int M = 10,
			N = 1000000;
		
		Ex_1_1_36_my.MyShuffle myShuffle = new Ex_1_1_36_my.MyShuffle() {
			
			@Override
			public void shuffle(int[] a) {
				for(int i=0; i<a.length; i++) {
					int r = StdRandom.uniform(M);    //在 0~N-1 之间 
					int temp = a[i];
					a[i] = a[r];
					a[r] = temp;
				}
			}
		};
		
		Ex_1_1_36_my.ShuffleTest(myShuffle, M, N);

	}

}
