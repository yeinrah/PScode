package a220414;

import java.util.Scanner;

public class swea4012 {
	static int n, res;
	static boolean[] visited;
	static int[][] syn;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			syn = new int[n][n];
			visited = new boolean[n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					syn[i][j] = sc.nextInt();

			res = Integer.MAX_VALUE;

			perm(0, 0);

			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	private static void perm(int idx, int cnt) {
		if (idx == n / 2) {
			int sum1 = 0;
			int sum2 = 0;
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					if (visited[i] && visited[j])
						sum1 += syn[i][j] + syn[j][i];
					else if (!visited[i] && !visited[j])
						sum2 += syn[i][j] + syn[j][i];
				}
			}
			res = Math.min(res, Math.abs(sum1 - sum2));
		}

		for (int i = cnt; i < n; i++) {
			visited[i] = true;
			perm(idx + 1, i + 1);
			visited[i] = false;
		}
	}
}
