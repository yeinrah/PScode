package a220411;

import java.util.Scanner;

public class swea3289 {
	static int[] p;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();

			p = new int[n + 1];
			for (int i = 1; i < n + 1; i++)
				p[i] = i;

			StringBuilder sb = new StringBuilder();

			for (int i = 0; i < m; i++) {
				int operation = sc.nextInt();
				int a = sc.nextInt();
				int b = sc.nextInt();

				if (operation == 0)
					union(a, b);
				else if (operation == 1) {
					sb.append(check(a, b));
				}
			}

			System.out.println("#" + tc + " " + sb);
		}
		sc.close();
	}

	private static int check(int a, int b) {
		if (findSet(a) == findSet(b))
			return 1;
		else
			return 0;
	}

	public static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}

	private static int findSet(int x) {
		if (p[x] == x)
			return x;
		else
			// return findSet(p[x]);
			// 위 코드는 반복이 너무 많아 시간초과
			// 아래 코드처럼 바꿔서 매번 p[x]값을 갱신해줘야 함수 콜을 줄여서 시간안에 들어옴
			return p[x] = findSet(p[x]);
	}
}
