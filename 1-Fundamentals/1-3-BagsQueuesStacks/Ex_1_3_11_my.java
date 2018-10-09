/**
 * 将 Ex_1_3_10 得到的后序表达式求值
 * 2018年10月8日 09:03:03
 * 注意点 ：
 * LinkStack 的泛型类型直接是 Double 即可，免得多次强制转换类型。
 * 每次遇到运算符就进行一次计算，所以不用栈来保存运算符。
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
