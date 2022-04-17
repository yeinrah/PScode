package a220417;

import java.util.Scanner;

public class boj17070 {
	static int n, res;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				map[i][j] = sc.nextInt();

		res = 0;

		move(0, 1, 0);

		System.out.println(res);
		sc.close();
	}

	// dir 012 : 가로세로대각선
	private static void move(int r, int c, int dir) {
		if (r == n - 1 && c == n - 1 && map[r][c] != 1) {
			res++;
			return;
		}

		if (dir == 0) {
			if (isIn(r, c + 1) && map[r][c + 1] == 0)
				move(r, c + 1, 0);
			if (isIn(r + 1, c + 1) && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0)
				move(r + 1, c + 1, 2);
		}

		else if (dir == 1) {
			if (isIn(r + 1, c) && map[r + 1][c] == 0)
				move(r + 1, c, 1);
			if (isIn(r + 1, c + 1) && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0)
				move(r + 1, c + 1, 2);
		}

		else if (dir == 2) {
			if (isIn(r, c + 1) && map[r][c + 1] == 0)
				move(r, c + 1, 0);
			if (isIn(r + 1, c) && map[r + 1][c] == 0)
				move(r + 1, c, 1);
			if (isIn(r + 1, c + 1) && map[r][c + 1] == 0 && map[r + 1][c + 1] == 0 && map[r + 1][c] == 0)
				move(r + 1, c + 1, 2);
		}
	}

	private static boolean isIn(int r, int c) {
		return 0 <= r && 0 <= c && r < n && c < n;
	}
}
