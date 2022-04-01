package a220401;

import java.util.Scanner;

public class swea1226 {
	static int res;
	static int[] dx = { -1, 0, 1, 0 };
	static int[] dy = { 0, 1, 0, -1 };
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			// 테케 번호 버리기
			sc.nextInt();
			int x = 0;
			int y = 0;
			res = 0;
			map = new int[16][16];
			for (int i = 0; i < 16; i++) {
				String s = sc.next();
				for (int j = 0; j < 16; j++) {
					map[i][j] = s.charAt(j) - '0';
					if (map[i][j] == 2) {
						x = i;
						y = j;
					}
				}
			}

			move(x, y);

			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	static public void move(int x, int y) {

		for (int i = 0; i < 4; i++) {

			int newX = x + dx[i];
			int newY = y + dy[i];

			if (newX < 0 || newY < 0 || newX >= 16 || newY >= 16)
				continue;

			if (map[newX][newY] == 1)
				continue;

			if (map[newX][newY] == 3) {
				res = 1;
				return;
			}

			map[newX][newY] = 1;
			move(newX, newY);
		}
	}
}
