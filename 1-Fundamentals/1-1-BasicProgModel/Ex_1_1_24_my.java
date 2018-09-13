import java.util.Scanner;

public class Ex_1_1_24_my {
	
	public static int Euclid(int a, int b) {

//		3 / 9 = 0...3
//		小的数对大的数取余，得到的余数肯定是本身
//		下一轮 Euclid(b, r) 就相当于 Euclid(a, b)
//		如：
//		第一轮：a=18 b=240
//		第二轮：a=240 b=18
		
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
