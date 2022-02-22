import java.util.Scanner;

public class boj1592 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int l = sc.nextInt();
		int[] person = new int[n + 1];
		int i = 1;
		int res = 0;
		out : while (true) {
			person[i]++;
			// 아무나 공을 받은 횟수가 m에 도달하면 루프 종료
			for (int j = 1; j <= n; j++)
				if (person[j] == m)
					break out;
			// 공을 받은 횟수가 홀수면 시계 방향(즉, i++)
			if (person[i] % 2 == 1) {
				if (i + l > n)
					i += l - n;
				else
					i += l;
			}
			// 공을 받은 횟수가 짝수면 반시계 방향(즉, i--)
			else{
				if (i - l < 1)
					i += n - l;
				else
					i -= l;
			}
			// 총 던진 횟수++
			res++;
		}
		System.out.println(res);
	}
}
