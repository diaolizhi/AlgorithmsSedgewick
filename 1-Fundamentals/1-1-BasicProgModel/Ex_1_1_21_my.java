import java.util.Scanner;

public class Ex_1_1_21_my {
	
	/**
	请输入行数：
	2
	Jack 67 120
	Rose 78 120
	|----------|----|----|-------|
	|Jack      |67  |120 |0.558  |
	|----------|----|----|-------|
	|Rose      |78  |120 |0.650  |
	|----------|----|----|-------|
	*/

	public static void main(String[] args) {
		
		f();
	}

	
	public static void f() {
		Scanner in = new Scanner(System.in);
		
		System.out.println("请输入行数：");
		int num = in.nextInt();
		
		String names[] = new String[num];
		int num1[] = new int[num];
		int num2[] = new int[num];

//		这里不加一句，会导致读取到的内容不对，搞不懂
		in.nextLine();
		
		for(int i=0; i<num; i++) {
			String string = in.nextLine();
			String[] strs = string.split(" ");
			
			names[i] = strs[0];
			num1[i] = Integer.parseInt(strs[1]);
			num2[i] = Integer.parseInt(strs[2]);
		}
		
		System.out.println("|----------|----|----|-------|");
		for(int i=0; i<num; i++) {
			System.out.printf("|%-10s|%-4d|%-4d|%-7.3f|\n", names[i], num1[i], num2[i], num1[i]*1.0/num2[i]);
			System.out.println("|----------|----|----|-------|");
		}
		
		in.close();
	}
}
