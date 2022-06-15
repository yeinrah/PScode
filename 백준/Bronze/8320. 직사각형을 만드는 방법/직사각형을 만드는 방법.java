import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = n;
		for (int i = 2; i <= n / 2; i++)
			for (int j = 2; j <= n / i; j++)
				if (i * j <= n && i >= j)
					res++;
		System.out.println(res);
		sc.close();
	}
}
