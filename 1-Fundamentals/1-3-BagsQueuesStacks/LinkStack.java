/**
 * ��������ʵ�ֵ�ջ
 * ջ���ص��Ǻ���ȳ����µ�Ԫ����ջ������ջҲ�Ǵ�ջ������
 * ջ��ŵ���һ�����ڵ㣬ÿ���ڵ���һ����������ã���һ�����ӡ�
 * �������ָ����һ���ڵ���� null��
 * ջ�е� first �������ӵ�һ���ڵ㡣
 */

import java.util.Iterator;
import java.util.Scanner;

public class LinkStack<Item> implements Iterable<Item>{

//	ջ��Ԫ��
	private Node first;
//	ջ��Ԫ�ظ���
	private int N;
	
//	����ڲ������ <Item> ���о���
	private class Node {
		private Item item;
		private Node next;
	}

//	��ջ
	public void push(Item item) {
//		��� first = null����ô���� oldFirst ҲΪ null
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

//	��ջ
	public Item pop() {
		if(isEmpty()) return null;
		Node oldFirst = first;
		first = first.next;
		N--;
		return oldFirst.item;
	}
	
//	����ջ��Ԫ�ض���������
	public Item peek() {
		if(first == null) return null;
		return first.item;
	}
	
//	�ж������Ƿ�Ϊ��
	public boolean isEmpty() {
		return first == null;
	}

//	��ȡջ�Ĵ�С
	public int size() {
		return N;
	}

//	Iterable δʵ�ֵķ���
	@Override
	public Iterator<Item> iterator() {
		return new MyIterator();
	}
	
//	�Զ��������
	private class MyIterator implements Iterator<Item> {

		private Node current = first;
		
		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}
		
	}

//	����
	public static void main(String[] args) {
		
		LinkStack<String> stack = new LinkStack<String>();
		Scanner in = new Scanner(System.in);
		
		while(in.hasNext()) {
			String string = in.nextLine();
			if(string.equals("-")) {
				System.out.println(stack.pop());
			} else if(string.equals("exit")) {
				break;
			} else {
				stack.push(string);
			}
		}
		
		for (String string : stack) {
			System.out.print(string + " ");
		}
		System.out.println();
		
		in.close();
		
	}

}
