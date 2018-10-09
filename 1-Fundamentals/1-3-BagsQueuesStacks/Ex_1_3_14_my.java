/**
 * Ex_1_3_14 ResizingArrayQueueOfStrings
 * 使用数组表示队列，1 号元素代表队头，入队操作在数组后半部分进行
 * 出队操作要移动所有元素
 * 队列满了之后，会自动扩充，但是如果数量过少时，数组不会缩短。
 * 没有使用循环队列。
 * 2018年10月9日 18:02:15
 * @author dlz
 *
 */

public class Ex_1_3_14_my {

//	最大容量
	private int cap = 1;

//	队列中的元素数量
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

//	出队
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
	
//	入队
	public void enqueue(String string) {
//		如果队列里的元素个数等于最大容量，说明已经满了，需要扩大数组
		if(cap == size) {
			ResetSize();
		}
		queue[++size] = string;
	}
	
//	重新设置队列大小
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
