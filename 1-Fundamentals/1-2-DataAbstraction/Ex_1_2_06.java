
public class Ex_1_2_06 {

	public static void main(String[] args) {
		
		String s = "ACTGACG";
		String t = "TGACGAC";
		
//		ͬһ���ַ�������֮������������Ѿ�������
		if(s.length() == t.length() && s.concat(s).indexOf(t) >= 0) {
			System.out.println("��Ϊ�ػ���λ");
		} else {
			System.out.println("�ǻػ���λ");
		}

	}

}
