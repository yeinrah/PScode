import java.util.Scanner;

public class swea2068 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 0; i < t; i++) {
			int[] arr = new int[10];
			int max = 0;
			for (int j = 0; j < 10; j++) {
				arr[j] = sc.nextInt();
			}
			for (int j = 0; j < 10; j++) {
				if (arr[j] > max)
					max = arr[j];
			}
			System.out.println("#" + (i + 1) + " " + max);
		}
	}
}
