public class Ex_1_1_20_my {
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		StdOut.println(Math.log(f(5)));
		
		StdOut.println(ln(5));
		
//		4.787491742782046
//		4.787491742782046
	}
	
	/**
	 * 2018��9��10�� 18:53:12
	 * �Լ�д��
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
	 * 2018��9��10�� 18:53:28
	 * ���ϳ���
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
