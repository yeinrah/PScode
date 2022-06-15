import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();

		int h = (b + c) / 60;
		int m = (b + c) % 60;
		a += h;
		if (a >= 24)
			a -= 24;

		System.out.println(a + " " + m);
		sc.close();
	}
}
