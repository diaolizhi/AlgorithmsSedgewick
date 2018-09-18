
public class VisualCounter {

//	�����������������ֵӦ����Ϊ�˻�ͼ����ǰ�������� / N �õ������Ͳ��ᳬ�� 1
	private int N;
//	���ֵӦ��Ҳ��Ϊ�˻�ͼ ���ڴ�ֱ���򲻳�����Χ
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

//	��һ
	public void increase() {
		if(!isOver()) {
			count++;
			times++;
		}
		draw();
	}
	
//	��һ
	public void reduce() {
		if(!isOver()) {
			count--;
			times++;
		}
		draw();
	}
	
//	ȷ���ڷ�Χ��
	public boolean isOver() {
		if(Math.abs(count) > max) {
			return true;
		} else {
			return false;
		}
	}
	
//	�����һ���߼�һ
	public void random() {
		boolean value = StdRandom.bernoulli();
		if (value) {
			increase();
		} else {
			reduce();
		}
	}
	
//	����
	public void draw() {
		StdDraw.point(times, count+max);
	}

}
