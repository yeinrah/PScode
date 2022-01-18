import java.util.Scanner;

public class CodeUp1259 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int res = 0;
		
		for (int i = 0; 2 * i <= n; i++)
			res += 2 * i;
		System.out.println(res);
	}
}
