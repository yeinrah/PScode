import java.util.Scanner;

public class Main {
	static int r, c, res;
	static char[][] map;
	static boolean[] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		r = sc.nextInt();
		c = sc.nextInt();
		// 말이 지나가는 루트별 알파벳 이용 여부를 기록할 배열
		visited = new boolean[26];
		map = new char[r][c];
		for (int i = 0; i < r; i++) {
			String s = sc.next();
			for (int j = 0; j < c; j++) {
				map[i][j] = s.charAt(j);
			}
		}

		visited[map[0][0] - 'A'] = true;
		dfs(0, 0, 1);

		System.out.println(res);
		sc.close();
	}

	private static void dfs(int i, int j, int dist) {
		for (int d = 0; d < 4; d++) {
			int nr = i + dr[d];
			int nc = j + dc[d];

			if (nr < 0 || nc < 0 || nr >= r || nc >= c)
				continue;

			if (visited[map[nr][nc] - 'A'])
				continue;

			visited[map[nr][nc] - 'A'] = true;
			dfs(nr, nc, dist + 1);
			visited[map[nr][nc] - 'A'] = false;
		}
		res = Math.max(res, dist);
	}
}
