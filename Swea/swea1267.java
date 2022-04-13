package a220413;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea1267 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			int[] inDegree = new int[v + 1];
			int[][] adj = new int[v + 1][v + 1];

			for (int i = 0; i < e; i++) {
				int st = sc.nextInt();
				int ed = sc.nextInt();
				inDegree[ed]++;
				adj[st][ed]++;
			}

			StringBuilder sb = new StringBuilder();

			Queue<Integer> q = new LinkedList<>();
			for (int i = 1; i <= v; i++)
				if (inDegree[i] == 0)
					q.add(i);

			while (!q.isEmpty()) {
				int curr = q.poll();
				sb.append(curr + " ");

				for (int i = 1; i <= v; i++) {
					if (adj[curr][i] != 0) {
						inDegree[i]--;
						if (inDegree[i] == 0)
							q.add(i);
					}
				}
			}
			System.out.println("#" + tc + " " + sb);
		}
		sc.close();
	}
}
