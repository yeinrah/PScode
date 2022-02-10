import java.util.Scanner;

public class swea1959 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int m = sc.nextInt();
			int[] a = new int[n];
			int[] b = new int[m];
			for (int j = 0; j < n; j++)
				a[j] = sc.nextInt();
			for (int j = 0; j < m; j++)
				b[j] = sc.nextInt();
			
			int max = 0;
			if (n > m) {
				int[] tmp = new int[n - m + 1];
				for (int j = 0; j < n - m + 1; j++) {
					for (int k = 0; k < m; k++) {
						tmp[j] += a[j + k] * b[k];
					}
					max = Math.max(max, tmp[j]);
				}
			}
			else {
				int[] tmp = new int[m - n + 1];
				for (int j = 0; j < m - n + 1; j++) {
					for (int k = 0; k < n; k++) {
						tmp[j] += a[k] * b[j + k];
					}
					max = Math.max(max, tmp[j]);
				}
			}
			System.out.println("#" + i + " " + max);
		}
	}
}
