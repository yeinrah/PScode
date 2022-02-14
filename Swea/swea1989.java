import java.util.Scanner;

public class swea1989 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = sc.nextInt();
		for (int i = 1; i <= tc; i++) {
			String s = sc.next();
			int res = 1;
			for (int j = 0; j < s.length() / 2; j++) {
				if (s.charAt(j) != s.charAt(s.length() - 1 - j))
					res = 0;
					break;
			}
			System.out.println("#" + i + " " + res);
		}
	}
}
