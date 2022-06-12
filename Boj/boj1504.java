package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

// 참고 : https://steady-coding.tistory.com/82
public class boj1504 {
	static class Edge implements Comparable<Edge> {
		int to;
		int w;

		public Edge(int to, int w) {
			this.to = to;
			this.w = w;
		}

		@Override
		public int compareTo(Edge e) {
			return w - e.w;
		}
	}

	static int n, e;
	static List<Edge>[] adj;
	static int[] dist;
	static boolean[] visited;
	static final int INF = 200000000; // 간선 최대 갯수 200000 * 가중치 최댓값 1000

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		e = sc.nextInt();

		adj = new ArrayList[n + 1];
		for (int i = 1; i < n + 1; i++)
			adj[i] = new ArrayList<>();

		dist = new int[n + 1];
		visited = new boolean[n + 1];

		Arrays.fill(dist, INF);

		for (int i = 0; i < e; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int weight = sc.nextInt();

			adj[st].add(new Edge(ed, weight));
			adj[ed].add(new Edge(st, weight));
		}

		int v1 = sc.nextInt();
		int v2 = sc.nextInt();

		int res1 = 0;
		res1 += dijkstra(1, v1);
		res1 += dijkstra(v1, v2);
		res1 += dijkstra(v2, n);

		int res2 = 0;
		res2 += dijkstra(1, v2);
		res2 += dijkstra(v2, v1);
		res2 += dijkstra(v1, n);

		int res = (res1 >= INF && res2 >= INF) ? -1 : Math.min(res1, res2);

		System.out.println(res);
		sc.close();
	}

	private static int dijkstra(int st, int ed) {
		Arrays.fill(dist, INF);
		Arrays.fill(visited, false);

		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.offer(new Edge(st, 0));
		dist[st] = 0;

		while (!pq.isEmpty()) {
			Edge curEdge = pq.poll();
			int curr = curEdge.to;

			if (!visited[curr]) {
				visited[curr] = true;

				for (Edge e : adj[curr]) {
					if (!visited[e.to] && dist[e.to] > dist[curr] + e.w) {
						dist[e.to] = dist[curr] + e.w;
						pq.add(new Edge(e.to, dist[e.to]));
					}
				}
			}
		}
		return dist[ed];
	}
}
