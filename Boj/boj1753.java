package boj;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class boj1753 {
	static class Edge {
		int v;
		int w;

		public Edge(int v, int w) {
			this.v = v;
			this.w = w;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int v = sc.nextInt();
		int e = sc.nextInt();
		int k = sc.nextInt();

		List<Edge>[] adjList = new ArrayList[v + 1];
		for (int i = 1; i < v + 1; i++)
			adjList[i] = new ArrayList<>();

		int[] dist = new int[v + 1];
		boolean[] visited = new boolean[v + 1];

		for (int i = 0; i < e; i++) {
			int st = sc.nextInt();
			int ed = sc.nextInt();
			int weight = sc.nextInt();
			adjList[st].add(new Edge(ed, weight));
		}

		Arrays.fill(dist, Integer.MAX_VALUE);
		dist[k] = 0; // 시작지점의 거리는 자기 자신이므로 0

		int min = 0;
		int curr = 1;

		for (int i = 1; i <= v; i++) {
			min = Integer.MAX_VALUE;
			for (int j = 1; j <= v; j++) {
				if (!visited[j] && dist[j] < min) {
					min = dist[j];
					curr = j;
				}
			}
			visited[curr] = true;
			for (int j = 0; j < adjList[curr].size(); j++) {
				if (!visited[adjList[curr].get(j).v] && dist[adjList[curr].get(j).v] > min + adjList[curr].get(j).w) {
					dist[adjList[curr].get(j).v] = min + adjList[curr].get(j).w;
				}
			}
		}

		StringBuilder sb = new StringBuilder();
		for (int i = 1; i <= v; i++) {
			if (dist[i] == Integer.MAX_VALUE)
				sb.append("INF" + "\n");
			else
				sb.append(dist[i] + "\n");
		}
		System.out.println(sb);
		sc.close();
	}
}