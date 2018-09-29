/*
 * ��һ��û�������ŵ�ʽ�Ӳ���������
 * ���磺1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) ) --> ( ( 1 + 2 ) * ( ( 3 - 4 ) * ( 5 - 6 ) ) )
 * һ��ʼ��Ϊ���ֺ�����������Էֿ���ţ����˴�֮�����ǿ��Եġ�
 * ��Ϊһ���������Ӧ����������ջ����������Ԫ�ء�
 * 
 * �㷨��˼·��
 * �������־ʹ浽��ֵջ�������Ӽ��˳��ʹ浽�����ջ��
 * ������������ʱ�������ֺ��������ջ��ͬʱ�� ( ) ���һ���µ��ַ����Ž���ֵջ����ע���ȴ���ֵջ�����ĵķ����ұߣ�
 * �Դ����ơ�
 * */

public class Ex_1_3_09_my {

	public static void main(String[] args) {

		String str1 = "1 + 2 ) * 3 - 4 ) * 5 - 6 ) ) )";
		System.out.println(test(str1));
		
	}
	
	public static String test(String str) {

//		������� +-*/ �����ֵ�
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
