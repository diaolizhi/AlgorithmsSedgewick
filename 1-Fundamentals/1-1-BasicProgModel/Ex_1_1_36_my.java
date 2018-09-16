/**
 * 先定义一个大小为 M 的数组 ms，将其打乱 N 次（利用 shuffle 方法）
 * 每次打乱之前 ms[i]=i。
 * 还有一个 M*M 的表格 table。
 * table[i][j] 的值表示：数字 j 在打乱之后，出现在第 i 位的次数。
 * 所以打乱之后，遍历数组 ms，table[i][ms[i]]++。
 * 或者说，table 竖下来一列表示的是“位置”，横过去对应的是“数值”。
 * ...说不清楚
 * 2018年9月15日 21:26:53
 * @author dlz
 *
 */

public class Ex_1_1_36_my {
	
	public interface MyShuffle{
		public void shuffle(int a[]);
	}
	
	public static void ShuffleTest(MyShuffle shuffle, int M, int N) {
//		 M * M 表格
		int[][] table = new int[M][M];

//		大小为 M 的数组
		int[] ms = new int[M];
		
//		打乱 N 次
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				ms[j] = j;
			}

			shuffle.shuffle(ms);

//			将信息存入 table 中
			for(int j=0; j<M; j++) {
				table[j][(int) ms[j]]++;
			}
		}
		
//		打印输出
		for(int i=0; i<M; i++) {
			for(int j=0; j<M; j++) {
				System.out.printf("%6d ", table[i][j]);
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		
		int M = 10,
			N = 1000000;

		MyShuffle shuffle = new MyShuffle() {
			
			@Override
			public void shuffle(int[] a) {
				StdRandom.shuffle(a);
			}
		};
		
		ShuffleTest(shuffle, M, N);
	}

}
