import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 참고 : https://youngest-programming.tistory.com/503
public class Main {
	static class Node {
		int r;
		int c;
		int cnt;

		Node(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}

	static int n, res;
	static int landNum = 2;
	static int[][] map;
	static boolean[][] visited;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		res = Integer.MAX_VALUE;
		map = new int[n][n];
		visited = new boolean[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				if (map[i][j] == 1) // 아직 넘버링이 되지 않은 육지인 경우
					numbering(i, j);

		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++) {
				if (map[i][j] >= 2) {
					visited = new boolean[n][n];
					bfs(i, j);
				}
			}

		System.out.println(res);
		sc.close();
	}

	private static void numbering(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(i, j, 0));
		visited[i][j] = true;
		map[i][j] = landNum;

		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				if (visited[nr][nc] || map[nr][nc] == 0)
					continue;
				q.add(new Node(nr, nc, 0));
				map[nr][nc] = landNum;
				visited[nr][nc] = true;
			}
		}
		landNum++;
	}

	private static void bfs(int i, int j) {
		Queue<Node> q = new LinkedList<>();
		q.add(new Node(i, j, 0));
		int currNum = map[i][j]; // 현재 육지 번호
		visited[i][j] = true;

		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (int d = 0; d < 4; d++) {
				int nr = curr.r + dr[d];
				int nc = curr.c + dc[d];

				if (nr < 0 || nr >= n || nc < 0 || nc >= n)
					continue;
				if (visited[nr][nc] || map[nr][nc] == currNum)
					continue;
				visited[nr][nc] = true;
				if (map[nr][nc] == 0)
					q.add(new Node(nr, nc, curr.cnt + 1));
				else
					res = Math.min(res, curr.cnt);
			}
		}
	}
}
