import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main {
	public static class Node {
		int n;
		int cost;
		
		public Node(int n, int cost) {
			this.n = n;
			this.cost = cost;
		}
	}
	
	static int n, m, st, ed;
	static ArrayList<Node> list[];
	static boolean[] visited;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		
		list = new ArrayList[n + 1];
		for (int i = 0; i < n + 1; i++)
			list[i] = new ArrayList<>();
		
		int max = 0;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < m; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			max = Math.max(c, max);
			min = Math.min(c, min);
			list[a].add(new Node(b, c));
			list[b].add(new Node(a, c));
		}
		
		st = sc.nextInt();
		ed = sc.nextInt();
		int res = 0;
		while (min <= max) {
			int mid = (min + max) / 2;
			visited = new boolean[n + 1];
			
			if (bfs(mid)) {
				min = mid + 1;
				res = mid;
			}
			else {
				max = mid - 1;
			}
		}
		System.out.println(res);
		sc.close();
	}

	private static boolean bfs(int mid) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(st);
		visited[st] = true;
		
		while (!q.isEmpty()) {
			int tmp = q.poll();
			
			if (tmp == ed)
				return true;
			
			for (int i = 0; i < list[tmp].size(); i++) {
				if (list[tmp].get(i).cost >= mid && visited[list[tmp].get(i).n] == false) {
					visited[list[tmp].get(i).n] = true;
					q.offer(list[tmp].get(i).n);
				}
			}
		}
		return false;
	}
}
