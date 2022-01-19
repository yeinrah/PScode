import java.util.Scanner;

public class CodeUp1403 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];

		for (int j = 0; j < n; j++)
			nums[j] = sc.nextInt();

		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++)
				System.out.println(nums[j]);
		}
	}
}
