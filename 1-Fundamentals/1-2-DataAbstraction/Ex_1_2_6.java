
public class Ex_1_2_6 {

	public static void main(String[] args) {
		
		String s = "ACTGACG";
		String t = "TGACGAC";
		
//		同一个字符串连接之后，所有情况都已经出现了
		if(s.length() == t.length() && s.concat(s).indexOf(t) >= 0) {
			System.out.println("互为回环变位");
		} else {
			System.out.println("非回环变位");
		}

	}

}
