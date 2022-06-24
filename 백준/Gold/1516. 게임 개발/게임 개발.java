import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

// 참고 : https://zoonvivor.tistory.com/96
// 도움받은 부분 : 입력이 들어오는 형태를 고려했을 때 from, i 바꿔야 함
// 			   동시건설 가능 : 최대 소요 시간만 사용 -> 점화식 구성
public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] inDegree = new int[n + 1];
		int[] times = new int[n + 1];
		int[] result = new int[n + 1];
		List<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			adj[i] = new ArrayList<>();

		for (int i = 1; i <= n; i++) {
			int time = sc.nextInt();
			times[i] = time;
			int from = sc.nextInt();
			while (from != -1) {
				// 입력 상 from이 선행 건물 번호이므로 inDegree[i]를 ++ 해야한다
				inDegree[i]++;
				adj[from].add(i);
				from = sc.nextInt();
			}
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++)
			if (inDegree[i] == 0) {
				q.add(i);
				result[i] = times[i];
			}

		while (!q.isEmpty()) {
			int curr = q.poll();

			for (int i = 0; i < adj[curr].size(); i++) {
				int next = adj[curr].get(i);
				if (next != 0) {
					inDegree[next]--;
					// 동시건설이 가능하기 때문에 최대 소요시간만 사용
					result[next] = Math.max(result[next], result[curr] + times[next]);
					if (inDegree[next] == 0)
						q.add(next);
				}
			}
		}
		for (int i = 1; i < result.length; i++)
			System.out.println(result[i]);
		sc.close();
	}
}
