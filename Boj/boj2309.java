import java.util.Arrays;
import java.util.Scanner;

public class boj2309 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int sum = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			sum += arr[i];
		}
		Arrays.sort(arr);
		int ex1 = 0;
		int ex2 = 0;
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (sum - arr[j] - arr[i] == 100) {
					ex1 = j;
					ex2 = i;
					break;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			if (i == ex1 || i == ex2)
				continue;
			else
				System.out.println(arr[i]);
		}
		sc.close();
	}
}
