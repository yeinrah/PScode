import java.util.ArrayList;
import java.util.Scanner;

// 참고 : https://lotuslee.tistory.com/96
public class boj1949 {
	static int n;
	static int[] people;
	static int[][] dp;
	static ArrayList<Integer>[] graph;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		people = new int[n + 1];
		graph = new ArrayList[n + 1];
		dp = new int[n + 1][2];

		for (int i = 0; i <= n; i++)
			graph[i] = new ArrayList<>();

		for (int i = 0; i < n; i++)
			// 정점 번호와 인덱스를 맞춰주기 위해 i + 1
			people[i + 1] = sc.nextInt();
		
		for (int i = 0; i < n - 1; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start].add(end);
			graph[end].add(start);
		}
		
		dfs(1, 0);
		
		System.out.println(Math.max(dp[1][0], dp[1][1]));
		sc.close();
	}

	private static void dfs(int n, int parent) {
		for (int node : graph[n]) {
			if (node != parent) {
				dfs(node, n);
				dp[n][0] += Math.max(dp[node][0], dp[node][1]);
				dp[n][1] += dp[node][0];
			}
		}
		dp[n][1] += people[n];
	}
}
