import java.util.Scanner;

public class Ex_1_1_24_my {
	
	public static int Euclid(int a, int b) {

//		3 / 9 = 0...3
//		С�����Դ����ȡ�࣬�õ��������϶��Ǳ���
//		��һ�� Euclid(b, r) ���൱�� Euclid(a, b)
//		�磺
//		��һ�֣�a=18 b=240
//		�ڶ��֣�a=240 b=18
		
		System.out.println("a=" + a + " b=" + b);
		
		int r = a % b;
		
		if(r == 0) {
			return b;
		} else {
			return Euclid(b, r);
		}
	}

	public static void main(String[] args) {
		
		Scanner in = new Scanner(System.in);
		String line = in.nextLine();
		String nums[] = line.split(" ");

		int num1 = Integer.parseInt(nums[0]);
		int num2 = Integer.parseInt(nums[1]);
		
		System.out.println(Euclid(num1, num2));
	}

}
