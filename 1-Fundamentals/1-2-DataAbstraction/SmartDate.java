
public class SmartDate {

	private int day;
	private int month;
	private int year;
	
//	利用这个数组可以减少日期有效性判断时的代码
	private final int[] DAYS = { 0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
	
//	private final String[] WEEKS = {"Sunday", "Monday", "TuesDay", "Wednesday", "Thursday", "Friday", "Saturday"};
	private final String[] WEEKS = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

	public SmartDate(int year, int month, int day) {
		if (isValid(year, month, day)) {
			this.day = day;
			this.month = month;
			this.year = year;
		} else {
			throw new RuntimeException("日期合适不正确！");
		}
	}

	
//	日期有效性检查
	public boolean isValid(int year, int month, int day) {

		if(year < 1) return false;
		if(month < 1 || month > 12) return false;
		if(day < 1 || day > DAYS[month]) return false;

		boolean isLeapYear = isLeapYear(year);
		
		if(month == 2 && !isLeapYear && day > 28) {
			return false;
		} else if (month == 2 && isLeapYear && day > 29) {
			return false;
		}
		
		return true;
	}

	private boolean isLeapYear(int year) {
		return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) ;
	}
	
	
	@Override
	public String toString() {
		return this.year + "/" + this.month + "/" + this.day;
	}
	
	/**
	 * Ex_1_2_12
	 * 这里是慢慢从 1970 年开始，算出今天是星期几。
	 * 写完之后才知道有“泽勒一致性”这个东西，但是懒得看了。
	 * @return
	 */
	public String dayOfTheWeek() {
		if(this.year < 1970) {
			throw new RuntimeException("1970 年前的日期没有计算！");
		}

		int days = 0;
		int years = this.year - 1970;
		
		for(int i=0; i<years; i++) {
			if(isLeapYear(1970 + i)) {
				days += 366;
			} else {
				days += 365;
			}
		}

		switch (this.month) {
		case 12:
			days += DAYS[11];
		case 11:
			days += DAYS[10];
		case 10:
			days += DAYS[9];
		case 9:
			days += DAYS[8];
		case 8:
			days += DAYS[7];
		case 7:
			days += DAYS[6];
		case 6:
			days += DAYS[5];
		case 5:
			days += DAYS[4];
		case 4:
			days += DAYS[3];
		default:
			break;
		}
		
		if (this.month > 2) {
			if (isLeapYear(this.year)) {
				days += 60;
			} else {
				days += 59;
			}
		} else if(this.month == 2) {
			days += DAYS[1];
		}
		
		days += this.day;
		
		int num = (days + 3) % 7;
		
		return WEEKS[num];
		
	}
	
}
