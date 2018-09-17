
public class Ex_1_2_1 {

	public static void main(String[] args) {
		
		int N = 100;
		
		StdDraw.setPenRadius(0.005);
		
//		���ڱ���������ɵĵ�
		Point2D[] points = new Point2D[N]; 
//		������С�������� points �е�λ��
		int[] mins = new int[2];
//		����֮����������
		double min = 0;

		for(int i=0; i<N; i++) {
//			random �������ص��� [0-1) ֮���ֵ
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
		
		System.out.println("��������ǣ�" + min);
	}

}
