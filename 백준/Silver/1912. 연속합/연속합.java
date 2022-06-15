import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int cur = sc.nextInt();
		int max = cur;
		for (int i = 1; i < n; i++) {
			int tmp = sc.nextInt();
			cur = Math.max(tmp, cur + tmp);
			max = Math.max(max, cur);
		}
		System.out.println(max);
		sc.close();
	}
}
