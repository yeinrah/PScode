import java.util.Scanner;

public class swea11315 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			String res = "NO";
			char[][] map = new char[n][n];
			for (int i = 0; i < n; i++)
				map[i] = sc.next().toCharArray();
			// 가로 체크
			for (int i = 0; i < n; i++) {
				int cnt = 0;
				for (int j = 0; j < n; j++) {
					if (map[i][j] == 'o')
						cnt++;
					else
						cnt = 0;
					if (cnt >= 5) {
						res = "YES";
						break;
					}
				}
			}
			// 세로 체크
			for (int j = 0; j < n; j++) {
				int cnt = 0;
				for (int i = 0; i < n; i++) {
					if (map[i][j] == 'o')
						cnt++;
					else
						cnt = 0;

					if (cnt >= 5) {
						res = "YES";
						break;
					}
				}
			}
			// 대각선 체크
			// 오른쪽 아래로
			out: for (int i = 0; i < n; i++) {
				for (int j = 0; j < n; j++) {
					int cnt = 0;
					for (int k = 0; k < n - i && k < n - j; k++) {
						if (map[i + k][j + k] == 'o')
							cnt++;
						else
							cnt = 0;

						if (cnt >= 5) {
							res = "YES";
							break out;
						}
					}
				}

			}
			// 왼쪽 아래로
			out: for (int i = 0; i < n - 1; i++) {
				for (int j = n - 1; j > 0; j--) {
					int cnt = 0;
					for (int k = 0; k < n - i && k <= j; k++) {
						if (map[i + k][j - k] == 'o')
							cnt++;
						else
							cnt = 0;
						if (cnt >= 5) {
							res = "YES";
							break out;
						}
					}
				}
			}
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}
}
