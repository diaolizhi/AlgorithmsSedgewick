import java.util.Arrays;

public class Ex_1_2_13 {

	public static void main(String[] args) {

		Transaction_my[] ts = new Transaction_my[5];
		
		ts[0] = new Transaction_my("张三", new Date(9, 18 ,2018), 100);
		ts[1] = new Transaction_my("李四", new Date(9, 18, 2017), 235.5);
		ts[2] = new Transaction_my("王五", new Date(6, 18, 2018), 70);
		ts[3] = new Transaction_my("赵六", new Date(9, 10, 2018), 10);
		ts[4] = new Transaction_my("小红", new Date(9, 18, 2008), 25);

		Arrays.sort(ts);

		for(int i=0; i<ts.length; i++) {
			System.out.println(ts[i]);
		}
		

	}

}
