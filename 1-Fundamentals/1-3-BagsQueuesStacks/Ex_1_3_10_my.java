/**
 * ������ʽתΪ������ʽ
 * ȱ����ÿ�����㶼���������Ű�Χ������
 * 2018��10��8�� 08:46:54
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
