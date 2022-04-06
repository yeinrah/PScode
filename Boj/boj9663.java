package a220406;

import java.util.Scanner;

public class boj9663 {
	static int n, res;
	static boolean[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new boolean[n][n];
		res = 0;
		
		put(0);
		
		System.out.println(res);
		sc.close();
	}
	
	public static void put(int r) {
		if (r == n) {
			res++;
			return;
		}
		
		for (int c = 0; c < n; c++) {
			if (check(r, c)) {
				map[r][c] = true;
				put(r + 1);
				map[r][c] = false;
			}
		}
	}
	
	//static으로 안 빼주면 put(n의 n승만큼 호출)마다 새로운 int 배열을 생성하기 때문에 메모리 초과!
	static int[] dc = {-1, 0, 1};
	
	public static boolean check(int r, int c) {
		
		for (int i = 0; i < 3; i++) {
			int nr = r;
			int nc = c;
			
			while (true) {
				nr -= 1;
				nc += dc[i];
				
				if (nr < 0 || nc < 0 || nc >= n)
					break;
				if (map[nr][nc])
					return false;
			}
		}
		return true;
	}
}
