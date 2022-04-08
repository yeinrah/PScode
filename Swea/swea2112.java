package a220408;

import java.util.Arrays;
import java.util.Scanner;

public class swea2112 {
	static int d, w, k, res;
	static int[][] film;
	static int[] a, b;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			d = sc.nextInt();
			w = sc.nextInt();
			k = sc.nextInt();

			film = new int[d][w];
			// a 약품을 사용한 배열(갈아끼울때 사용)
			a = new int[w];
			// b 약품을 사용한 배열(갈아끼울때 사용)
			b = new int[w];

			Arrays.fill(b, 1);

			for (int i = 0; i < d; i++)
				for (int j = 0; j < w; j++)
					film[i][j] = sc.nextInt();

			res = Integer.MAX_VALUE;

			qa(0, 0);

			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	// idx : 현재 확인중인 행, cnt : 약물 주입 횟수
	private static void qa(int idx, int cnt) {
		if (isOk()) {
			res = Math.min(res, cnt);
			return;
		}

		if (res < cnt)
			return;

		if (idx == d)
			return;

		// 약물 주입 x 하면서 확인
		qa(idx + 1, cnt);

		// 원상복구하기 위해 임시배열에다가 현재 확인하고 있는 행만 복사
		int[] tmp = film[idx];

		// a 주입
		film[idx] = a;
		qa(idx + 1, cnt + 1);

		// b 주입
		film[idx] = b;
		qa(idx + 1, cnt + 1);

		// 원상복구
		film[idx] = tmp;
	}

	private static boolean isOk() {
		for (int c = 0; c < w; c++) {
			boolean flag = false;
			int cnt = 1;

			for (int r = 0; r < d - 1; r++) {
				if (film[r][c] == film[r + 1][c])
					cnt++;
				else
					cnt = 1;

				if (cnt >= k) {
					flag = true;
					break;
				}
			}
			if (!flag)
				return false;
		}
		return true;
	}
}
