import java.util.Scanner;

public class boj8958 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 0; tc < t; tc++) {
			String s = sc.next();
			int score = 0;
			int sum = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == 'O') {
					score++;
					sum += score;
				}
				else
					score = 0;
			}
			System.out.println(sum);
		}
		sc.close();
	}
}
