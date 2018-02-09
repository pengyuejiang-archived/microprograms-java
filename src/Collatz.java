// 该文件由姜芃越在2017年05月01日创建于苏州。
// 说明：这段代码是Collatz猜想的程序。Collatz猜想是一个很简单但是却又没有人能够证明的猜想。
// Collatz猜想简述：“给一个正整数，如果是偶数，则减半；如果是奇数，则变为它的三倍加一。直到变为一停止。猜想对于所有正整数经过足够多次变换最终达到一。”
// Last updated @ 7 Feb 2018
import java.util.Scanner;

class Collatz {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.print("请输入一个数字：");
		int n = input.nextInt();
		while (n != 1) {
			if (n % 2 != 0) {
				n = 3 * n + 1;
			} else {
				n /= 2;
			}
		}
		System.out.println("最终的数字是：" + n);
	}

}
// 更新历史：
// 1.0.0 模拟Collatz猜想。时间：2017年05月01。
