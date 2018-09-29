/***
 * Ex_1_2_16 没有使用断言检查溢出
 * @author dlz
 *
 */

public class Rational_my2 {

	private long numerator;
	private long denominator;
	
	public Rational_my2(long numerator, long denominator) {
		this.numerator = numerator;
		this.denominator = denominator;
		
		toSimple();
	}

	public Rational_my2 plus(Rational_my2 b) {
		long de = this.denominator * b.denominator;
		
		long nu1 = this.numerator * b.denominator;
		long nu2 = b.numerator * this.denominator;
		
		long nu = nu1 + nu2;
		
		Rational_my2 r_new = new Rational_my2(nu, de);
		r_new.toSimple();
		
		return r_new;
	}
	
	public Rational_my2 minus(Rational_my2 b) {
		long de = this.denominator * b.denominator;
		
		long nu1 = this.numerator * b.denominator;
		long nu2 = b.numerator * this.denominator;
		
		long nu = nu1 - nu2;
		
		Rational_my2 r_new = new Rational_my2(nu, de);
		r_new.toSimple();
		
		return r_new;
	}
	
	public Rational_my2 times(Rational_my2 b) {
		long de = this.denominator * b.denominator;
		
		long nu = this.numerator * b.numerator;
		
		Rational_my2 r_new = new Rational_my2(nu, de);
		r_new.toSimple();
		
		return r_new;
	}
	
	public Rational_my2 divides(Rational_my2 b) {
		long de = this.denominator * b.numerator;
		
		long nu = this.numerator * b.denominator;
		
		Rational_my2 r_new = new Rational_my2(nu, de);
		r_new.toSimple();
		
		return r_new;
	}

//	化简
	public void toSimple() {
		
		long r = Euclid(this.numerator, this.denominator);
		
		this.numerator /= r;
		this.denominator /= r;
	}
	
	public static long Euclid(long a, long b) {
		
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
	
//	比较两个有理数是否相等
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
		Rational_my2 other = (Rational_my2) obj;
		if (denominator != other.denominator) {
			return false;
		}
		if (numerator != other.numerator) {
			return false;
		}
		return true;
	}

	
}
