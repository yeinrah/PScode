import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] steps = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			steps[i] = sc.nextInt();
		}

		int[] dp = new int[n + 1];

		dp[1] = steps[1];
		if (n >= 2)
			dp[2] = steps[1] + steps[2];
		if (n >= 3)
			dp[3] = Math.max(steps[1], steps[2]) + steps[3];
		
		for (int i = 4; i <= n; i++) {
			dp[i] = Math.max(dp[i - 2], dp[i - 3] + steps[i - 1]) + steps[i];
		}
		
		System.out.println(dp[n]);
		sc.close();
	}
}
