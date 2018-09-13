
public class Ex_1_1_30_my {

	public static void main(String[] args) {

		int N = 2;
		
		boolean bls[][] = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(Euclid(i, j) == 1) {
					bls[i][j] = true;
				} else {
					bls[i][j] = false;
				}
			}
		}

		show(bls);
		
		show(boolm(N));
		
	}
	
	public static void show(boolean a[][]) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a.length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("----------------------");
	}
	
//	欧几里得算法，添加了一个 if 判断
	public static int Euclid(int a, int b) {

//		3 / 9 = 0...3
//		小的数对大的数取余，得到的余数肯定是本身
//		下一轮 Euclid(b, r) 就相当于 Euclid(a, b)
//		如：
//		第一轮：a=18 b=240
//		第二轮：a=240 b=18
		
//		System.out.println("a=" + a + " b=" + b);

//		如果是 (1, 0) 或者 (0,1) 那么就是互质的
		if((a == 0 && b == 1) || (b == 0 && a == 1)) {
			return 1;
		} else if(a==0 || b==0) {
			return -1;
		}
		
		int r = a % b;
		
		if(r == 0) {
			return b;
		} else {
			return Euclid(b, r);
		}
	}
	
//	在网上抄的方法，他的思路：i 和 j 互质的话，就不用判断 j 和 i 了。
//	还有如果两个数都是双数，肯定不互质。
//	但是当 N = 2 的时候，a[1][1] 不互质？？
//	懒得想了。2018年9月13日 20:23:49
	public static boolean[][] boolm(int N) {
		boolean[][] a = new boolean[N][N];
		
		if (N == 1) {
//			如果 N = 1，说明数组个数只有一个 a[0][0]，就应该是 false，而且默认初始化为 0，就不用改了
			return a;
		} else if (N == 2) {
			a[0][1] = true;
		} else if (N == 3) {
			a[0][1] = true;
			a[1][2] = true;
		} else if (N > 3) {
			a[0][1] = true;
			for (int i = 1; i < N; i++) {
				a[1][i] = true;
			}
			for (int i = 2; i < N; i++) {
				if (i + 1 < N) {
					a[i][i + 1] = true;
				}
				
				for (int j = i + 2; j < N; j++) {
					a[i][j] = (Euclid(i, j) == 1) ? true : false;
				}
			}
		}

		for (int i = 1; i < N; i++)
		for (int j = 0; j < i; j++)
		a[i][j] = a[j][i];

		return a;
	}
}
