import java.util.Scanner;

public class swea1216 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			int res = 0;
			char[][] arr = new char[100][100];
			for (int i = 0; i < 100; i++) {
				String s = sc.next();
				arr[i] = s.toCharArray();
			}
			// 가로
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					String tmp = "";
					for (int k = 0; k < 100 - j; k++) {
						tmp += arr[i][j + k];
						if (palindrome(tmp)) {
							res = Math.max(res, tmp.length());
						}
					}
				}
			}
			// 세로
			for (int i = 0; i < 100; i++) {
				for (int j = 0; j < 100; j++) {
					String tmp = "";
					for (int k = 0; k < 100 - j; k++) {
						tmp += arr[j + k][i];
						if (palindrome(tmp)) {
							res = Math.max(res, tmp.length());
						}
					}
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}

	public static boolean palindrome(String s) {
		for (int i = 0; i < s.length() / 2; i++) {
			if (s.charAt(i) != s.charAt(s.length() - 1 - i))
				return false;
		}
		return true;
	}
}
