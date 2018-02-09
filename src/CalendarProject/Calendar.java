// 该文件由姜芃越在2017年01月16日创建于常熟。
// 说明：这个版本的万年历适用于1900年至2099年，可以通过年份和月份制表。
import java.util.Scanner;

class Calendar {

	public static void main(String[] args) {
		System.out.println("欢迎使用万年历！有效日期自1900年至2099年。");
		Scanner input = new Scanner(System.in);
		String response; // “继续进程”答复变量。
		do {
			// 代码：
			// 确认年份：
			System.out.print("请输入要查询的年份：");
			int year = input.nextInt();
			int initiate = (((year - 1900 - 1) / 4 + 1) + (year - 1900)) % 7; // 计算出一年的第一天是星期几。
			boolean leapYear = (year % 4 == 0 && year % 100 != 0 || year % 400 == 0); // 判断是否是闰年。
			// 确认月份：
			System.out.print("请输入要查询的月份：");
			int month = input.nextInt();
			// 计算日期差：
			int increase = 0;
			for (int i = 1; i < month; i++) {
				if (i == 2 && leapYear) {
					increase += 29;
				} else if (i == 2 && !leapYear) {
					increase += 28;
				} else if (i == 4 || i == 6 || i == 9 || i == 11) {
					increase += 30;
				} else {
					increase += 31;
				}
			}
			// 天数：（这段代码有点重复了，但是不知道怎么修改。）
			int day = 0;
			if (month == 2 && leapYear) {
				day = 29;
			} else if (month == 2 && !leapYear) {
				day = 28;
			} else if (month == 4 || month == 6 || month == 9 || month == 11) {
				day = 30;
			} else {
				day = 31;
			}
			// 制表：
			// 表头：
			initiate = (initiate + increase) % 7; // 计算出一个月的第一天是星期几。
			System.out.println(year + "年" + month + "月："); // 说明文字。
			System.out.println("Sun\tMon\tTue\tWed\tThu\tFri\tSat\t"); // 打印表头。
			// 第一行预设：
			for (int i = 0; i < initiate; i++) {
				System.out.print("\t");
			}
			// 表身：
			for (int i = 1; i <= day; i++) {
				initiate++; // 用来决定什么时候换行的变量。
				if (initiate % 7 == 0) { // 周六换行的判断。
					System.out.print(i + "\n");
				} else if (initiate % 7 != 0 && i == day) { // 打印完最后一日并且在适当的情况下换行的判断。
					System.out.println(i);
				} else { // 普通制表。
					System.out.print(i + "\t");
				}
			}
			// 代码结束
			System.out.print("是否继续进程？(y/n)：");
			response = input.next();
		} while (response.equals("y"));
	}

}
// 更新历史：
// 1.0.0 提供打印制定月份月历的服务。时间：2017年01月16日。
// 1.1.0 修复了制表中的换行错误。时间：2017年01月22日。
// 1.2.0 加入了循环，减少了重复装载程序的麻烦。时间：2017年01月29日。