import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n  = sc.nextInt();
		int prev_range = 1;
		int after_range = 1;
		int i = 1;
		while (true) {
			if (n == 1) {
				i = 0;
				break;
			}
			after_range += 6 * i;
			if (prev_range < n && n <= after_range) {
				break;
			}
			i++;
			prev_range = after_range;
		}
		System.out.println(i + 1);
		sc.close();
	}
}
