package a220408;

import java.util.Scanner;

public class swea2115 {

	static class Honey {
		int cost;
		int r;
		int c;

		public Honey(int cost, int r, int c) {
			this.cost = cost;
			this.r = r;
			this.c = c;
		}
	}

	static int n, m, c;
	static int[][] arr;
	static Honey first, second;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			m = sc.nextInt();
			c = sc.nextInt();

			arr = new int[n][n];

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					arr[i][j] = sc.nextInt();

			first = new Honey(0, 0, 0);
			second = new Honey(0, 0, 0);

			for (int i = 0; i < n; i++)
				for (int j = 0; j < n - m + 1; j++)
					harvest(i, j);

			System.out.println("#" + tc + " " + (first.cost + second.cost));
		}
		sc.close();
	}

	private static void harvest(int a, int b) {

		int max = 0;

		int[] tmp = new int[m];
		for (int i = 0; i < m; i++)
			tmp[i] = arr[a][b + i];

		// tmp는 총 m칸, 각 칸 별로 있다, 없다의 경우의 수가 있기 때문에 2의 m승 만큼의 부분집합 필요 => 1 << m
		for (int i = 0; i < (1 << m); i++) {
			int sumHoney = 0;
			int sumCost = 0;

			for (int j = 0; j < m; j++) {
				// (i & 1 << j) != 0 : i라는 부분집합 안에 값이 들어있다는 뜻
				if ((i & 1 << j) != 0) {
					sumHoney += tmp[j];
					sumCost += tmp[j] * tmp[j];
				}
			}
			if (sumHoney <= c)
				max = Math.max(max, sumCost);
		}

		if (max > first.cost) {
			// 좌표 겹치면
			if (a == first.r && b < first.c + m)
				first = new Honey(max, a, b);
			// 안 겹치면
			else {
				second = first;
				first = new Honey(max, a, b);
			}
		} else if (max > second.cost)
			// 행이 다르거나 열이 겹치지 않는다면
			if (a != first.r || b >= first.c + m)
				second = new Honey(max, a, b);
	}
}
