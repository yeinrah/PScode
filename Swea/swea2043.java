import java.util.Scanner;

public class swea2043 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int p = sc.nextInt();
		int k = sc.nextInt();
		if (p > k)
			System.out.println(p - k + 1);
		else
			System.out.println(k - p + 1);
	}
}
