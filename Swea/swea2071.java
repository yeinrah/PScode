import java.util.Scanner;

public class swea2071 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int[] arr = new int[10];
			int sum = 0;
			for (int j = 0; j < 10; j++) {
				arr[i] = sc.nextInt();
				sum += arr[i];
			}
			if (sum % 10 > 4)
				sum = sum / 10 + 1;
			else
				sum /= 10;
			System.out.println("#" + i + " " + sum);
		}
	}
}
