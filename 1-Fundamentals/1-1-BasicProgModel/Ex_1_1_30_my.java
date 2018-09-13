
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
	
//	ŷ������㷨�������һ�� if �ж�
	public static int Euclid(int a, int b) {

//		3 / 9 = 0...3
//		С�����Դ����ȡ�࣬�õ��������϶��Ǳ���
//		��һ�� Euclid(b, r) ���൱�� Euclid(a, b)
//		�磺
//		��һ�֣�a=18 b=240
//		�ڶ��֣�a=240 b=18
		
//		System.out.println("a=" + a + " b=" + b);

//		����� (1, 0) ���� (0,1) ��ô���ǻ��ʵ�
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
	
//	�����ϳ��ķ���������˼·��i �� j ���ʵĻ����Ͳ����ж� j �� i �ˡ�
//	�����������������˫�����϶������ʡ�
//	���ǵ� N = 2 ��ʱ��a[1][1] �����ʣ���
//	�������ˡ�2018��9��13�� 20:23:49
	public static boolean[][] boolm(int N) {
		boolean[][] a = new boolean[N][N];
		
		if (N == 1) {
//			��� N = 1��˵���������ֻ��һ�� a[0][0]����Ӧ���� false������Ĭ�ϳ�ʼ��Ϊ 0���Ͳ��ø���
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
