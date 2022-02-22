import java.util.Scanner;

public class swea3499 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			String res = "";
			String[] str = new String[n + 1];
			for (int i = 1; i <= n; i++)
				str[i] = sc.next();
			String[] first = new String[n + 1];
			String[] last = new String[n + 1];
			int oddIdx = 1;
			int evenIdx = 1;
			if (n % 2 == 1) {
				for (int i = 1; i <= n / 2 + 1; i++)
					first[oddIdx++] = str[i];
				for (int i = n / 2 + 1 + 1; i <= n; i++)
					last[evenIdx++] = str[i];
			}
			else {
				for (int i = 1; i <= n / 2; i++)
					first[oddIdx++] = str[i];
				for (int i = n / 2 + 1; i <= n; i++)
					last[evenIdx++] = str[i];
			}
			oddIdx = 1;
			evenIdx = 1;
			for (int i = 1; i <= n; i++) {
				if (i % 2 == 1)
					res += first[oddIdx++] + " ";
				else
					res += last[evenIdx++] + " ";
			}
			System.out.println("#" + tc + " " + res);
		}
	}
}
