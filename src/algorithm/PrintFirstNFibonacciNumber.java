package algorithm;

import java.util.Scanner;

/**
 * Print first n fibonacci numbers
 * 
 * @author dijadhav
 *
 */
public class PrintFirstNFibonacciNumber {
	public static void main(String[] args) {

		try (Scanner sc = new Scanner(System.in)) {
			int n = sc.nextInt();
			printFibonacci(n);
		}
	}

	/**
	 * Print the first n fibonacci numbers
	 * 
	 * @param n
	 */
	private static void printFibonacci(int n) {
		int arr[] = new int[n];
		arr[0] = 0;
		arr[1] = 1;
		System.out.print(arr[0] + " " + arr[1] + " ");
		for (int i = 2; i < n; i++) {
			arr[i] = arr[i - 1] + arr[i - 2];
			System.out.print(arr[i] + " ");
		}
	}
}
