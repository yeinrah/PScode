import java.util.Scanner;

public class swea1209 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int i = 1; i <= 10; i++) {
			int n = sc.nextInt();
			int[][] arr = new int[100][100];
			for (int r = 0; r < 100; r++)
				for (int c = 0; c < 100; c++)
					arr[r][c] = sc.nextInt();
			// 가로 합
			int rmax = 0;
			for (int r = 0; r < 100; r++) {
				int rsum = 0;
				for (int c = 0; c < 100; c++) {
					rsum += arr[r][c];
					rmax = Math.max(rmax, rsum);
				}
			}
			// 세로 합
			int cmax = 0;
			for (int c = 0; c < 100; c++) {
				int csum = 0;
				for (int r = 0; r < 100; r++) {
					csum += arr[r][c];
					cmax = Math.max(cmax, csum);
				}
			}
			// 우향대각선 합
			int dmax = 0;
			for (int d = 0; d < 100; d++) {
				int dsum = 0;
				dsum += arr[d][d];
				dmax = Math.max(dmax, dsum);
			}
			// 좌향대각선 합
			int dmax2 = 0;
			for (int d = 0; d < 100; d++) {
				int dsum2 = 0;
				dsum2 += arr[d][100 - 1 - d];
				dmax2 = Math.max(dmax2, dsum2);
			}
			// 4가지 max 중 최종 max 구하기
			int max = 0;
			max = Math.max(rmax, cmax);
			dmax = Math.max(dmax, dmax2);
			max = Math.max(max, dmax);
			System.out.println("#" + i + " " + max);
		}
	}
}
