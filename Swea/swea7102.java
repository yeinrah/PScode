import java.util.Scanner;

public class swea7102 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] arr = new int[n + m + 1];
			String res = "";

			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= m; j++)
					arr[i + j]++;

			int max = 0;

			for (int i = 1; i < n + m + 1; i++)
				max = Math.max(max, arr[i]);

			for (int i = 1; i < n + m + 1; i++)
				if (arr[i] == max)
					res += " " + Integer.valueOf(i);
			System.out.println("#" + tc + res);
		}
	}
}
