
public class Ex_1_3_15_my {

	public static void main(String[] args) {
		
		String[] strings = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh"};

		LinkQueue<String> queue = new LinkQueue<>();

//		倒数第 k 个元素
//		假设共有 7 个元素，k = 3，出栈 4 次之后就到轮到倒数第三个元素了
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
