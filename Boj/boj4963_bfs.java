package a220405;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj4963_bfs {
	
	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

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

						Queue<Pos> q = new LinkedList<>();
						q.add(new Pos(i, j));
						map[i][j] = 0;

						while (!q.isEmpty()) {
							Pos curr = q.poll();

							for (int k = 0; k < 8; k++) {
								int nr = curr.r + dr[k];
								int nc = curr.c + dc[k];

								if (nr < 0 || nr >= h || nc < 0 || nc >= w)
									continue;

								if (map[nr][nc] == 0)
									continue;

								map[nr][nc] = 0;
								q.add(new Pos(nr, nc));
							}
						}
					}
				}
			}
			System.out.println(cnt);
		}
		sc.close();
	}
}
