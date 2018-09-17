
public class Ex_1_2_2 {

	public static void main(String[] args) {

		int N = 10;
		
		Interval1D[] interval1ds = new Interval1D[N];

		for(int i=0; i<N; i++) {
			double a = StdRandom.random();
			double b = StdRandom.random();
			if(a <= b) {
				interval1ds[i] = new Interval1D(a, b);
			} else {
				interval1ds[i] = new Interval1D(b, a);
			}
		}

		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(i != j) {
//					如果两个间隔相交就打印出来
					if(interval1ds[i].intersects(interval1ds[j])) {
						System.out.println(interval1ds[i] + " " + interval1ds[j]);
					}
				}
			}
		}

	}

}
