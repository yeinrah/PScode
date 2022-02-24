import java.util.Scanner;

public class swea1961 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++)
					arr[i][j] = sc.nextInt();
			System.out.println("#" + tc);
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++)
					System.out.print(arr[n - 1 - k][0 + j]);
				System.out.print(" ");
				for (int k = 0; k < n; k++)
					System.out.print(arr[n - 1 - j][n - 1 - k]);
				System.out.print(" ");
				for (int k = 0; k < n; k++)
					System.out.print(arr[k][n - 1 - j]);
				System.out.println();
			}
		}
		sc.close();
	}
}
