
public class Matrix {

	/**
	 * 向量点乘
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
			System.out.println("这两个向量不能相乘。");
		}
		
		return res;
	}

	/**
	 * 矩阵乘矩阵
	 * 如果下次写还是要想很久，不要气馁，不是自己忘了，只是脑子转不过弯~
	 * 2018年9月15日 19:55:08
	 * @param a
	 * @param b
	 * @return
	 */
	public static double[][] mult(double[][] a, double[][] b) {
		
//		新矩阵的行数
		int row = a.length;
//		新矩阵的列数
		int col = b[0].length;
//		a 的列数，也就是 b 的行数
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
	 * 转置矩阵
	 * 第一行变成第一列
	 * 
	 * @param a
	 * @return
	 */
	public static double[][] transpose(double[][] a) {
		
//		新矩阵的行数
		int row = a.length;
//		新矩阵的列数
		int col = a[0].length;

//		已经知道是第一行变成第一列，所以如果原本有 n 行，现在就有 n 列。所以这里 col 和 row 位置反过来
		double[][] res = new double[col][row];
		
		for(int i=0; i<col; i++) {
			for(int j=0; j<row; j++) {
				res[i][j] = a[j][i];
			}
		}
		
		return res;
	}
	
	/**
	 * 矩阵和向量之积
	 * 这个方法和下面那个类似
	 * 想了好久，也不知道“矩阵乘向量”和“向量乘矩阵”是不是一样的操作。
	 * 代码是改出来的而不是想出来的。
	 * 2018年9月15日 20:03:48
	 * @param a
	 * @param x
	 * @return
	 */
	public static double[] mult(double[][] a, double x[]) {

//		原矩阵的列数，也就是新向量的元素个数
		int col = a[0].length;
//		原向量的个数
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
			System.out.println("这个矩阵和向量无法相乘。");
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
			System.out.println("这个向量和矩阵无法相乘。");
		}

		return res;
	}

}
