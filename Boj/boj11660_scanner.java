package a220428;

import java.util.Scanner;

public class boj11660_scanner {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n + 1][n + 1];
		int[][] sum = new int[n + 1][n + 1];

		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++) {
				map[i][j] = sc.nextInt();
				sum[i][j] = sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1] + map[i][j];
			}

		for (int i = 0; i < m; i++) {
			int x1 = sc.nextInt();
			int y1 = sc.nextInt();
			int x2 = sc.nextInt();
			int y2 = sc.nextInt();

			int res = sum[x2][y2] - sum[x2][y1 - 1] - sum[x1 - 1][y2] + sum[x1 - 1][y1 - 1];
			System.out.println(res);
		}
		sc.close();
	}
}
