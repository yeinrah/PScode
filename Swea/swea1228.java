import java.util.LinkedList;
import java.util.Scanner;

public class swea1228 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			int n = sc.nextInt();
			LinkedList<String> original = new LinkedList<>();
			for (int i = 0; i < n; i++)
				original.offer(sc.next());
			int m = sc.nextInt();
			for (int i = 0; i < m; i++) {
				sc.next();
				int x = sc.nextInt();
				int y = sc.nextInt();
				for (int j = 0; j < y; j++)
					original.add(x + j, sc.next());
			}
			System.out.print("#" + tc + " ");
			for (int i = 1; i <= 10; i++)
				System.out.print(original.poll() + " ");
			System.out.println();
		}
		sc.close();
	}
}
