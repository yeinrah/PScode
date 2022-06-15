import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
	static int n;
	static boolean[] visited;
	static List<Integer>[] graph;
	static int[][] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt(); // 정점 개수 n
		dp = new int[n + 1][2];
		visited = new boolean[n + 1];
		graph = new ArrayList[n + 1];
		// 정점 번호와 인덱스를 맞추기 위해 1부터 시작
		for (int i = 1; i <= n; i++)
			graph[i] = new ArrayList<>();

		// 간선 정보를 담을 인접 리스트이기 때문에 n - 1까지
		for (int i = 0; i < n - 1; i++) {
			int start = sc.nextInt();
			int end = sc.nextInt();
			graph[start].add(end);
			graph[end].add(start);
		}

		dfs(1);
		System.out.println(Math.min(dp[1][0], dp[1][1]));
		sc.close();
	}

	private static void dfs(int num) {
		visited[num] = true;
		dp[num][0] = 0; // number 정점이 얼리어답터가 아닌 경우
		dp[num][1] = 1; // number 정점이 얼리어답터인 경우

		for (int child : graph[num]) {
			if (!visited[child]) {
				dfs(child);
				dp[num][0] += dp[child][1]; // 부모 노드가 얼리어답터가 아닌 경우, 자식이 무조건 얼리어답터여야 한다
				dp[num][1] += Math.min(dp[child][0], dp[child][1]);
			}
		}
	}
}
