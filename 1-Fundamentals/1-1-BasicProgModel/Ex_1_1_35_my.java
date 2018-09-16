
public class Ex_1_1_35_my {

	public static void main(String[] args) {

		int SIDES = 6;
		double[] dist = new double[2*SIDES+1];
		
		for(int i=1; i<=SIDES; i++) {
			for(int j=1; j<=SIDES; j++) {
				dist[i+j] += 1;
			}
		}
		
		for(int i=2; i<=2*SIDES; i++) {
			dist[i] /= 36;
		}

		double[] test = new double[2*SIDES+1];
		int N = 10000000;
		
		for(int i=0; i<N; i++) {
			test[StdRandom.uniform(1, 7) + StdRandom.uniform(1, 7)]++;
		}

		for(int i=2; i<2*SIDES+1; i++) {
			test[i] /= N;
		}
		
		show(dist);
		show(test);

	}

	public static void show(double[] a) {
		for(int i=2; i<a.length; i++) {
			System.out.printf("%d:%.3f ", i, a[i]);
		}
		System.out.println();
	}

}
