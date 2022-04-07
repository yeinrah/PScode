package a220407;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj2206 {

	static class Pos {

		int r;
		int c;
		int dist;
		int wallBreak;

		public Pos(int r, int c, int dist, int wallBreak) {
			this.r = r;
			this.c = c;
			this.dist = dist;
			this.wallBreak = wallBreak;
		}

	}

	static int n, m;
	static int[][] map;
	static boolean[][][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		visited = new boolean[n][m][2];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < m; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}

		bfs();
		
		sc.close();
	}

	public static void bfs() {
		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(0, 0, 1, 0));
		visited[0][0][0] = true;
		int res = -1;

		while (!q.isEmpty()) {
			Pos curr = q.poll();

			if (curr.r == n - 1 && curr.c == m - 1) {
				res = curr.dist;
				break;
			}

			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;

				// 길이고 방문하지 않은 곳일때
				if (map[nr][nc] == 0 && !visited[nr][nc][curr.wallBreak]) {
					visited[nr][nc][curr.wallBreak] = true;
					q.add(new Pos(nr, nc, curr.dist + 1, curr.wallBreak));
				}

				// 벽이고 부순 적이 없을 때
				if (map[nr][nc] == 1 && curr.wallBreak == 0) {
					// 부순 배열로 기록
					visited[nr][nc][1] = true;
					q.add(new Pos(nr, nc, curr.dist + 1, 1));
				}
			}
		}
		System.out.println(res);
	}
}
