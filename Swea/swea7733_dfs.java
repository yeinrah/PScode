package a220406;

import java.util.Scanner;

public class swea7733_dfs {
	static int[][] cheese;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	static int n;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			
			// 치즈값 중 최대값
			int maxH = -1;
			cheese = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cheese[i][j] = sc.nextInt();
					maxH = Math.max(maxH, cheese[i][j]);
				}
			}
			
			int res = 1;
			
			for (int h = 1; h < maxH; h++) {
				visited = new boolean[n][n];
				int cnt = 0;
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						if (!visited[r][c] && cheese[r][c] > h) {
							cnt++;
							dfs(r, c, h);
						}
					}
				}
				res = Math.max(cnt, res);
			}
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}
	
	public static void dfs(int r, int c, int h) {
		visited[r][c] = true;
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nr >= n || nc < 0 || nc >= n)
				continue;
			
			if (visited[nr][nc] || cheese[nr][nc] <= h)
				continue;
			
			dfs(nr, nc, h);			
		}
	}
}
