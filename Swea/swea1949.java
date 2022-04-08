package a220408;

import java.util.Scanner;

public class swea1949 {
	static int n, k, max, res;
	static int[][] mountain;
	static boolean[][] visited;
	static int[] dr = {-1, 1, 0, 0};
	static int[] dc = {0, 0, -1, 1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			max = 0;
			res = 0;
			mountain = new int[n][n];
			visited = new boolean[n][n];
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					mountain[i][j] = sc.nextInt();
					max = Math.max(max, mountain[i][j]);
				}
			}
			
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					if (mountain[i][j] == max)
						go(i, j, 1, false);
				}
			}
			
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}
	
	//행열 좌표, 길이, 공사 여부(false로 시작)
	public static void go(int r, int c, int dist, boolean construct) {
		if (dist > res)
			res = dist;
		
		visited[r][c] = true;
		
		for (int i = 0; i < 4; i++) {
			int nr = r + dr[i];
			int nc = c + dc[i];
			
			if (nr < 0 || nc < 0 || nr >= n || nc >= n)
				continue;
			
			if (visited[nr][nc])
				continue;
			
			if (mountain[r][c] > mountain[nr][nc])
				go(nr, nc, dist + 1, construct);
			
			else if (!construct && mountain[r][c] > mountain[nr][nc] - k) {
				int tmp = mountain[nr][nc];
				mountain[nr][nc] = mountain[r][c] - 1;
				go(nr, nc, dist + 1, true);
				mountain[nr][nc] = tmp;
			}
		}
		visited[r][c] = false;
	}	
}
