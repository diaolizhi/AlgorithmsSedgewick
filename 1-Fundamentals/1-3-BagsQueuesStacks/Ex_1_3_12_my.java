
public class Ex_1_3_12_my {

	public static void main(String[] args) {

		LinkStack<String> stack1 = new LinkStack<>();
		stack1.push("ZhangSan");
		stack1.push("LiSi");
		stack1.push("WangWu");
		stack1.push("ZhaoLiu");
		stack1.push("XiaoMing");

		LinkStack<String> stack2 = new LinkStack<>();
		
		stack2 = LinkStack.copy(stack1);
		
		stack1.display();
		stack2.display();
		
	}

}
