package algorithm;

import java.util.Scanner;

public class RecordBreaker {

	public static void main(String args[]) {
		try (Scanner sc = new Scanner(System.in)) {
			int t = sc.nextInt();
			for (int i = 0; i < t; i++) {
				int n=sc.nextInt();
				int visitors[]=new int[n];
				for(int j=0;j<n;j++) {
					visitors[j]=sc.nextInt();
				}
				int max=visitors[0];
				int cnt=0;
				
				System.out.println("Case #" + (i + 1) + ": " + cnt);

			}
		}
	}

}
