import java.util.Scanner;

public class boj2562 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[9];
		int max = 0;
		int idx = 0;
		for (int i = 0; i < 9; i++) {
			arr[i] = sc.nextInt();
			max = Math.max(max, arr[i]);
			if (max == arr[i])
				idx = i + 1;
		}
		System.out.println(max);
		System.out.println(idx);
		sc.close();
	}
}
