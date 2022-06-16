import java.util.Scanner;

//참고 : https://subbak2.tistory.com/56
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int INF = Integer.MAX_VALUE / 2; // 경유 루트의 경우 2개를 더하므로 /2 하지 않으면 오버플로우

		int[][] dist = new int[n + 1][n + 1];
		for (int i = 1; i <= n; i++)
			for (int j = 1; j <= n; j++)
				dist[i][j] = INF;

		for (int i = 1; i <= m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			// 새로운 비용이 더 작으면 갱신
			if (c < dist[a][b])
				dist[a][b] = c;
		}

		// 3중 for문 순서 경유-출발-도착
		for (int k = 1; k <= n; k++)
			for (int i = 1; i <= n; i++)
				for (int j = 1; j <= n; j++)
					// 경유지를 거치는게 기존 루트보다 비용이 적으면
					// 즉, (출발-경유) + (경유-도착) < (출발-도착) 이면 갱신
					if (dist[i][k] + dist[k][j] < dist[i][j])
						dist[i][j] = dist[i][k] + dist[k][j];

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				if (i == j) // 출발지와 도착지가 같으면
					sb.append(0 + " ");
				else if (dist[i][j] == INF)
					sb.append(0 + " ");
				else
					sb.append(dist[i][j] + " ");
			}
			sb.append("\n");
		}
		System.out.println(sb);
		sc.close();
	}
}
