import java.util.Scanner;

public class swea1974 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int res = 1;
			// 스도쿠 입력 배열
			int[][] map = new int[9][9];
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			// 가로 검증
			for (int i = 0; i < 9; i++) {
				// 숫자 검증용 배열
				int[] test = new int[10];
				for (int k = 1; k < 10; k++)
					test[k]++;
				// 가로 숫자마다 test배열 한번씩 제거
				for (int j = 0; j < 9; j++) {
					test[map[i][j]]--;
				}
				for (int k = 0; k < 10; k++) {
					// test배열 요소가 0이 아니면 숫자가 겹쳤거나 없었던 것이므로 0
					if (test[k] != 0) {
						res = 0;
						break;
					}
				}
			}
			// 세로 검증
			for (int i = 0; i < 9; i++) {
				// 숫자 검증용 배열
				int[] test = new int[10];
				for (int k = 1; k < 10; k++)
					test[k]++;
				// 세로 숫자마다 test배열 한번씩 제거
				for (int j = 0; j < 9; j++) {
					test[map[j][i]]--;
				}
				for (int k = 0; k < 10; k++) {
					// test배열 요소가 0이 아니면 숫자가 겹쳤거나 없었던 것이므로 0
					if (test[k] != 0) {
						res = 0;
						break;
					}
				}
			}
			// 3*3 검증
			for (int rd = 0; rd <= 6; rd += 3) {
				for (int cd = 0; cd <= 6; cd += 3) {
					// 숫자 검증용 배열
					int[] test = new int[10];
					for (int k = 1; k < 10; k++)
						test[k]++;
					// 3*3 돌면서 test 배열 한번씩 제거
					for (int i = rd; i < rd + 3; i++) {
						for (int j = cd; j < cd + 3; j++) {
							test[map[i - rd][j - cd]]--;
						}
					}
					for (int k = 0; k < 10; k++) {
						// test배열 요소가 0이 아니면 숫자가 겹쳤거나 없었던 것이므로 0
						if (test[k] != 0) {
							res = 0;
							break;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
