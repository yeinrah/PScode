package a220408;

import java.util.Scanner;

public class boj14889 {
	static int n, res;
	static boolean[] people;
	static int[][] arr;
	static boolean[][] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		res = Integer.MAX_VALUE;
		people = new boolean[n];
		arr = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				arr[i][j] = sc.nextInt();

		dfs(0, 0);

		System.out.println(res);
		sc.close();
	}

	private static void dfs(int idx, int cnt) {
		if (idx >= n)
			return;

		if (cnt == n / 2) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (people[i] && people[j])
						sum1 += arr[i][j];
					if (!people[i] && !people[j])
						sum2 += arr[i][j];
				}
			}
			res = Math.min(res, Math.abs(sum1 - sum2));
			return;

		}

		people[idx] = true;
		dfs(idx + 1, cnt + 1);
		people[idx] = false;
		dfs(idx + 1, cnt);
	}
}
