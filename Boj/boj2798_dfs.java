package a220408;

import java.util.Scanner;

public class boj2798_dfs {
	static int n, m, res;
	static int[] cards, visited, result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		cards = new int[n];
		visited = new int[n];
		result = new int[n];
		res = 0;
		
		for (int i = 0; i < n; i++)
			cards[i] = sc.nextInt();
		
		sel(0);
		
		System.out.println(res);
		sc.close();
	}
	
	public static void sel(int idx) {
		if (idx >= 3) {
			int tmp = 0;
			for (int i = 0; i < n; i++)
				tmp += result[i];
			if (tmp <= m)
				res = Math.max(tmp, res);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			if (visited[i] == 1)
				continue;
			
			visited[i] = 1;
			result[idx] = cards[i];
			sel(idx + 1);
			visited[i] = 0;	
		}
	}
}
