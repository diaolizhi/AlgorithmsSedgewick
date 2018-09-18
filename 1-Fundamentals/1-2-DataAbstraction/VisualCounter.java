
public class VisualCounter {

//	操作的最大次数，这个值应该是为了画图，当前操作次数 / N 得到的数就不会超过 1
	private int N;
//	这个值应该也是为了画图 ：在垂直方向不超出范围
	private int max;

	private int count;
	private int times;
	
	public VisualCounter(int N, int max) {
		this.N = N;
		this.max = max;
		this.count = 0;
		this.times = 0;

		StdDraw.setXscale(0, N);
		StdDraw.setYscale(0, 2*max);
		StdDraw.setPenRadius(0.01);
	}

//	加一
	public void increase() {
		if(!isOver()) {
			count++;
			times++;
		}
		draw();
	}
	
//	减一
	public void reduce() {
		if(!isOver()) {
			count--;
			times++;
		}
		draw();
	}
	
//	确保在范围内
	public boolean isOver() {
		if(Math.abs(count) > max) {
			return true;
		} else {
			return false;
		}
	}
	
//	随机加一或者减一
	public void random() {
		boolean value = StdRandom.bernoulli();
		if (value) {
			increase();
		} else {
			reduce();
		}
	}
	
//	画点
	public void draw() {
		StdDraw.point(times, count+max);
	}

}
