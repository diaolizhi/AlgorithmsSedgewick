/*
 * 将一个没有左括号的式子补充完整。
 * 例如：1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) --> ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 * 一开始以为数字和运算符不可以分开存放，看了答案之后发现是可以的。
 * 因为一个运算符对应的数字总是栈顶的那两个元素。
 * 
 * 算法的思路：
 * 遇到数字就存到数值栈，遇到加减乘除就存到运算符栈。
 * 当遇到右括号时，将数字和运算符出栈，同时和 ( ) 组成一个新的字符串放进数值栈。（注意先从数值栈出来的的放在右边）
 * 以此类推。
 * */

public class Ex_1_3_09_my {

	public static void main(String[] args) {

		String str1 = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
		System.out.println(test(str1));
		
	}
	
	public static String test(String str) {

//		用来存放 +-*/ 和数字的
		LinkStack<String> ops = new LinkStack<>();
		LinkStack<String> vals = new LinkStack<>();
		
		for(int i=0; i<str.length(); i++) {
			String ch = str.substring(i, i+1);
			if(ch.equals("+") || ch.equals("-") || ch.equals("*") || ch.equals("/")) {
				ops.push(ch);
			} else if(ch.equals(")")) {
				String v = vals.pop();
				String op = ops.pop();
				v = String.format("%s %s %s %s %s", "(", vals.pop(), op, v, ")");
				vals.push(v);
			} else if(ch.equals(" ")) {
				continue;
			} else {
				vals.push(ch);
			}
		}
		
		return vals.pop();
	}

}
