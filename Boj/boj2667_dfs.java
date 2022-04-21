package a220421;

import java.util.Arrays;
import java.util.Scanner;

public class boj2667_dfs {
	static int n, dNum;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++)
				map[i][j] = s.charAt(j) - '0';
		}

		// 맵이 0과 1로 구성되어 있으므로 단지 번호는 2부터 시작
		dNum = 2;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (!visited[i][j] && map[i][j] == 1) {
					map[i][j] = dNum;
					visited[i][j] = true;
					dfs(i, j);
					dNum++;
				}
			}
		}

		// 총 단지수 = 단지 번호 - 2
		System.out.println(dNum - 2);

		int[] arr = new int[dNum];

		for (int k = 2; k < dNum; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					if (map[i][j] == k)
						arr[k]++;

		Arrays.sort(arr);

		for (int i = 2; i < dNum; i++)
			System.out.println(arr[i]);

		sc.close();
	}

	private static void dfs(int r, int c) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= n || nc >= n)
				continue;

			if (visited[nr][nc] || map[nr][nc] == 0)
				continue;

			visited[nr][nc] = true;
			map[nr][nc] = dNum;
			dfs(nr, nc);
		}
	}
}
