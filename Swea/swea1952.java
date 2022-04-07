package a220407;

import java.util.Scanner;

public class swea1952 {
	static int res;
	static int[] price, plan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			// 가격 배열, 순서대로 1일 1달 3달 1년
			price = new int[4];
			// 월별 이용 일자 계획
			plan = new int[12];
			for (int i = 0; i < 4; i++)
				price[i] = sc.nextInt();
			for (int i = 0; i < 12; i++)
				plan[i] = sc.nextInt();

			// 최소비용 초기값은 1년 이용권
			res = price[3];

			dfs(0, 0);

			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}

	public static void dfs(int month, int sum) {
		
		if (sum >= res)
			return;
		
		if (month > 11) {
			res = Math.min(res, sum);
			return;
		}
		
		// 1일권
		dfs(month + 1, sum + price[0] * plan[month]);

		// 1달권
		dfs(month + 1, sum + price[1]);

		// 3달권
		dfs(month + 3, sum + price[2]);
	}
}
