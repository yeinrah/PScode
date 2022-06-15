import java.util.Scanner;

public class Main {
	static int n;
	static char[][] map, map2;
	static boolean[][] visited, visited2;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new char[n][n];
		map2 = new char[n][n];
		visited = new boolean[n][n];
		visited2 = new boolean[n][n];
		for (int i = 0; i < n; i++) {
			String s = sc.next();
			for (int j = 0; j < n; j++)
				map[i][j] = s.charAt(j);
		}
		// 적록색맹 맵 작성
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				map2[i][j] = map[i][j];
				if (map2[i][j] == 'G')
					map2[i][j] = 'R';
			}

		int cnt = 0;
		int cnt2 = 0;

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (!visited[i][j]) {
					dfs(i, j, map, visited);
					cnt++;
				}
				if (!visited2[i][j]) {
					dfs(i, j, map2, visited2);
					cnt2++;
				}
			}

		System.out.printf("%d %d", cnt, cnt2);
		sc.close();
	}

	private static void dfs(int r, int c, char[][] map, boolean[][] visited) {
		for (int d = 0; d < 4; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			if (nr < 0 || nc < 0 || nr >= n || nc >= n)
				continue;

			if (visited[nr][nc] || map[nr][nc] != map[r][c])
				continue;

			visited[nr][nc] = true;
			dfs(nr, nc, map, visited);
		}
	}
}
