import java.util.Arrays;

public class Ex_1_1_39_my {

	public static void test(int N, int t) {

		int a[] = new int[N];
		int b[] = new int[N];
		
		
		int count = 0;
		
		for(int i=0; i<t; i++) {
			for(int j=0; j<N; j++) {
				a[j] = StdRandom.uniform(100000, 1000000);
				b[j] = StdRandom.uniform(100000, 1000000);
			}
			
			Arrays.sort(b);

			for(int j=0; j<N; j++) {
				if (BinarySearch.rank(a[j], b) >= 0) {
					count++;
				}
			}
		}
		
		double avg = count / t;
		System.out.printf("%7d:%8.2f\n", N, avg);
	}

	public static void main(String[] args) {
		
		int t = 10;
		
		int[] nums = {1000, 10000, 100000, 1000000};

		for(int i=0; i<nums.length; i++) {
			test(nums[i], t);
		}

	}

}
