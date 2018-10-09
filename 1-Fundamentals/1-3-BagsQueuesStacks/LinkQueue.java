import java.util.Iterator;

/***
 * ��������ʵ�ֵĶ���
 * 
 * ������
 * 		enqueue(Item item) ���
 * 		dequeue() ����
 * 		isEmpty() �Ƿ�Ϊ��
 * 		size() ���еĴ�С
 * 		peek() ���ض�ͷԪ��
 * 		toString() ������תΪ�ַ���
 * 		iterator() �ɵ���
 *
 * ˼·��
 * 		�����ɶ���ڵ���ɣ�ÿ���ڵ���������Ա��������������һ���ڵ�����á�
 * 		first ָ���ͷ��tail ָ���β��
 * 		���������
 * 				1����ʼ����first��tail ��Ϊ null��
 * 				2����һ��Ԫ����ӡ���� first��tail ��Ϊ null����ô����Ԫ��ʱ��first��tail ��ָ���Ԫ�ء�
 * 				3��һ������³��ӡ�first = first.next��
 * 				4��һ���������ӡ�tail.next = node��tail = node��
 * 				5�����һ��Ԫ�س��ӡ���� first == tail (����ָ��ͬһ���ڵ�) first = tail = null��
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
