
public class Ex_1_2_10 {

	public static void main(String[] args) {

		int N = 100;
		
		VisualCounter vc = new VisualCounter(N, 20);
		
		for(int i=0; i<N; i++) {
//			�����һ���߼�һ
			vc.random();
		}
	}

}
