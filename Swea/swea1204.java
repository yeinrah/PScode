import java.util.Scanner;

public class swea1204 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int[] arr = new int[101];
			for (int j = 0; j < 1000; j++) {
				arr[sc.nextInt()]++;
			}
			int max = 0;
			int idx = 0;
			for (int j = 0; j < 101; j++)
				max = Math.max(arr[j], max);
			for (int j = 0; j < 101; j++) {
				if (arr[j] == max)
					idx = j;
			}
			System.out.println("#" + i + " " + idx);
		}
	}
}
