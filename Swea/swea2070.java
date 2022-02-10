import java.util.Scanner;

public class swea2070 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int i = 1; i <= t; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			String res = "";
			if (a > b)
				res = ">";
			else if (a < b)
				res = "<";
			else
				res = "=";

			System.out.println("#" + i + " " + res);
		}
	}
}
