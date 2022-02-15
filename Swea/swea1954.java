import java.util.Scanner;

public class swea1954 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			int i = 0;
			int j = -1;
			int num = 1;
			int cnt = n;

			while (cnt > 0) {
				for (int a = 0; a < cnt; a++)
					arr[i][++j] = num++;
				cnt--;

				for (int a = 0; a < cnt; a++)
					arr[++i][j] = num++;

				for (int a = 0; a < cnt; a++)
					arr[i][--j] = num++;
				cnt--;

				for (int a = 0; a < cnt; a++)
					arr[--i][j] = num++;
			}
			System.out.println("#" + tc);
			for (int r = 0; r < n; r++) {
				for (int c = 0; c < n; c++)
					System.out.print(arr[r][c] + " ");
				System.out.println();
			}
		}
		sc.close();
	}
}
