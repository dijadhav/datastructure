package algorithm.search;

public class NthMagicalNumber {

	public static void main(String[] args) {
		int n = 4;
		int a = 2;
		int b = 3;
		int num = 1;
		while (n > 0) {
			if (num % a == 0 || num % b == 0) 
				n--;
			num++;
		}
		System.out.println(num-1);
	}

}
