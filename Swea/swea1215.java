import java.util.Scanner;

public class swea1215 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			char[][] arr = new char[8][8];
			for (int i = 0; i < 8; i++)
				arr[i] = sc.next().toCharArray();
			int res = 0;
			// 가로 체크
			for (int i = 0; i < 8; i++) {
				out: for (int j = 0; j < 8 - (n - 1); j++) {
					for (int k = 0; k <= (n - 1) / 2; k++) {
						if (arr[i][j + k] != arr[i][j + (n - 1) - k])
							continue out;
					}
					res++;
				}
			}
			// 세로 체크
			for (int j = 0; j < 8; j++) {
				out: for (int i = 0; i < 8 - (n - 1); i++) {
					for (int k = 0; k <= (n - 1) / 2; k++) {
						if (arr[i + k][j] != arr[i + (n - 1) - k][j])
							continue out;
					}
					res++;
				}
			}
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}
}