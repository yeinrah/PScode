import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] train = new int[n + 1];
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			train[i] = sc.nextInt();
			sum[i] += sum[i - 1] + train[i];
		}
		// 소형 기관차가 끌 수 있는 최대 객차 수
		int carLimit = sc.nextInt();

		int[][] dp = new int[4][n + 1];
		for (int i = 1; i <= 3; i++)
			for (int j = i * carLimit; j <= n; j++)
				dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j - carLimit] + sum[j] - sum[j - carLimit]);
		
		System.out.println(dp[3][n]);
		sc.close();
	}
}
