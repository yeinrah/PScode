import java.util.Scanner;

public class swea1213 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			String p = sc.next();
			String s = sc.next();
			int res = 0;
			out : for (int i = 0; i < s.length() - p.length() + 1; i++) {
				for (int j = 0; j < p.length(); j++) {
					if (p.charAt(j) != s.charAt(i + j))
						continue out;
				}
				res++;
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
