// Created by Pengyue Jiang @Changshu @Augest 26, 2017.
// Last updated @ 6 Feb 2018
import java.util.Date;

public class Clock {

	public static void main(String[] args) {
		Date d = new Date();
		/*
		 * 思路：
		 * 1. new Date(System.currentTimeMillis())部分：每次循环创建一个新对象。
		 * 2. toString()和equals()方法组：将Date对象转化成String对象进行对比。
		 * 3. !部分：如果不同，将现在时间（虽然已经同刚才的对象不同了，但是误差基本为零）赋给当前时间。
		 */
		// This just looks better than:
		//for (;;) {
		while (true) {
			if (!new Date(System.currentTimeMillis()).toString().equals(d.toString())) {
				d = new Date(System.currentTimeMillis());
				System.out.println(d);
			}
			// I don't want my memory to blow up, no.
			System.gc();
		}
	}

}
