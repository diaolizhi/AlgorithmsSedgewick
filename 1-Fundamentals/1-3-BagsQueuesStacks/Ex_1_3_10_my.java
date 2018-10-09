/**
 * 中序表达式转为后序表达式
 * 缺陷是每个运算都必须由括号包围起来。
 * 2018年10月8日 08:46:54
 * @author dlz
 *
 */

public class Ex_1_3_10_my {

	public static void main(String[] args) {
		
		LinkStack<String> vals = new LinkStack<>();
		LinkStack<String> ops = new LinkStack<>();
		
		String string = "(1+((2+3)*(4*5)))";
		
		for(int i=0; i<string.length(); i++) {
			String s = string.substring(i, i+1);
			
			if(s.equals("("))	;
			else if(s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/")) {
				ops.push(s);
			} else if(s.equals(")")) {
				String v = vals.pop();
				String op = ops.pop();
				String val = String.format("%s %s %s", vals.pop(), v, op);
				vals.push(val);
			} else {
				vals.push(s);
			}
		}

		System.out.println(vals.pop());

//		1 2 3 + 4 5 * * +
	}

}
