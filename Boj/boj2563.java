import java.util.Scanner;

public class boj2563 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[][] map = new boolean[100][100];
		int cnt = 0;
		int n = sc.nextInt();
		for (int tc = 0; tc < n; tc++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			for (int i = a; i < a + 10; i++)
				for (int j = b; j < b + 10; j++)
					map[i][j] = true;
		}
		for (int i = 0; i < 100; i++)
			for (int j = 0; j < 100; j++)
				if (map[i][j] == true)
					cnt++;
		System.out.println(cnt);
		sc.close();
	}
}
