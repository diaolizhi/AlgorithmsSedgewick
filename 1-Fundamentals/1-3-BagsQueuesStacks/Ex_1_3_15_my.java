
public class Ex_1_3_15_my {

	public static void main(String[] args) {
		
		String[] strings = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh"};

		LinkQueue<String> queue = new LinkQueue<>();

//		������ k ��Ԫ��
//		���蹲�� 7 ��Ԫ�أ�k = 3����ջ 4 ��֮��͵��ֵ�����������Ԫ����
//		1 2 3 4 5 6 7
		int k = 5;

		for(String string : strings) {
			queue.enqueue(string);
		}

		int size = queue.size();
		
		for(int i=0; i<size - k; i++) {
			queue.dequeue();
		}
		
		System.out.println(k + " last element: " + queue.dequeue());
	}

}
