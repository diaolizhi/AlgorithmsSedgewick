/**
 * Ex_1_3_14 ResizingArrayQueueOfStrings
 * ʹ�������ʾ���У�1 ��Ԫ�ش����ͷ����Ӳ����������벿�ֽ���
 * ���Ӳ���Ҫ�ƶ�����Ԫ��
 * ��������֮�󣬻��Զ����䣬���������������ʱ�����鲻�����̡�
 * û��ʹ��ѭ�����С�
 * 2018��10��9�� 18:02:15
 * @author dlz
 *
 */

public class Ex_1_3_14_my {

//	�������
	private int cap = 1;

//	�����е�Ԫ������
	private int size = 0;
	
	private String queue[] = new String[cap+1];

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}
	
	public String peek() {
		if(isEmpty()) {
			return null;
		} else {
			return queue[1];
		}
	}

//	����
	public String dequeue() {
		if(isEmpty()) {
			return null;
		} else {
			String first = queue[1];
			for(int j=1; j<size; j++) {
				queue[j] = queue[j+1];
			}
			size--;
			return first;
		}
	}
	
//	���
	public void enqueue(String string) {
//		����������Ԫ�ظ����������������˵���Ѿ����ˣ���Ҫ��������
		if(cap == size) {
			ResetSize();
		}
		queue[++size] = string;
	}
	
//	�������ö��д�С
	private void ResetSize() {
		String[] newQueue = new String[cap * 2 + 1];
		for(int j=1; j<=size; j++) {
			newQueue[j] = queue[j];
		}
		queue = newQueue;
		for(int k=0; k<queue.length; k++) {
			System.out.print(queue[k] + " ");
		}
		System.out.println();
		cap *= 2;
	}
	
	public static void main(String[] args) {
		Ex_1_3_14_my queue = new Ex_1_3_14_my();
		queue.enqueue("ZhangSan");
		queue.enqueue("LiSi");
		queue.enqueue("WangWu");
		queue.enqueue("ZhaoLiu");
		System.out.println("Current size: " + queue.size);
		System.out.println("Current cap: " + queue.cap);
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());
		
		queue.enqueue("XiaoMing");
		System.out.println(queue.dequeue());
	}
	
}
