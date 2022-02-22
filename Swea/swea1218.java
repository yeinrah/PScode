import java.util.Scanner;
import java.util.Stack;

public class swea1218 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			int res = 1;
			int a = 0; // (
			int b = 0; // [
			int c = 0; // {
			int d = 0; // <
			String str = sc.next();
			for (int i = 0; i < n; i++) {
				if (str.charAt(i) == '(')
					a++;
				else if (str.charAt(i) == '[')
					b++;
				else if (str.charAt(i) == '{')
					c++;
				else if (str.charAt(i) == '<')
					d++;
				else if (str.charAt(i) == ')')
					a--;
				else if (str.charAt(i) == ']')
					b--;
				else if (str.charAt(i) == '}')
					c--;
				else if (str.charAt(i) == '>')
					d--;
			}
			if (a != 0 || b != 0 || c != 0 || d != 0)
				res = 0;
			System.out.println("#" + tc + " " + res);
		}
		sc.close();
	}
}
