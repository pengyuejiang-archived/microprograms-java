// 该文件由姜芃越在2017年02月17日创建于常熟。
// 说明：因为今天看书的时候看到了舒尔特表的练习——每天十张，但是自己做又太麻烦，于是就请我们的好朋友——计算机，帮我们完成生成表格的任务了。
import java.util.Scanner;

import java.util.Random;

public class SchulteGrid {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		Random random = new Random();
		String response;
		do {
			// 代码：
			// 设置矩阵大小：
			System.out.print("请设置矩阵边长（格）：");
			int n = input.nextInt();
			// 建立数组：
			int[] numbers = new int[n * n];
			// 赋值：
			for (int i = 0; i < n * n; i++) {
				int temp = random.nextInt(n * n) + 1; // 随机生成一个数赋给一个临时存储变量。
				for (int j = 0; j <= i; j++) { // 检查重复的代码块。
					if (temp == numbers[j]) { // 如果有重复，则：
						i--; // 作用是将i减一之后跳出这个小循环，重新运行这一个大循环。
						break; // 跳出小循环，有重复，赋值失败，得重新来。
					} else if (j == i) { // 如果前面的检查完了都没事，那么:
						numbers[i] = temp; // 将临时存储变量的值赋给数组中对应的单元。
					}
				}
			}
			// 制表：
			// 这一段之所以不跟在上面那段后面是因为小循环中把i减少了，这样的话就会出现重复输出的情况，测试的时候遇到过。
			for (int i = 0; i < n * n; i++) {
				if ((i + 1) % n == 0) { // 这是一个很简单的判断什么时候该换行的代码块。
					System.out.println(numbers[i]);
				} else {
					System.out.print(numbers[i] + "\t");
				}
			}
			// 代码结束
			System.out.print("是否继续？(y/n)：");
			response = input.next();
		} while (response.equals("y"));
		System.out.println("程序终止");
	}

}
// 更新历史：
// 1.0.0 提供自定义大小的舒尔特表生成的服务。时间：2017年02月17日。
