package a220414;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj2252 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();
		int n = sc.nextInt();
		int m = sc.nextInt();
		int[] inDegree = new int[n + 1];
		// LinkedList로 구현하면 아래 탐색 부분에서 시간초과가 뜨기 때문에 ArrayList로 재구현
		List<Integer>[] adj = new ArrayList[n + 1];
		for (int i = 0; i <= n; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			inDegree[ed]++;
			adj[st].add(ed);
		}

		Queue<Integer> q = new LinkedList<>();
		for (int i = 1; i <= n; i++)
			if (inDegree[i] == 0)
				q.add(i);

		while (!q.isEmpty()) {
			int curr = q.poll();
			sb.append(curr + " ");

			for (int i = 0; i < adj[curr].size(); i++) {
				int next = adj[curr].get(i);
				if (next != 0) {
					inDegree[next]--;
					if (inDegree[next] == 0)
						q.add(next);
				}
			}
		}
		System.out.println(sb);
		sc.close();
	}
}
