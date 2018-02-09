// A microprogram designed to factorize numbers.
// Created @ Changshu @ 8 Jan 2018
// Last updated @ 5 Feb 2018.
import java.util.Scanner;

class FactorizeMachine {

	public static void main(String[] args) {
		// Get user input.
		Scanner scanner = new Scanner(System.in);
		System.out.print("A positive integer that you would like to factorize: ");
		int num = scanner.nextInt();
		// This actually does all the work.
		factorize(num);
	}

	static boolean isPrime(int num) {
		// 0 and 1 are weird numbers…
		if (num == 0 && num == 1) {
			return false;
		}
		// If the number is divisible by anything between 2 and itself (!included), then it is not a prime.
		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				return false;
			}
		}
		return true;
	}

	static void factorize(int num) {
		if (num < 0) {
			System.out.println("Invalid input: Number is negative");
			return;
		}
		if (num == 0 || num == 1) {
			System.out.println(num + " is too small to factorize!");
			return;
		}
		System.out.print(num + " = ");
		for (int i = 2; i <= num; i++) {
			// If the number itself is a prime, then factorize is done.
			if (isPrime(num)) {
				System.out.println(num);
				return;
			}
			// If the number is divisible by a prime, then that prime is a factor of the number.
			if (isPrime(i) && num % i == 0) {
				System.out.print(i + " * ");
				num /= i;
				// Note that the factor may appear again, so we -- to offset the ++, therefore performing the operation once more.
				i--;
			}
		}
	}

}
