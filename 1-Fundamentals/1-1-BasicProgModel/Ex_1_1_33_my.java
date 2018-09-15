/**
 * ��ĿҪ��ӱ�׼�����ȡ�������������д����
 * ��ѧ̫����Ӳ����ã���֪���Բ��ԡ�
 * 2018��9��15�� 19:51:18
 * @author dlz
 *
 */

public class Ex_1_1_33_my {

	public static void main(String[] args) {
		
		double x[] = {1, 3, 4};
		double y[] = {2, 5, 7};
		
		System.out.println(Matrix.dot(x, y));

		double a[][] = {{1, 2, 3}, {4, 5, 6}};
		double b[][] = {{1, 4}, {2, 5}, {3, 6}};
		
		show(Matrix.mult(a, b));
		
		double[][] c = {{1, 0, 2}, {-2, 1, 3}};
		show(Matrix.transpose(c));
		
		double[] d = {0.15, 0.1, 0.15, 0.05};
		double[][] e = {{0, 0, 0.2, 0.3, 0.5}, {0.1, 0.4, 0.4, 0.1, 0},
				{0, 0, 0, 0.5, 0.5}, {0.4, 0.3, 0.3, 0, 0}};
		show(Matrix.mult(e, d));
		
		show(Matrix.mult(d, e));

	}
	
//	��ӡ����
	public static void show(double[][] a) {
		for(int i=0; i<a.length; i++) {
			for(int j=0; j<a[0].length; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println();
	}
	
	public static void show(double[] a) {
		
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}

}

