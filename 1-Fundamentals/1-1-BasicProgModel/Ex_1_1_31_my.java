/**
 * ��Ŀ��
 * ��Բ�ϻ��������ȵ� N ���㣬ÿ�Ե㰴�ո��� p �û������ӡ�
 * ˼·��
 * �� i ��������꣺x=points[i][0]��y=points[i][1]
 * �ѵ��ǣ����������ȵĵ㡣
 * @author dlz
 *
 */

public class Ex_1_1_31_my {

	public static void main(String[] args) {

		StdDraw.setCanvasSize(800, 800);
		StdDraw.setScale(-1, 1);
		StdDraw.setPenRadius(0.1);

		int N = 5;
		double p = 1;
		
//		һ���� N ���㣬ÿ�������������ԣ�X, Y
		double[][] points = new double[N][2];

		for(int i=0; i<N; i++) {
//			�������� copy �ģ�ʵ���벻����ôд
			points[i][0] = Math.cos(2 * Math.PI * i / N);
            points[i][1] = Math.sin(2 * Math.PI * i / N);
            StdDraw.point(points[i][0], points[i][1]);
		}
		
//		�����ʴ�С���ã������̫��
		StdDraw.setPenRadius();

//		��һ����ȥ����ÿһ���㣬���ݸ����ж��Ƿ�Ҫ����
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(StdRandom.bernoulli(p)) {
					StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]);
				}
			}
		}
		
	}

}
