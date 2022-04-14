package a220414;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class boj1260 {

	static int n, m, v;
	static boolean[] visited;
	static List<Integer>[] adj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		v = sc.nextInt();
		adj = new ArrayList[n + 1];
		visited = new boolean[n + 1];
		for (int i = 0; i < n + 1; i++)
			adj[i] = new ArrayList<>();

		for (int i = 0; i < m; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			adj[st].add(ed);
			adj[ed].add(st);
		}
		
		// 갈 수 있는 노드가 여러개인 경우 숫자가 작은 순서대로 가라고 했으니 오름차순 정렬
		for (int i = 0; i < n + 1; i++)
			Collections.sort(adj[i]);

		dfs(v);
		System.out.println();
		// 같은 visited 배열을 dfs에서 이미 썼으므로 초기화
		Arrays.fill(visited, false);
		bfs();

		sc.close();
	}

	private static void bfs() {
		Queue<Integer> q = new LinkedList<>();
		q.add(v);
		visited[v] = true;

		while (!q.isEmpty()) {
			int curr = q.poll();
			System.out.print(curr + " ");
			
			for (int i = 0; i < adj[curr].size(); i++) {
				int next = adj[curr].get(i);
				
				if (visited[next])
					continue;
				
				visited[next] = true;
				q.add(next);
			}
		}
	}

	private static void dfs(int curr) {
		visited[curr] = true;
		
		System.out.print(curr + " ");
		
		for (int i = 0; i < adj[curr].size(); i++) {
			int next = adj[curr].get(i);
			
			if (visited[next])
				continue;
			
			visited[next] = true;
			dfs(next);
		}
	}
}
