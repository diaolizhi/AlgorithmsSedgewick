/**
 * 题目：
 * 在圆上画出间距相等的 N 个点，每对点按照概率 p 用灰线连接。
 * 思路：
 * 第 i 个点的坐标：x=points[i][0]，y=points[i][1]
 * 难点是：画出间距相等的点。
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
		
//		一共有 N 个点，每个点有两个属性：X, Y
		double[][] points = new double[N][2];

		for(int i=0; i<N; i++) {
//			这两句是 copy 的，实在想不出怎么写
			points[i][0] = Math.cos(2 * Math.PI * i / N);
            points[i][1] = Math.sin(2 * Math.PI * i / N);
            StdDraw.point(points[i][0], points[i][1]);
		}
		
//		将画笔大小重置，免得线太粗
		StdDraw.setPenRadius();

//		用一个点去连接每一个点，根据概率判断是否要连线
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(StdRandom.bernoulli(p)) {
					StdDraw.line(points[i][0], points[i][1], points[j][0], points[j][1]);
				}
			}
		}
		
	}

}
