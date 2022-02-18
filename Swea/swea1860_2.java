import java.util.Arrays;
import java.util.Scanner;

public class swea1860_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			String res = "Possible";
			// 사람 수
			int n = sc.nextInt();
			// m초마다
			int m = sc.nextInt();
			// k개의 붕어빵 완성
			int k = sc.nextInt();
			// 손님 배열
			int[] c = new int[n];
			for (int i = 0; i < n; i++)
				c[i] = sc.nextInt();

			Arrays.sort(c);
			// 첫 붕어빵 생산보다 손님이 먼저 오거나 붕어빵 생산수보다 손님수가 많으면 impossible
			for (int i = 0; i < n; i++) {
				if ((c[i] / m) * k - (i + 1) < 0) {
					res = "Impossible";
					break;
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
