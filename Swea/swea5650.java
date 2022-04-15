package a220415;

import java.util.Scanner;

public class swea5650 {
	static int n, res;
	static int[][] map;
	static int[] dr = { -1, 1, 0, 0 };
	static int[] dc = { 0, 0, -1, 1 };

	// 각 삼각형 블럭과 부딪혔을때 부딪힌 방향에 따라 바뀌는 방향의 배열
	static int[][] changeDirection = { 
			{ 0, 1, 2, 3 }, // 0번은 안 쓰는 배열이지만 초기화
			{ 1, 3, 0, 2 }, // 1번 하우상좌
			{ 3, 0, 1, 2 }, // 2번 우상하좌
			{ 2, 0, 3, 1 }, // 3번 좌상우하
			{ 1, 2, 3, 0 }, // 4번 하좌우상
			{ 1, 0, 3, 2 } // 5번 하상우좌
	};

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			res = 0;
			// 벽으로 둘러쌀거라 2씩 더해줌
			map = new int[n + 2][n + 2];
			for (int i = 1; i < n + 1; i++)
				for (int j = 1; j < n + 1; j++)
					map[i][j] = sc.nextInt();

			// 벽으로 감싸기
			for (int i = 0; i < n + 2; i++)
				map[0][i] = map[i][0] = map[i][n + 1] = map[n + 1][i] = 5;

			// 모든 빈칸에서
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					if (map[i][j] == 0)
						// 모든 방향으로 출발
						for (int d = 0; d < 4; d++)
							play(i, j, d);

			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	private static void play(int stR, int stC, int d) {
		int r = stR;
		int c = stC;

		int score = 0;

		while (true) {
			int nr = r + dr[d];
			int nc = c + dc[d];

			// 시작위치로 되돌아오거나 블랙홀을 만나면 게임 종료
			if ((nr == stR && nc == stC) || map[nr][nc] == -1) {
				res = Math.max(res, score);
				return;
			}

			if (map[nr][nc] > 0) {
				// 블럭을 만나면 스코어 더하고 방향 전환
				if (map[nr][nc] < 6) {
					d = changeDirection[map[nr][nc]][d];
					score++;
				}
				// 웜홀 만나면 해당 웜홀의 반대편으로 이동
				else
					out: for (int i = 1; i <= n; i++)
						for (int j = 1; j <= n; j++)
							// 좌표는 다른데 맵 상의 값이 같으면 웜홀 반대편
							if ((nr != i || nc != j) && map[i][j] == map[nr][nc]) {
								nr = i;
								nc = j;
								break out;
							}
			}
			// 좌표 갱신
			r = nr;
			c = nc;
		}
	}
}
