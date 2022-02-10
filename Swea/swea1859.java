import java.util.Scanner;

public class swea1859 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int n = sc.nextInt();
			int[] prices = new int[n];
			for (int j = 0; j < n; j++)
				prices[j] = sc.nextInt();
			long profit = 0;
			//뒤에서부터 카운트
			int maxIdx = n - 1;
			for (int j = n - 1 - 1; j >= 0; j--) {
				if (prices[maxIdx] > prices[j])
					profit += prices[maxIdx] - prices[j];
				else if (prices[maxIdx] < prices[j])
					maxIdx = j;
			}
			System.out.println("#" + i + " " + profit);
		}
	}
}
