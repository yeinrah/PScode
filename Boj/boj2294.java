package a220506;

import java.util.Arrays;
import java.util.Scanner;

public class boj2294 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[] coin = new int[n];
		for (int i = 0; i < n; i++)
			coin[i] = sc.nextInt();

		int[] dp = new int[k + 1];
		Arrays.fill(dp, 100001); // 동전의 최대 가치 : 100000 에다가 1 더한 값
		dp[0] = 0;

		for (int i = 0; i < n; i++)
			for (int j = coin[i]; j <= k; j++)
				dp[j] = Math.min(dp[j], dp[j - coin[i]] + 1);

		System.out.println(dp[k] == 100001 ? -1 : dp[k]);
		sc.close();
	}
}
