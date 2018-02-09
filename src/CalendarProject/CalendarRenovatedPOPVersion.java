// Procedure-Oriented Programming Calendar
// Created @ 22 Aug 2017
import java.util.Scanner;

public class CalendarRenovatedPOPVersion {

	// 创建扫描仪对象，实现人机交互：
	private static Scanner scanner = new Scanner(System.in);
	// 这些变量每个方法中都要用到，是全局的：
	private static int year;
	private static int month;
	private static int day = 1;
	private static int weekIndex;
	private static boolean isLeapYear;
	private static int maxDayForMonth = 0;

	// 采集数据：
	public static void gatherData() {
		System.out.print("Please enter year number: ");
		year = scanner.nextInt();
		System.out.print("Please enter month number: ");
		month = scanner.nextInt();
	}

	public static void getTheFirstDay() {
		/*
		 * 局部分析：
		 * 1. year - 1900 + 1部分：我们以1900年为标尺，因为1900年第一天为星期一，故加一。
		 * 2. (year - 1 - 1900) / 4部分：因为每次遇到闰年，一年的第一天就要往后延一日。但是闰年自己不受影响，而是来年的第一天，故减一。
		 * 3. % 7部分：因为一周只有七天，所以以此获得标码。
		 */
		weekIndex = (year - 1900 + 1 + (year - 1 - 1900) / 4) % 7;
	}

	// 判断输入年份是否属于闰年来调整算法：
	public static void getLeapYearStatus() {
		if (year == 1900) {
			isLeapYear = false;
		}
		if (year % 4 == 0) {
			isLeapYear = true;
		}
	}

	// 通过累加的方法获得一个月的第一天是星期几：
	public static void addUpToMonth() {
		for (int i = 1; i < month; i++) {
			if (i == 2 && isLeapYear) {
				weekIndex += 29;
			} else if (i == 2 && !isLeapYear) {
				weekIndex += 28;
			} else if (i == 4 || i == 6 || i == 9 || i == 11) {
				weekIndex += 30;
			} else {
				weekIndex += 31;
			}
		}
		weekIndex %= 7;
	}

	public static void prinTable() {
		// 制作表头：
		System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat");
		for (int i = 0; i < weekIndex; i++) {
			System.out.print("\t");
		}
		getMaxDayForMonth();
		for (; day <= maxDayForMonth; weekIndex++, day++) {
			if (weekIndex % 7 == 6) {
				System.out.println(day);
			} else {
				System.out.print(day + "\t");
			}
		}
	}

	// 获得一个月份的最大日期：
	public static void getMaxDayForMonth() {
		if (month == 2 && isLeapYear) {
			maxDayForMonth = 29;
		} else if (month == 2 && !isLeapYear) {
			maxDayForMonth = 28;
		} else if (month == 4 || month == 6 || month == 9 || month == 11) {
			maxDayForMonth = 30;
		} else {
			maxDayForMonth = 31;
		}
	}

	// 主方法：调用其他所有的组件即可：
	public static void main(String[] args) {
		gatherData();
		getTheFirstDay();
		getLeapYearStatus();
		addUpToMonth();
		prinTable();
	}

}
