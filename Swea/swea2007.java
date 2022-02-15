import java.util.Scanner;

public class swea2007 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			String s = sc.next();
			for (int i = 1; i <= s.length(); i++) {
				if (s.substring(0, i).equals(s.substring(i, i + i))) {
					System.out.println("#" + tc + " " + s.substring(0, i).length());
					break;
				}
			}
		}
	}
}
