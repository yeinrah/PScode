import java.util.Scanner;

public class swea2071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int sum = 0;
			for (int j = 0; j < 10; j++) {
				sum += sc.nextInt();
			}
			sum = ((sum + 5) / 10);
			System.out.println("#" + i + " " + sum);
		}
	}
}
