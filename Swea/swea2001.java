import java.util.Scanner;

public class swea2001 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[][] arr = new int[n][n];
			for (int r = 0; r < n; r++)
				for (int c = 0; c < n; c++)
					arr[r][c] = sc.nextInt();
			
			int max = 0;
			for (int nr = 0; nr < n - m + 1; nr++) {
				for (int nc = 0; nc < n - m + 1; nc++) {
					int sum = 0;
					for (int mr = 0; mr < m; mr++)
						for (int mc = 0; mc < m; mc++)
							sum += arr[mr + nr][mc + nc];
					max = Math.max(max, sum);
				}
			}
			System.out.println("#" + tc + " " + max);
		}
	}
}
