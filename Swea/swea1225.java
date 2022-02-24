import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class swea1225 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int tc = 1; tc <= 10; tc++) {
			sc.nextInt();
			Queue<Integer> q = new LinkedList<>();
			for (int i = 0; i < 8; i++)
				q.offer(sc.nextInt());
			int cnt = 1;
			while (q.peek() > cnt) {
				q.offer(q.poll() - cnt);
				cnt++;
				if (cnt > 5)
					cnt = 1;
			}
			q.offer(0);
			q.poll();
			System.out.print("#" + tc + " ");
			for (int i = 0; i < 8; i++)
				System.out.print(q.poll() + " ");
			System.out.println();
		}
		sc.close();
	}
}
