import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int t = Integer.parseInt(br.readLine());
		for (int tc = 0; tc < t; tc++) {

			int n = Integer.parseInt(br.readLine());

			ArrayList<Integer>[] adj = new ArrayList[n + 1];
			for (int i = 0; i <= n; i++)
				adj[i] = new ArrayList<>();

			int[] rank = new int[n];
			StringTokenizer st = new StringTokenizer(br.readLine());
			for (int i = 0; i < n; i++)
				rank[i] = Integer.parseInt(st.nextToken());

			int[] inDegree = new int[n + 1];

			// 작년 순위에 대해 인접노드 정보 생성
			// 5, 4, 3, 2, 1 ?
			// 5 - 4, 3, 2, 1
			// 4 - 3, 2, 1
			// 3 - 2, 1
			// 2 - 1
			for (int i = 0; i < n - 1; i++) {
				for (int j = i + 1; j < n; j++) {
					adj[rank[i]].add(rank[j]);
					inDegree[rank[j]]++;
				}
			}

			// 바뀐 순서쌍 Input 받기
			int c = Integer.parseInt(br.readLine());
			for (int j = 0; j < c; j++) {
				st = new StringTokenizer(br.readLine());
				Integer a = Integer.parseInt(st.nextToken());
				Integer b = Integer.parseInt(st.nextToken());
				if (adj[a].contains(b)) {
					adj[a].remove(b);
					adj[b].add(a);
					inDegree[a]++;
					inDegree[b]--;
				} else {
					adj[b].remove(a);
					adj[a].add(b);
					inDegree[b]++;
					inDegree[a]--;
				}
			}

			Queue<Integer> q = new LinkedList<Integer>();
			for (int i = 1; i <= n; i++)
				if (inDegree[i] == 0)
					q.offer(i);

			int cnt = 0;
			StringBuilder sb = new StringBuilder();
			while (!q.isEmpty()) {
				if (q.size() > 1) {
					// 순위를 정할 수 없음
					bw.write("?" + "\n");
					break;
				}
				int node = q.poll();
				sb.append(node + " ");
				cnt++;
				for (int a : adj[node]) {
					inDegree[a]--;
					if (inDegree[a] == 0) {
						q.offer(a);
					}
				}
			}
			if (cnt != n) {
				bw.write("IMPOSSIBLE" + "\n");
			} else {
				bw.write(sb.toString() + "\n");
			}
		}
		bw.flush();
	}
}