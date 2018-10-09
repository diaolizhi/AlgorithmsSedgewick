/**
 * 基于链表实现的栈
 * 栈的特点是后进先出，新的元素在栈顶，出栈也是从栈顶出。
 * 栈存放的是一个个节点，每个节点存放一个对象的引用，和一个链接。
 * 这个链接指向下一个节点或者 null。
 * 栈中的 first 变量链接第一个节点。
 */

import java.util.Iterator;
import java.util.Scanner;

public class LinkStack<Item> implements Iterable<Item>{

//	栈顶元素
	private Node first;
//	栈内元素个数
	private int N;
	
//	这个内部类加了 <Item> 会有警告
	private class Node {
		private Item item;
		private Node next;
	}

//	入栈
	public void push(Item item) {
//		如果 first = null，那么这样 oldFirst 也为 null
		Node oldFirst = first;
		first = new Node();
		first.item = item;
		first.next = oldFirst;
		N++;
	}

//	出栈
	public Item pop() {
		if(isEmpty()) return null;
		Node oldFirst = first;
		first = first.next;
		N--;
		return oldFirst.item;
	}
	
//	返回栈顶元素而不弹出它
	public Item peek() {
		if(first == null) return null;
		return first.item;
	}
	
//	判断链表是否为空
	public boolean isEmpty() {
		return first == null;
	}

//	获取栈的大小
	public int size() {
		return N;
	}

//	Iterable 未实现的方法
	@Override
	public Iterator<Item> iterator() {
		return new MyIterator();
	}
	
//	自定义迭代器
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

//	测试
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
	
	public void display() {
		Node node = first;
		for(int i=0; i<N; i++) {
			System.out.print(node.item + " ");
			node = node.next;
		}
		System.out.println();
	}
	
//	Ex_1_3_12
//	接受 一个字符串的栈，并返回该栈的一个副本
	public static LinkStack<String> copy(LinkStack<String> stack) {
		LinkStack<String> newStack = new LinkStack<String>();
		String strings[] = new String[stack.size()];
		int i = 0;
//		如果出栈之后马上放入新的堆栈，那么顺序就是反过来的，所以这里先放入一个数组中。
		for(String string : stack) {
			strings[i] = string;
			i++;
		}
		for(i=stack.size()-1; i>=0; i--) {
			newStack.push(strings[i]);
		}
		return newStack;
	}


}
