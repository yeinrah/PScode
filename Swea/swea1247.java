package a220405;

import java.util.Scanner;

public class swea1247 {
	static int n, res;
	static int[] visited;
	static int[][] map, result;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			map = new int[n + 2][2];
			result = new int[n + 2][2];
			visited = new int[n + 2];
			for (int i = 0; i < n + 2; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			
			// 회사, 시작 지점
			result[0] = map[0];
			// 집, 끝 지점
			result[1] = map[1];
			res = Integer.MAX_VALUE;

			perm(2);

			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	public static void perm(int idx) {
		if (idx >= n + 2) {
			// 회사랑 처음 고객 거리
			int tmp = Math.abs(result[0][0] - result[2][0]) + Math.abs(result[0][1] - result[2][1]);
			// 고객 간 거리
			for (int i = 2; i < n + 2 - 1; i++)
				tmp += Math.abs(result[i][0] - result[i + 1][0]) + Math.abs(result[i][1] - result[i + 1][1]);
			// 마지막 고객이랑 집 거리
			tmp += Math.abs(result[n + 2 - 1][0] - result[1][0]) + Math.abs(result[n + 2 - 1][1] - result[1][1]);
			
			res = Math.min(res, tmp);
			
			return;
		}

		for (int i = 2; i < n + 2; i++) {
			if (visited[i] == 1)
				continue;

			visited[i] = 1;
			result[idx] = map[i];
			perm(idx + 1);
			visited[i] = 0;
		}
	}
}
