package a220413;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea1249 {
	static int n;
	static int[][] map, dist;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			map = new int[n][n];
			dist = new int[n][n];
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < n; j++) {
					map[i][j] = s.charAt(j) - '0';
					dist[i][j] = Integer.MAX_VALUE;
				}
			}

			Queue<Pos> q = new LinkedList<>();
			dist[0][0] = 0;
			q.add(new Pos(0, 0));

			while (!q.isEmpty()) {
				Pos curr = q.poll();

				for (int i = 0; i < 4; i++) {
					int nr = curr.r + dr[i];
					int nc = curr.c + dc[i];

					if (nr < 0 || nc < 0 || nr >= n || nc >= n)
						continue;

					if (dist[nr][nc] > dist[curr.r][curr.c] + map[nr][nc]) {
						dist[nr][nc] = dist[curr.r][curr.c] + map[nr][nc];
						q.add(new Pos(nr, nc));
					}
				}
			}
			System.out.println("#" + tc + " " + dist[n - 1][n - 1]);
		}
		sc.close();
	}
}
