import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		int[] arr = new int[11];
		
		arr[1] = 1;
		arr[2] = 2;
		arr[3] = 4;
		
		for (int i = 4; i < 11; i++) {
			arr[i] = arr[i - 3] + arr[i - 2] + arr[i - 1];
		}
		
		for (int tc = 0; tc < t; tc++) {
			int n = sc.nextInt();
			System.out.println(arr[n]);
		}
		sc.close();
	}
}
