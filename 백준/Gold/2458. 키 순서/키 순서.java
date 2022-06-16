import java.util.Scanner;

// 참고 : https://subbak2.tistory.com/52
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int INF = Integer.MAX_VALUE / 2; // 2개를 더하는 부분에서 오버플로우 방지

		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				dist[i][j] = INF;

		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();

			dist[a][b] = 1; // 비교한 적이 있으면 1로 갱신
		}

		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					if (dist[i][j] > dist[i][k] + dist[k][j])
						dist[i][j] = dist[i][k] + dist[k][j];

		int res = 0;
		for (int i = 1; i <= n; i++) {
			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (dist[i][j] != INF || dist[j][i] != INF) // INF가 아니라면 비교한 적이 있다는 뜻
					cnt++;
			}
			if (cnt == n - 1) // cnt가 총 학생 수 - 1 이면 본인을 제외한 모든 학생들과 비교해봤다는 뜻
				res++;
		}
		System.out.println(res);
		sc.close();
	}
}
