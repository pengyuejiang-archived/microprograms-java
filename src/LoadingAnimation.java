// This is the first Java program that I have written using the text-editor VIM.
// Because today I review the ASCII and I want to try to play with it.
// Created @ 26 Nov 2017
// Last updated @ 26 Nov 2017
public class LoadingAnimation {

	public static void main(String[] args) throws InterruptedException {
		while (true) {
			for (int i = 0; i < 3; i++) {
				System.out.print("*");
				Thread.sleep(1000);
			}
			System.out.print((char)0x0D);
			for (int i = 0; i < 3; i++) {
				System.out.print((char)0x20);
			}
			System.out.print((char)0x0D);
			Thread.sleep(1000);
		}
	}

}
