
public class Ex_1_2_17 {

	public static void main(String[] args) {

		Rational_my r1 = new Rational_my(Long.MAX_VALUE / 2 + 1, Long.MAX_VALUE -1);
		Rational_my r2 = new Rational_my(Long.MAX_VALUE / 2 + 3, Long.MAX_VALUE -1);
		
		Rational_my r3 = new Rational_my(2, 1);
		Rational_my r4 = new Rational_my(Long.MAX_VALUE, Long.MAX_VALUE / 2 -1);
		
		Rational_my r5 = new Rational_my(1, 2);

//		System.out.println(r1.plus(r2));
		
//		System.out.println(r4.times(r3));
		
		System.out.println(r3.plus(r5));
	}

}
