import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++)
			arr[i] = sc.nextInt();
		
		int res = 0;
		int idx = 0;
		
		for (int i = 1; i < n; i++) {
			if (arr[i - 1] >= arr[i]) {
				res = Math.max(res, arr[i - 1] - arr[idx]);
				idx = i;
			}
			else if (i == n - 1) {
				res = Math.max(res, arr[n - 1] - arr[idx]);
			}
		}
		
		System.out.println(res);
		sc.close();
	}
}
