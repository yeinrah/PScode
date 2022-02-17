import java.util.Scanner;

public class swea1860 {
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
			// 단위 시간 구간 별 손님수 카운트할 배열 (11111은 손님 도착 시간 최대치)
			int[] cnt = new int[11111 / m + 1];
			// 단위 시간 구간 별 재고 배열
			int[] stock = new int[11111 / m + 1];
			for (int i = 0; i < n; i++) {
				c[i] = sc.nextInt();
				// (손님의 도착 시간 / 단위 시간) 을 인덱스로 카운트 배열에 구간당 손님수 기록
				cnt[(c[i] / m)]++; 
			}
			for (int i = 1; i <= (11111 / m); i++) {
				// 단위시간 당 빵 생산량 - 손님수 + 이전 구간 재고
				stock[i] = k - cnt[i] + stock[i - 1];
			}

			for (int i = 1; i <= (11111 / m); i++) {
				// 첫 생산 시간보다 빨리온 손님이 있으면 불가능
				if (cnt[0] > 0) {
					res = "Impossible";
					break;
				}
				// 구간당 손님이 해당 시간 재고보다 많으면 불가능
				else if (stock[i] < 0) {
					res = "Impossible";
					break;
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
