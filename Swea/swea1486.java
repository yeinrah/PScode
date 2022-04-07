package a220407;

import java.util.Scanner;

public class swea1486 {
	static int n, b, res;
	static int[] height;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			b = sc.nextInt();
			height = new int[n];
			for (int i = 0; i < n; i++)
				height[i] = sc.nextInt();
			res = Integer.MAX_VALUE;

			perm(0, 0);

			System.out.println("#" + tc + " " + (res - b));
		}
		sc.close();
	}

	private static void perm(int idx, int sum) {

		if (idx == n) {
			if (sum >= b)
				res = Math.min(res, sum);
			return;
		}

		perm(idx + 1, sum + height[idx]);
		perm(idx + 1, sum);
	}
}
