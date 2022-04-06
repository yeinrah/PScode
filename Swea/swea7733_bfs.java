package a220406;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea7733_bfs {
	static class Pos {
		int r;
		int c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int[][] cheese;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };
	static int n, res;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();

			// 치즈값 중 최대값
			int maxH = -1;

			visited = new boolean[n][n];
			cheese = new int[n][n];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					cheese[i][j] = sc.nextInt();
					maxH = Math.max(maxH, cheese[i][j]);
				}
			}

			res = 1;

			for (int h = 1; h < maxH; h++) {
				for (int r = 0; r < n; r++) {
					for (int c = 0; c < n; c++) {
						if (cheese[r][c] > h)
							visited[r][c] = false;
						else
							visited[r][c] = true;
					}
				}
				bfs();
			}
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	public static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		int cnt = 0;
		
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (visited[i][j])
					continue;
				
				q.add(new Pos(i, j));
				visited[i][j] = true;
				cnt++;
				
				while (!q.isEmpty()) {
					Pos p = q.poll();
					
					for (int d = 0; d < 4; d++) {
						int nr = p.r + dr[d];
						int nc = p.c + dc[d];
						
						if (nr < 0 || nr >= n || nc < 0 || nc >= n)
							continue;
						
						if (visited[nr][nc])
							continue;
						
						visited[nr][nc] = true;
						q.add(new Pos(nr, nc));
					}
				}
			}
		}
		res = Math.max(res, cnt);		
	}
}
