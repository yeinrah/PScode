package a220421;

import java.util.Scanner;

public class boj2468_dfs {
	static int n;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		int res = 0;
		int maxH = 0;
		map = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				map[i][j] = sc.nextInt();
				maxH = Math.max(maxH, map[i][j]);
			}

		for (int k = 0; k < maxH; k++) {
			visited = new boolean[n][n];
			int cnt = 0;
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (!visited[i][j] && map[i][j] > k) {
						visited[i][j] = true;
						dfs(i, j, k);
						cnt++;
					}
			res = Math.max(res, cnt);
		}
		System.out.println(res);
		sc.close();
	}

	private static void dfs(int r, int c, int h) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= n || nc >= n)
				continue;

			if (visited[nr][nc] || map[nr][nc] <= h)
				continue;

			visited[nr][nc] = true;
			dfs(nr, nc, h);
		}
	}
}
