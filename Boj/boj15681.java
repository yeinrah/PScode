import java.util.ArrayList;
import java.util.Scanner;

// Scanner + System.out.println : 메모리 초과
// Scanner + StringBuilder : 273348kb / 1316ms
// BufferedReader + System.out.println : 123804kb / 2316ms
// BufferedReader + StringBuilder : 102452kb / 844ms
public class boj15681 {
	static ArrayList<Integer>[] list, tree;
	static int[] parent, size;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt(); // 정점의 수 n
		int r = sc.nextInt(); // 루트의 번호 r
		int q = sc.nextInt(); // 쿼리의 수 q

		parent = new int[n + 1];
		size = new int[n + 1];
		list = new ArrayList[n + 1];
		tree = new ArrayList[n + 1];

		// 인접리스트 구현을 위해 배열의 각 칸을 ArrayList로 초기화해주기
		for (int i = 0; i < list.length; i++) {
			list[i] = new ArrayList<>();
			tree[i] = new ArrayList<>();
		}

		// 간선 정보 담기
		for (int i = 0; i < n - 1; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			list[a].add(b);
			list[b].add(a);
		}

		// -1은 부모가 없다는 뜻, 즉 루트 노드라는 뜻
		makeTree(r, -1);
		countSubtreeNodes(r);
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < q; i++) {
			int u = sc.nextInt(); // 정점 u를 루트로 하는 서브트리에 속한 정점의 수를 출력해야 한다
			sb.append(size[u]).append("\n");
		}
		System.out.println(sb);
		sc.close();
	}

	private static void makeTree(int curr, int parentCnt) {
		for (int node : list[curr]) {
			if (node != parentCnt) {
				tree[curr].add(node);
				parent[node] = curr;
				makeTree(node, curr);
			}
		}
	}

	private static void countSubtreeNodes(int curr) {
		size[curr] = 1;

		for (int node : tree[curr]) {
			countSubtreeNodes(node);
			size[curr] += size[node];
		}
	}
}
