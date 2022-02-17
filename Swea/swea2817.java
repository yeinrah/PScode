import java.util.Scanner;

public class swea2817 {
	static int n, k, res;
	static int[] a;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			n = sc.nextInt();
			k = sc.nextInt();
			a = new int[n];
			for (int i = 0; i < n; i++) {
				a[i] = sc.nextInt();
			}
			res = 0;
			recur(0, 0);
			System.out.println("#" + tc + " " + res);
		}
	}
	
	public static void recur(int idx, int sum) {
		if (sum == k) {
			res++;
			return;
		}
		else if (sum > k || idx >= n)
			return;
		
		recur(idx + 1, sum + a[idx]);
		recur(idx + 1, sum);
	}
}
