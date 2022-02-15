import java.util.Scanner;

public class swea5432 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			String s = sc.next();
			int res = 0;
			int piece = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '(')
					piece++;
				else {
					piece--;
					if (s.charAt(i - 1) == '(')
						res += piece;
					else
						res++;
				}
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
