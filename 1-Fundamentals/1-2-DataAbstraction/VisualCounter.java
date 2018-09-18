
public class VisualCounter {

//	�����������������ֵӦ����Ϊ�˻�ͼ����ǰ�������� / N �õ������Ͳ��ᳬ�� 1
	private int N;
//	���ֵӦ��Ҳ��Ϊ�˻�ͼ ���ڴ�ֱ���򲻳�����Χ�����ǻ���û�㶮 StdDraw ������ô�����
	private int max;

	private int count;
	private int times;
	
	public VisualCounter(int N, int max) {
		this.N = N;
		this.max = max;
		this.count = 0;
		this.times = 0;

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
		StdDraw.point(times*1.0/N, count*1.0/max+0.5);
	}

}
