import java.util.Scanner;

public class swea2058 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 0;
		while (n > 0) {
			res += n % 10;
			n /= 10;
		}
		System.out.println(res);
	}
}
