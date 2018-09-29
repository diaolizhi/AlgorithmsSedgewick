
public class Ex_1_3_07_my {

	public static void main(String[] args) {

		LinkStack<String> stack = new LinkStack<>();

		System.out.println(stack.peek());
		stack.push("ZhangSan");
		stack.push("LiSi");
		System.out.println(stack.peek());
		System.out.println(stack.peek());
		System.out.println(stack.pop());

	}

}
