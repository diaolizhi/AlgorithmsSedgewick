
public class Matrix {

	/**
	 * �������
	 * x[1]*y[1] + x[2]*y[2] + ...
	 * @param x
	 * @param y
	 * @return
	 */
	public static double dot(double[] x, double[] y) {
		
		double res = 0;
		
		if(x.length == y.length) {
			for(int i=0; i<x.length; i++) {
				res += x[i] * y[i];
			}
		} else {
			System.out.println("����������������ˡ�");
		}
		
		return res;
	}

	/**
	 * ����˾���
	 * ����´�д����Ҫ��ܾã���Ҫ���٣������Լ����ˣ�ֻ������ת������~
	 * 2018��9��15�� 19:55:08
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[][] mult(double[][] a, double[][] b) {
		
//		�¾��������
		int row = a.length;
//		�¾��������
		int col = b[0].length;
//		a ��������Ҳ���� b ������
		int num = b.length;

		double[][] res = new double[row][col];
		
		for(int i=0; i<row; i++) {
			for(int j=0; j<col; j++) {
				double sum = 0;
				for(int k=0; k<num; k++) {
					sum += a[i][k] * b[k][j];
				}
				res[i][j] = sum;
			}
		}
		
		return res;
	}

	/**
	 * ת�þ���
	 * ��һ�б�ɵ�һ��
	 * 
	 * @param a
	 * @return
	 */
	public static double[][] transpose(double[][] a) {
		
//		�¾��������
		int row = a.length;
//		�¾��������
		int col = a[0].length;

//		�Ѿ�֪���ǵ�һ�б�ɵ�һ�У��������ԭ���� n �У����ھ��� n �С��������� col �� row λ�÷�����
		double[][] res = new double[col][row];
		
		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++) {
				res[i][j] = a[j][i];
			}
		}
		
		return res;
	}
	
	/**
	 * ���������֮��
	 * ��������������Ǹ�����
	 * ���˺þã�Ҳ��֪����������������͡������˾����ǲ���һ���Ĳ�����
	 * �����Ǹĳ����Ķ�����������ġ�
	 * 2018��9��15�� 20:03:48
	 * @param a
	 * @param x
	 * @return
	 */
	public static double[] mult(double[][] a, double x[]) {

//		ԭ�����������Ҳ������������Ԫ�ظ���
		int col = a[0].length;
//		ԭ�����ĸ���
		int num = x.length;

		double[] res = new double[col];

		if(a.length == x.length) {
			
			for(int i=0; i<col; i++) {
				double sum = 0;
				for(int j=0; j<num; j++) {
					sum += x[j] * a[j][i];
				}
				res[i] = sum;
			}
		} else {
			System.out.println("�������������޷���ˡ�");
		}

		return res;
	}
	
	public static double[] mult(double[] y, double[][] a) {
		
		int col = a[0].length;
		int num = y.length;

		double[] res = new double[col];
		
		if(a.length == y.length) {
			
			for(int i=0; i<col; i++) {
				double sum = 0;
				for(int j=0; j<num; j++) {
					sum += a[j][i] * y[j];
				}
				res[i] = sum;
			}
		} else {
			System.out.println("��������;����޷���ˡ�");
		}

		return res;
	}

}
