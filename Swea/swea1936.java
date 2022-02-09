import java.util.Scanner;

public class swea1936 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		String res = "";
		if (a == 1) {
			res = b == 2 ? "B" : "A";
		}
		else if (a == 2) {
			res = b == 1 ? "A" : "B";
		}
		else {
			res = b == 1 ? "B" : "A";
		}
		System.out.println(res);
	}
}
