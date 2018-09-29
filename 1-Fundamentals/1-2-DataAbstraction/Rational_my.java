/***
 * Ex_1_2_17 ʹ�ö��Լ������������߼���������
 * ����������˵�ʱ�򣬻�����Լ��һ��
 * 2018��9��19�� 19:54:27
 * @author dlz
 *
 */

public class Rational_my {

	private long numerator;
	private long denominator;

	public Rational_my(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		
		toSimple();
	}

	public Rational_my plus(Rational_my b) {
		
		long de = 0;
		long nu1 = 0;
		long nu2 = 0;
		
		if(this.denominator != b.denominator) {
			de = numMultiply(this.denominator, b.denominator);
			
			nu1 = numMultiply(this.numerator, b.denominator);
			
			nu2 = numMultiply(b.numerator, this.denominator);
		} else {
			de = b.denominator;
			nu1 = this.numerator;
			nu2 = b.numerator;
		}
		
		long nu = numPlus(nu1, nu2);
		
		Rational_my r_new = new Rational_my(nu, de);
		r_new.toSimple();
		
		return r_new;
	}
	
	public Rational_my minus(Rational_my b) {
		long de = numMultiply(this.denominator, b.denominator);
		
		long nu1 = numMultiply(this.numerator, b.denominator);
		long nu2 = numMultiply(b.numerator, this.denominator);
		
		long nu = numMinus(nu1, nu2);
		
		Rational_my r_new = new Rational_my(nu, de);
		r_new.toSimple();
		
		return r_new;
	}
	
	public Rational_my times(Rational_my b) {
		long de = numMultiply(this.denominator, b.denominator);
		
		long nu = numMultiply(this.numerator, b.numerator);
		
		Rational_my r_new = new Rational_my(nu, de);
		r_new.toSimple();
		
		return r_new;
	}
	
	public Rational_my divides(Rational_my b) {
		long de = numMultiply(this.denominator, b.numerator);
		
		long nu = numMultiply(this.numerator, b.denominator);
		
		Rational_my r_new = new Rational_my(nu, de);
		r_new.toSimple();
		
		return r_new;
	}

//	����
	public void toSimple() {
		
		long r = Euclid(this.numerator, this.denominator);
		
		this.numerator /= r;
		this.denominator /= r;
		
	}
	
	public static long Euclid(long a, long b) {
		
		if(b == 0) {
			return 1;
		}
		
		long r = a % b;
		if(r == 0) {
			return b;
		} else {
			return Euclid(b, r);
		}
	}

	@Override
	public String toString() {
		return numerator + "/" + denominator;
//		return 1.0 * this.numerator / this.denominator + "";
	}
	
//	�Ƚ������������Ƿ����
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Rational_my other = (Rational_my) obj;
		if (denominator != other.denominator) {
			return false;
		}
		if (numerator != other.numerator) {
			return false;
		}
		return true;
	}

	private boolean isPlusOverflow(long a, long b) {
//		һ��һ���������������� a �����ģ�ֻ��Ҫ��ֹ b Ҳ�������������������
//		��� a �Ǹ������ͼ��� b Ҳ�Ǹ��������������������������������
		return a > 0 ? Long.MAX_VALUE - a < b : Long.MIN_VALUE - a > b;
	}
	
	private boolean isMinusOverflow(long a, long b) {
//		���� - �������п�����������������
//		���� - �������п�����������������
		return a < 0 ? Long.MIN_VALUE + b > a : Long.MAX_VALUE + b < a;
	}
	
	private boolean isTimesOverflow(long a, long b) {
		return Long.MAX_VALUE * 1.0 / a < b;
	}
	
	private long numMultiply(long a, long b) {
		assert !isTimesOverflow(a, b) : "��������";
		return a * b;
	}
	
	private long numPlus(long a, long b) {
		assert !isPlusOverflow(a, b) : "��������";
		return a + b;
	}
	
	private long numMinus(long a, long b) {
		assert !isMinusOverflow(a, b) : "��������";
		return a - b;
	}
}
