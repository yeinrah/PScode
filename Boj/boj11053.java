package a220506;

import java.util.Scanner;

public class boj11053 { // DP 문제이자 LIS 문제
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();

		int[] dp = new int[n];
		for (int i = 0; i < n; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++)
				if (arr[i] > arr[j] && dp[i] <= dp[j])
					dp[i] = dp[j] + 1;
		}

		int max = 0;
		for (int i = 0; i < n; i++)
			max = Math.max(max, dp[i]);

		System.out.println(max);
		sc.close();
	}
}
