package a220411;

import java.util.Scanner;

public class swea7465 {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			// makeSet
			p = new int[n + 1];
			for (int i = 1; i <= n; i++)
				p[i] = i;

			for (int i = 0; i < m; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				union(x, y);
			}

			int res = 0;
			for (int i = 1; i <= n; i++)
				// 대표자의 갯수가 무리의 갯수
				if (p[i] == i)
					res++;

			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	public static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	public static int findSet(int x) {
		if (x == p[x])
			return x;
		else
			return findSet(p[x]);
	}
}
