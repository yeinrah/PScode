import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		for (int i = 1; i < n; i++) {
			int R = sc.nextInt() + Math.min(b, c);
			int G = sc.nextInt() + Math.min(a, c);
			int B = sc.nextInt() + Math.min(a, b);
			a = R;
			b = G;
			c = B;
		}
		System.out.println(Math.min(a, Math.min(b, c)));
		sc.close();
	}
}
