package a220405;

import java.util.Scanner;

public class swea1247_sumParam {
	static int n, res;
	static int[] visited;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			map = new int[n + 2][2];
			visited = new int[n + 2];
			for (int i = 0; i < n + 2; i++) {
				map[i][0] = sc.nextInt();
				map[i][1] = sc.nextInt();
			}
			
			res = Integer.MAX_VALUE;

			perm(2, 0, map[0]);

			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	public static void perm(int idx, int sum, int[] curr) {
		//Pruning, 의미없는 탐색은 실행하지 않기
		if (res < sum)
			return;		
		
		if (idx >= n + 2) {
			sum += Math.abs(curr[0] - map[1][0]) + Math.abs(curr[1] - map[1][1]);
			
			res = Math.min(res, sum);
			
			return;
		}

		for (int i = 2; i < n + 2; i++) {
			if (visited[i] == 1)
				continue;

			visited[i] = 1;
			int dist = Math.abs(curr[0] - map[i][0]) + Math.abs(curr[1] - map[i][1]);
			perm(idx + 1, sum + dist, map[i]);
			visited[i] = 0;
		}
	}
}
