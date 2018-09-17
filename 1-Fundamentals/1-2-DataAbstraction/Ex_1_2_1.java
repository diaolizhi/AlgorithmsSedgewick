
public class Ex_1_2_1 {

	public static void main(String[] args) {
		
		int N = 100;
		
		StdDraw.setPenRadius(0.005);
		
//		用于保存随机生成的点
		Point2D[] points = new Point2D[N]; 
//		保存最小的两点在 points 中的位置
		int[] mins = new int[2];
//		两点之间的最近距离
		double min = 0;

		for(int i=0; i<N; i++) {
//			random 方法返回的是 [0-1) 之间的值
			points[i] = new Point2D(StdRandom.random(), StdRandom.random());
			points[i].draw();
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i != j) {
					double distance = points[i].distanceTo(points[j]);
					if(distance > min || min <= 0) {
						min = distance;
						mins[0] = i;
						mins[1] = j;
					}
				}
			}
		}
		
		System.out.println("最近距离是：" + min);
	}

}
