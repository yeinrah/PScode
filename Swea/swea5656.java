package a220414;

import java.util.Scanner;

public class swea5656 {
	static int n, h, w, res;
	static int[][] map;
	static boolean[] visited;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			w = sc.nextInt();
			h = sc.nextInt();
			map = new int[h][w];
			visited = new boolean[w];
			for (int i = 0; i < h; i++)
				for (int j = 0; j < w; j++)
					map[i][j] = sc.nextInt();

			res = Integer.MAX_VALUE;
			dfs(map, n);
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	// 공을 떨어뜨려보는 모든 경우의 수를 구하는 함수
	private static void dfs(int[][] map, int idx) {
		if (idx == 0) {
			res = Math.min(res, blockCnt(map));
			return;
		}

		for (int j = 0; j < w; j++) {
			// map을 딥카피한 복사본 tmp로 조작
			int[][] tmp = new int[h][w];
			for (int r = 0; r < h; r++)
				for (int c = 0; c < w; c++)
					tmp[r][c] = map[r][c];

			//j번째 열에서 처음으로 0이 아닌 값이 나오는 행 탐색해서 해당좌표에 공 투하
			for (int i = 0; i < h; i++) {
				if (tmp[i][j] != 0) {
					boom(tmp, i, j);
					break;
				}
			}
			gravity(tmp);
			dfs(tmp, idx - 1);
		}
	}

	// 특정 좌표를 지정했을 때 폭파할 범위를 구하는 함수
	private static void boom(int[][] map, int r, int c) {
		if (r < 0 || c < 0 || r >= h || c >= w)
			return;

		// 특정 좌표의 값을 range에 저장해서 그 주위를 사방으로 range값 만큼 연쇄폭파
		int range = map[r][c];
		map[r][c] = 0;
		for (int i = 1; i < range; i++) {
			boom(map, r, c + i);
			boom(map, r, c - i);
			boom(map, r + i, c);
			boom(map, r - i, c);
		}
	}

	// 현재 맵에 남아있는 블럭의 수 세는 함수
	private static int blockCnt(int[][] map) {
		int cnt = 0;
		for (int i = 0; i < h; i++)
			for (int j = 0; j < w; j++)
				if (map[i][j] != 0)
					cnt++;
		return cnt;
	}

	// 블럭들 아래로 정렬하는 함수
	private static void gravity(int[][] map) {
		// 맨 아랫줄부터 탐색
		for (int i = h - 1; i >= 0; i--)
			// 모든 줄을 왼쪽부터 탐색하며
			for (int j = 0; j < w; j++)
				// 비어있는 줄이 있으면
				if (map[i][j] == 0)
					// 해당 줄에서 k만큼 올라가보며
					for (int k = i; k >= 0; k--)
						// 비어있는 줄이랑 값이 있는 줄이랑 swap
						if (map[k][j] != 0) {
							map[i][j] = map[k][j];
							map[k][j] = 0;
							break;
						}
	}
}