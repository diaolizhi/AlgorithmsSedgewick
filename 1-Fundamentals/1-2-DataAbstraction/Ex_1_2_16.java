/**
 * 16��17 �⻹�кܶ�ط�û������
 * 2018��9��19�� 19:57:56
 * @author dlz
 *
 */

public class Ex_1_2_16 {

	public static void main(String[] args) {

		Rational_my2 r1 = new Rational_my2(1, 2);
		Rational_my2 r2 = new Rational_my2(1, 4);
		Rational_my2 r3 = new Rational_my2(1, 10);
		Rational_my2 r4 = new Rational_my2(2, 5);
		Rational_my2 r5 = new Rational_my2(3, 4);

//		3/4
		System.out.println(r5);
//		3/5
		System.out.println(r1.plus(r3));
//		2/5
		System.out.println(r1.minus(r3));
//		3/8
		System.out.println(r1.times(r5));
//		5/8
		System.out.println(r2.divides(r4));
		
		Rational_my2 b1 = new Rational_my2(2, 4);
		
		if(b1.equals(r4)) {
			System.out.println("��ȡ�");
		} else {
			System.out.println("����ȡ�");
		}

		if(b1.equals(r1)) {
			System.out.println("��ȡ�");
		} else {
			System.out.println("����ȡ�");
		}


	}

}
