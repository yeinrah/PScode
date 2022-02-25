import java.util.Scanner;

public class swea1289 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			String s = sc.next();
			int change = 0;
			if (s.charAt(0) == '1')
				change++;
			for (int i = 1; i < s.length(); i++) {
				if (s.charAt(i - 1) != s.charAt(i))
					change++;
			}
			System.out.println("#" + tc + " " + change);
		}
	}
}
