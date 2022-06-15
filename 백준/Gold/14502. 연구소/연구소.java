import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pos {
		int r, c;

		public Pos(int r, int c) {
			this.r = r;
			this.c = c;
		}
	}

	static int n, m, res;
	static int[][] map;
	static int[][] tmp;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		map = new int[n][m];
		tmp = new int[n][m];

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				map[i][j] = sc.nextInt();

		res = 0;

		makeWall(0);

		System.out.println(res);
		sc.close();
	}

	// 안전구역 카운트
	private static void safezoneCnt() {
		int cnt = 0;
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (tmp[i][j] == 0)
					cnt++;

		res = Math.max(cnt, res);
	}

	// 벽 3개 세우기 - DFS
	private static void makeWall(int idx) {
		if (idx >= 3) {
			virus();
			return;
		}

		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (map[i][j] == 0) {
					map[i][j] = 1;
					makeWall(idx + 1);
					map[i][j] = 0;
				}
	}

	// 바이러스 이동 - BFS
	private static void virus() {
		// 딥카피
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				tmp[i][j] = map[i][j];
		
		Queue<Pos> q = new LinkedList<>();
		for (int i = 0; i < n; i++)
			for (int j = 0; j < m; j++)
				if (tmp[i][j] == 2)
					q.add(new Pos(i, j));

		while (!q.isEmpty()) {
			Pos curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				if (nr < 0 || nc < 0 || nr >= n || nc >= m)
					continue;

				if (tmp[nr][nc] != 0)
					continue;

				tmp[nr][nc] = 2;
				q.add(new Pos(nr, nc));
			}
		}
		safezoneCnt();		
	}
}
