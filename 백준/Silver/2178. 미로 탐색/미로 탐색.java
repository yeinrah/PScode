import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	static class Pos {
		int r;
		int c;
		int dist;
		
		public Pos(int r, int c, int dist) {
			this.r = r;
			this.c = c;
			this.dist = dist;
		}
	}
	
	static char[][] map;
	static boolean[][] visited;
	static int[] dr = {-1, 0, 1, 0};
	static int[] dc = {0, -1, 0, 1};
	static int n, m, res;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		res = -1;
		map = new char[n][m];
		visited = new boolean[n][m];
		Pos st = new Pos(0, 0, 0);
		for (int i = 0; i < n; i++) {
			map[i] = sc.next().toCharArray();
		}
		
		Queue<Pos> q = new LinkedList<>();
		q.add(st);
		visited[st.r][st.c] = true;
		
		while (!q.isEmpty()) {
			Pos curr = q.poll();
			
			if (curr.r == n - 1 && curr.c == m - 1) {
				res = curr.dist;
				break;
			}
			
			for (int i = 0; i < 4; i++) {
				int nr = curr.r + dr[i];
				int nc = curr.c + dc[i];
				
				if (nr < 0 || nr >= n || nc < 0 || nc >= m)
					continue;
				
				if (map[nr][nc] == '0' || visited[nr][nc])
					continue;
				
				visited[nr][nc] = true;
				q.add(new Pos(nr, nc, curr.dist + 1));
				
			}
		}
		System.out.println(res + 1);
		sc.close();
	}
}
