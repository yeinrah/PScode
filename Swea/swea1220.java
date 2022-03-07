import java.util.Scanner;

public class swea1220 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			int[][] map = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					map[i][j] = sc.nextInt();
			int res = 0;
			for (int j = 0; j < n; j++) {
				int i = 0;
				while (i < n) {
					if (map[i][j] == 1) {
						for (int k = 1; k < n - i; k++) {
							if (map[i + k][j] == 2) {
								map[i + k][j] = 0;
								res++;
								i = i + k;
								break;
							}
						}
					}
					i++;
				}
			}
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}
}
