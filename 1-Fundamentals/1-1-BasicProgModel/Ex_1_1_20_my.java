public class Ex_1_1_20_my {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StdOut.println(Math.log(f(5)));
		
		StdOut.println(ln(5));
		
//		4.787491742782046
//		4.787491742782046
	}
	
	/**
	 * 2018年9月10日 18:53:12
	 * 自己写的
	 * @param N
	 * @return
	 */
	public static double f(int N) {
		if(N == 1) {
			return 1;
		} else if(N > 1) {
			return N * f(N-1);
		} else {
			return 0;
		}
	}
	
	/**
	 * 2018年9月10日 18:53:28
	 * 网上抄的
	 * @param N
	 * @return
	 */
	public static double ln(int N) {
		if (N == 0) {
			return 0;
		} else {
			return Math.log(N) + ln(N - 1);
		}
	}

}
