import java.util.Scanner;

public class Main {
	static int n, res;
	static int[][] map;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		map = new int[n][n];
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
				map[r][c] = 1;
				put(r + 1);
				map[r][c] = 0;
			}
		}
	}
	
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
				if (map[nr][nc] == 1)
					return false;
			}
		}
		return true;
	}
}
