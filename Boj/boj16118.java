package boj;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.StringTokenizer;

// 참고 : https://velog.io/@dot2__/BOJ-16118%EB%B2%88-%EB%8B%AC%EB%B9%9B%EC%97%AC%EC%9A%B0-Java
public class boj16118 {
	static class Edge implements Comparable<Edge> {
		int end, weight, dir;

		public Edge(int end, int weight) {
			this.end = end;
			this.weight = weight;
		}

		public Edge(int end, int weight, int dir) {
			this.end = end;
			this.weight = weight;
			this.dir = dir;
		}

		@Override
		public int compareTo(Edge o) {
			return Integer.compare(this.weight, o.weight);
		}
	}

	static int n, m;
	static List<Edge>[] graph;
	static int[] disFox;
	static int[][] disWolf; // 1: 홀,짝 / 2: 거리

	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		graph = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			graph[i] = new ArrayList<>();
		}

		disFox = new int[n];
		disWolf = new int[2][n];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int to = Integer.parseInt(st.nextToken()) - 1;
			int from = Integer.parseInt(st.nextToken()) - 1;
			int dis = Integer.parseInt(st.nextToken());

			graph[to].add(new Edge(from, dis * 2)); // 정수의 나눗셈 결과를 위해 *2
			graph[from].add(new Edge(to, dis * 2));
		}

		Arrays.fill(disFox, Integer.MAX_VALUE);
		Arrays.fill(disWolf[0], Integer.MAX_VALUE);
		Arrays.fill(disWolf[1], Integer.MAX_VALUE);

		findFoxPath();
		findWolfPath();

		int cnt = 0;
		for (int i = 0; i < n; i++) {
			if (disFox[i] < Integer.min(disWolf[0][i], disWolf[1][i]))
				cnt++;
		}
		System.out.println(cnt);
	}

	private static void findWolfPath() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0, 0));

		disWolf[0][0] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (disWolf[cur.dir][cur.end] < cur.weight)
				continue; // 이미 비교 값보다 작은 경우

			for (Edge nEdge : graph[cur.end]) {
				int nNode = nEdge.end;
				int nWeight = cur.weight;
				int nDir = 0;

				if (cur.dir == 0) { // 현재 홀수번째로 건넜다면
					nWeight += nEdge.weight / 2; // 속도 두배
					nDir = 1; // 다음 짝수
				} else { // 현재 짝수번째로 건넜다면
					nWeight += nEdge.weight * 2; // 속도 1/2배
					nDir = 0; // 다음 홀수
				}

				if (disWolf[nDir][nNode] > nWeight) {
					disWolf[nDir][nNode] = nWeight;
					pq.add(new Edge(nNode, nWeight, nDir));
				}
			}
		}
	}

	// 기본 다익스트라 알고리즘
	private static void findFoxPath() {
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, 0));

		disFox[0] = 0;

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();

			if (disFox[cur.end] < cur.weight)
				continue;

			for (Edge nEdge : graph[cur.end]) {
				int nNode = nEdge.end;
				int nWeight = cur.weight + nEdge.weight;

				if (disFox[nNode] > nWeight) {
					disFox[nNode] = nWeight;
					pq.add(new Edge(nNode, nWeight));
				}
			}
		}
	}
}
