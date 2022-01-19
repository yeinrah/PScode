import java.util.Scanner;

public class CodeUp1402 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] nums = new int[n];
		int tmp = 0;
		
		for (int i = 0; i < n; i++) {
			nums[i] = sc.nextInt();
		}
		for (int i = 0; i < n / 2; i++) {
			tmp = nums[i];
			nums[i] = nums[n - 1 - i];
			nums[n - 1 - i] = tmp;
		}
		for (int i : nums)
			System.out.println(i);
	}
}
