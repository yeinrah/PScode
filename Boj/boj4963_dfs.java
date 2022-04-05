package a220405;

import java.util.Scanner;

public class boj4963_dfs {
	static int w, h;
	static int[][] map;
	static int[] dr = { -1, -1, -1, 0, 0, 1, 1, 1 };
	static int[] dc = { -1, 0, 1, -1, 1, -1, 0, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while (true) {
			w = sc.nextInt();
			h = sc.nextInt();
			if (w == 0 && h == 0)
				break;

			map = new int[h][w];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					map[i][j] = sc.nextInt();

			int cnt = 0;
			for (int i = 0; i < h; i++) {
				for (int j = 0; j < w; j++) {
					if (map[i][j] == 1) {
						cnt++;
						dfs(i, j);
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}

	public static void dfs(int r, int c) {
		map[r][c] = 0;

		for (int i = 0; i < 8; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];

			if (nr < 0 || nr >= h || nc < 0 || nc >= w)
				continue;

			if (map[nr][nc] == 0)
				continue;

			dfs(nr, nc);
		}
	}
}
