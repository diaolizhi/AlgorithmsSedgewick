/**
 * �� Ex_1_3_10 �õ��ĺ�����ʽ��ֵ
 * 2018��10��8�� 09:03:03
 * ע��� ��
 * LinkStack �ķ�������ֱ���� Double ���ɣ���ö��ǿ��ת�����͡�
 * ÿ������������ͽ���һ�μ��㣬���Բ���ջ�������������
 * @author dlz
 *
 */

public class Ex_1_3_11_my {

	public static void main(String[] args) {

		String str = "123+45**+";
		
		LinkStack<Double> vals = new LinkStack<>();
		
		for(int i=0; i<str.length(); i++) {
			String s = str.substring(i, i+1);
			if(s.equals("+")) {
				Double a = vals.pop();
				Double b = vals.pop();
				Double c = a + b;
				vals.push(c);
			} else if(s.equals("-")) {
				Double a = vals.pop();
				Double b = vals.pop();
				Double c = a - b;
				vals.push(c);
			} else if(s.equals("*")) {
				Double a = vals.pop();
				Double b = vals.pop();
				Double c = a * b;
				vals.push(c);
			} else if(s.equals("/")) {
				Double a = vals.pop();
				Double b = vals.pop();
				Double c = a / b;
				vals.push(c);
			} else {
				vals.push(Double.parseDouble(s));
			}
		}
		
		System.out.println(vals.pop());

	}

}
