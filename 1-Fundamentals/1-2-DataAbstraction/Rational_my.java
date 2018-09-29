/***
 * Ex_1_2_17 使用断言检查溢出，但是逻辑还不完整
 * 比如两数相乘的时候，还可以约分一下
 * 2018年9月19日 19:54:27
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

//	化简
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
//		一正一负绝不会溢出，如果 a 是正的，只需要防止 b 也是正数，相加溢出的情况
//		如果 a 是负数，就假设 b 也是负数，避免两个负数相加向下溢出的情况
		return a > 0 ? Long.MAX_VALUE - a < b : Long.MIN_VALUE - a > b;
	}
	
	private boolean isMinusOverflow(long a, long b) {
//		负数 - 正数：有可能溢出（向下溢出）
//		正数 - 负数：有可能溢出（向上溢出）
		return a < 0 ? Long.MIN_VALUE + b > a : Long.MAX_VALUE + b < a;
	}
	
	private boolean isTimesOverflow(long a, long b) {
		return Long.MAX_VALUE * 1.0 / a < b;
	}
	
	private long numMultiply(long a, long b) {
		assert !isTimesOverflow(a, b) : "相乘溢出！";
		return a * b;
	}
	
	private long numPlus(long a, long b) {
		assert !isPlusOverflow(a, b) : "相加溢出！";
		return a + b;
	}
	
	private long numMinus(long a, long b) {
		assert !isMinusOverflow(a, b) : "相减溢出！";
		return a - b;
	}
}
