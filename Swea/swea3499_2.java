import java.util.Scanner;

public class swea3499_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			String res = "";
			String[] str = new String[n + 1];
			for (int i = 1; i <= n; i++)
				str[i] = sc.next();
			int idx = 1;
			int mid = n / 2 + 1;
			if (n % 2 == 1)
				mid++;
			for (int i = 1; i <= n; i++) {
				if (i % 2 == 1)
					res += str[idx++] + " ";
				else
					res += str[mid++] + " ";
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
