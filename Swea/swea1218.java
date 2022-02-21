import java.util.Scanner;
import java.util.Stack;

public class swea1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 1;
		int a = 0; // (
		int b = 0; // [
		int c = 0; // {
		int d = 0; // <
		for (int tc = 1; tc <= 10; tc++) {
			String str = sc.next();
			for (int i = 0; i < n; i++) {
				if (str.charAt(i) == '(')
					a++;
				if (str.charAt(i) == '[')
					b++;
				if (str.charAt(i) == '{')
					c++;
				if (str.charAt(i) == '<')
					d++;
				if (str.charAt(i) == ')')
					a--;
				if (str.charAt(i) == ']')
					b--;
				if (str.charAt(i) == '}')
					c--;
				if (str.charAt(i) == '>')
					d--;
			}
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}
}
