
public class Ex_1_3_04_my {

	public static void main(String[] args) {

		String str1 = "[()]{}{[()()]()}";
		String str2 = "[(])";
		

		System.out.println(test(str1));
		System.out.println(test(str2));

	}

	public static boolean test(String str1) {
		LinkStack<Character> stack = new LinkStack<Character>();

		for(int i=0; i<str1.length(); i++) {
			Character ch = str1.charAt(i);
			if(ch == '[' || ch == '{' || ch == '(') {
				stack.push(ch);
			} else {
				Character ch2 = stack.pop();
//				System.out.println(ch2);
				if(ch2 == '[' && ch == ']');
				else if(ch2 == '{' && ch == '}');
				else if(ch2 == '(' && ch == ')');
				else return false;
			}
		}
		return true;
	}
}
