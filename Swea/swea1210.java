import java.util.Scanner;

public class swea1210 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		// 좌우로 한칸씩 더 크게 만들어서 유효성 검사 생략
		int[][] map = new int[102][102];

		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			for (int i = 1; i < 101; i++)
				for (int j = 1; j < 101; j++)
					map[i][j] = sc.nextInt();

			// 입구들 찾기
			int idx = 0;
			int goal = 0;
			int[] start = new int[50]; // 기둥의 개수는 전체 길이의 절반을 넘을 수 없음
			for (int i = 1; i <= 100; i++)
				if (map[1][i] == 1) {
					// 출구가 있는 기둥의 인덱스를 goal에 저장
					if (map[100][i] == 2)
						goal = idx;
					start[idx++] = i;
				}

			// 도착지점부터 길 찾기
			for (int i = 100; i >= 1; i--) {
				// 왼쪽으로 갈림길이 있으면
				if (map[i][start[goal] - 1] == 1)
					// start 배열에서 goal보다 작은 수의 기둥으로 점프
					goal--;
				// 오른쪽으로 갈림길이 있으면
				else if (map[i][start[goal] + 1] == 1) {
					// start 배열에서 goal보다 큰 수의 기둥으로 점프
					goal++;
				}
			}
			// 맵에 칸을 하나씩 추가해줬었으니까 결과에서 다시 1 빼주기
			System.out.println("#" + tc + " " + (start[goal] - 1));
		}
	}
}
