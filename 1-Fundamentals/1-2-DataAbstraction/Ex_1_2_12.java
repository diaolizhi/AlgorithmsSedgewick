
public class Ex_1_2_12 {
	
	public static void main(String[] args) {

		SmartDate smartDate = new SmartDate(2018, 9, 19);

		String week = smartDate.dayOfTheWeek();
		
		System.out.println(smartDate + " " + week);
		
	}

}
