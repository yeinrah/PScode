import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea3499_3 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			int n = sc.nextInt();
			StringBuilder sb = new StringBuilder();
			Queue<String> first = new LinkedList<String>();
			Queue<String> last = new LinkedList<String>();
			for (int i = 1; i <= ((n + n % 2) / 2); i++)
				first.offer(sc.next());
			for (int i = ((n + n % 2) / 2) + 1; i <= n; i++)
				last.offer(sc.next());
			for (int i = 1; i <= n ; i++) {
				if (i % 2 == 1)
					sb.append(first.poll() + " ");
				else
					sb.append(last.poll() + " ");
			}
			System.out.println("#" + tc + " " + sb);
		}
	}
}
