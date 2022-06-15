import java.util.Scanner;

public class Main {
	static int[] arr;
	static int n, max;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		
		max = 0;
		
		perm(0);
		
		System.out.println(max);
	}
	
	public static void perm(int idx) {
		if (idx == n) {
			int tmp = 0;
			for (int i = 0; i < n - 1; i++) {
				tmp += Math.abs(arr[i] - arr[i + 1]);
			}
			max = Math.max(tmp, max);
			return;
		}
		
		for (int i = 0; i < n; i++) {
			swap(i, idx);
			perm(idx + 1);
			swap(i, idx);
		}
	}
	
	public static void swap(int a, int b) {
		int tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}
}
