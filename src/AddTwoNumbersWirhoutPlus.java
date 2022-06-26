
public class AddTwoNumbersWirhoutPlus {
	public static void main(String[] args) {
		int a = 5;
		int b = 6;
		System.out.println(Add(a, b));
	}

	static int Add(int x, int y) {
		if (y == 0)
			return x;
		else
			return Add(x ^ y, (x & y) << 1);
	}

}
