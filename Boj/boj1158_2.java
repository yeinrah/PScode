import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class boj1158_2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		String res = "";
		Queue<Integer> q = new LinkedList<Integer>();
		for (int i = 1; i <= n; i++)
			q.offer(i);
		int cnt = 1;
		while (q.size() != 1) {
			if (cnt < k) {
				q.offer(q.poll());
				cnt++;
			}
			if (cnt == k) {
				res += q.poll() + ", ";
				cnt = 1;
			}
		}
		res += q.poll();
		System.out.println("<" + res + ">");
	}
}
