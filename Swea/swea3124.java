package a220412;

import java.util.Arrays;
import java.util.Scanner;

public class swea3124 {
	static int[] p;
	static int v, e;
	static Edge[] edgeList;

	static class Edge implements Comparable<Edge> {
		int start;
		int end;
		int weight;

		public Edge(int start, int end, int weight) {
			this.start = start;
			this.end = end;
			this.weight = weight;
		}

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int v = sc.nextInt();
			int e = sc.nextInt();

			edgeList = new Edge[e];

			for (int i = 0; i < e; i++) {
				int start = sc.nextInt();
				int end = sc.nextInt();
				int weight = sc.nextInt();
				edgeList[i] = new Edge(start, end, weight);
			}

			Arrays.sort(edgeList);

			p = new int[v + 1];

			// makeSet
			for (int i = 1; i <= v; i++)
				p[i] = i;

			// 가중치의 최대치가 int 최대치를 넘어가므로 long으로 처리
			long res = 0;

			int sel = 0;
			for (int i = 0; i < e; i++) {
				if (findSet(edgeList[i].start) != findSet(edgeList[i].end)) {
					union(edgeList[i].start, edgeList[i].end);
					res += edgeList[i].weight;
					sel++;
				}
				if (sel == v - 1)
					break;
			}
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	static int findSet(int x) {
		if (p[x] != x)
			p[x] = findSet(p[x]);
		return p[x];
	}

	static void union(int x, int y) {
		p[findSet(y)] = findSet(x);
	}
}
