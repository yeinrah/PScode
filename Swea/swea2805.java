// 방법 1 : 위아래 삼각형의 합

//import java.util.Scanner;
//
//public class swea2805 {
//	public static void main(String[] args) {
//		Scanner sc = new Scanner(System.in);
//		int t = sc.nextInt();
//		for (int tc = 1; tc <= t; tc++) {
//			int n = sc.nextInt();
//			int sum = 0;
//			int[][] map = new int[n][n];
//			// 입력문에 띄어쓰기 없음!!!
//			for (int i = 0; i < n; i++) {
//				String s = sc.next();
//				for (int j = 0; j < n; j++)
//					map[i][j] = s.charAt(j) - '0';
//			}
//			// 위쪽 삼각형
//			for (int i = 0; i < (n / 2); i++)
//				for (int j = (n / 2) - i; j <= (n / 2) + i; j++)
//					sum += map[i][j];
//			// 아래쪽 삼각형
//			for (int i = (n / 2); i >= 0; i--)
//				for (int j = (n / 2) - i; j <= (n / 2) + i; j++)
//					sum += map[n - 1 - i][j];
//			System.out.println("#" + tc + " " + sum);
//		}
//	}
//}



// 방법 2 : 정중앙 좌표에서 마름모씩 더하기

import java.util.Scanner;

public class swea2805 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			int sum = 0;
			int[][] map = new int[n][n];
			// 입력문이 띄어쓰기로 구분되어 있지 않아 문자열로 받은 뒤 나눠주기
			for (int i = 0; i < n; i++) {
				String s = sc.next();
				for (int j = 0; j < n; j++)
					map[i][j] = s.charAt(j) - '0';
			}
			// 마름모 단위로 더해나간다
			for (int i = 0; i < n; i++)
				for (int j = Math.abs((n / 2) - i); j < n - Math.abs((n / 2) - i); j++)
					sum += map[i][j];
			System.out.println("#" + tc + " " + sum);
		}
	}
}

