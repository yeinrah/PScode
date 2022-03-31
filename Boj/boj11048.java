package a220331;

import java.util.Scanner;

public class boj11048 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[][] map = new int[n + 1][m + 1];
		int[][] dp = new int[n + 1][m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= m; j++) {
				// 위, 왼쪽, 왼쪽 대각선 위와 비교하며 max값 저장해나감
				dp[i][j] = Math.max(dp[i - 1][j], Math.max(dp[i][j - 1], dp[i - 1][j - 1])) + map[i][j];
			}
		}
		
		System.out.println(dp[n][m]);
		sc.close();
	}
}
