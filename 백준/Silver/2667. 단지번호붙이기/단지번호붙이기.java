import java.util.Arrays;
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

	static int n, dNum;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++) {
				map[i][j] = s.charAt(j) - '0';
			}
		}
		// 단지 번호
		dNum = 1;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (map[i][j] == 1) {
					dNum++;
					bfs(i, j);
				}
			}
		}

		int[] dNums = new int[dNum + 1];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				for (int k = 2; k <= dNum; k++)
					if (map[i][j] == k)
						dNums[k]++;

		Arrays.sort(dNums);

		System.out.println(dNum - 1);
		for (int a = 0; a < dNums.length; a++) {
			if (dNums[a] != 0)
				System.out.println(dNums[a]);
		}
		sc.close();
	}

	public static void bfs(int r, int c) {
		map[r][c] = dNum;

		Queue<Pos> q = new LinkedList<>();
		q.add(new Pos(r, c));

		while (!q.isEmpty()) {
			Pos curr = q.poll();

			for (int k = 0; k < 4; k++) {
				int nr = curr.r + dr[k];
				int nc = curr.c + dc[k];

				if (nr < 0 || nc < 0 || nr >= n || nc >= n)
					continue;

				if (map[nr][nc] != 1)
					continue;

				map[nr][nc] = dNum;
				q.add(new Pos(nr, nc));
			}
		}
	}
}
