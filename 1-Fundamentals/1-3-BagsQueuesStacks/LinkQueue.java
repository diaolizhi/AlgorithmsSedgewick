import java.util.Iterator;

/***
 * 基于链表实现的队列
 * 
 * 方法：
 * 		enqueue(Item item) 入队
 * 		dequeue() 出队
 * 		isEmpty() 是否为空
 * 		size() 队列的大小
 * 		peek() 返回队头元素
 * 		toString() 将队列转为字符串
 * 		iterator() 可迭代
 *
 * 思路：
 * 		队列由多个节点组成，每个节点有两个成员变量：数据域、下一个节点的引用。
 * 		first 指向队头，tail 指向队尾。
 * 		多种情况：
 * 				1、初始化。first、tail 都为 null。
 * 				2、第一个元素入队。如果 first、tail 都为 null，那么插入元素时，first、tail 均指向该元素。
 * 				3、一般情况下出队。first = first.next。
 * 				4、一般情况下入队。tail.next = node，tail = node。
 * 				5、最后一个元素出队。如果 first == tail (两者指向同一个节点) first = tail = null。
 * 
 * @author dlz
 *
 * @param <Item>
 */

public class LinkQueue<Item> implements Iterable<Item>{

	private Node first;
	private Node tail;
	private int N;
	
	private class Node {
		private Item item;
		private Node next;
	}

	public LinkQueue() {
		first = null;
		tail = null;
		N = 0;
	}
	
	public boolean isEmpty() {
			return N == 0l;
	}
	
	public int size() {
		return N;
	}
	
	public void enqueue(Item item) {
		Node newNode = new Node();
		newNode.item = item;
		
		if(isEmpty()) {
			first = tail = newNode;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		
		N++;
	}
	
	public Item dequeue() {

		if(isEmpty()) {
			return null;
		}
		
		if(first == tail) {
			Item item = first.item;
			first = tail = null;
			N--;
			return item;
		} else {
			Item item = first.item;
			first = first.next;
			N--;
			return item;
		}
	}
	
	@Override
	public String toString() {
		Node temp = first;
		String res = new String();
		while(temp != null) {
			res += temp.item;
			res += " -> ";
			temp = temp.next;
		}
		res = res.substring(0, res.length() - 4);
		return res;
	}

	@Override
	public Iterator<Item> iterator() {
		return new queueIterator();
	}
	
	private class queueIterator implements Iterator<Item> {

		private Node temp = first;
		
		@Override
		public boolean hasNext() {
			return temp != null;
		}

		@Override
		public Item next() {
			Item item = temp.item;
			temp = temp.next;
			return item;
		}
		
	}
	
public static void main(String[] args) {
		
		LinkQueue<String> queue = new LinkQueue<>();
		queue.enqueue("ZhangSan");
		queue.enqueue("LiSi");
		queue.enqueue("WangWu");
		
		for(String string : queue) {
			System.out.print(string + " ");
		}
		System.out.println();

		System.out.println(queue.toString());

		System.out.println("Current size: " + queue.size());
		
		System.out.println(queue.dequeue());
		System.out.println(queue.dequeue());

		System.out.println("Current size: " + queue.size());

		queue.enqueue("XiaoMing");
		System.out.println(queue.dequeue());
	}

}
