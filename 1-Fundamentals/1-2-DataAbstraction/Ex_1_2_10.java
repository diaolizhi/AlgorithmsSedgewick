
public class Ex_1_2_10 {

	public static void main(String[] args) {

		int N = 20;
		int max = 10;
		
		VisualCounter vc = new VisualCounter(N, max);
		
		for(int i=0; i<N; i++) {
//			�����һ���߼�һ
			vc.random();
//			vc.increase();
		}
	}

}
