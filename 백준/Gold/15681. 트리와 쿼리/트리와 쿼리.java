import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {
	static ArrayList<Integer>[] list, tree;
	static int[] parent, size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), " ");

		int n = Integer.parseInt(st.nextToken()); // 정점의 수 n
		int r = Integer.parseInt(st.nextToken()); // 루트의 번호 r
		int q = Integer.parseInt(st.nextToken()); // 쿼리의 수 q

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
			st = new StringTokenizer(br.readLine(), " ");
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			list[a].add(b);
			list[b].add(a);
		}

		// -1은 부모가 없다는 뜻, 즉 루트 노드라는 뜻
		makeTree(r, -1);
		countSubtreeNodes(r);
		
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < q; i++) {
			// 정점 u를 루트로 하는 서브트리에 속한 정점의 수를 출력해야 한다
			int u = Integer.parseInt(br.readLine());
			sb.append(size[u]).append("\n");
		}
		System.out.println(sb);
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
