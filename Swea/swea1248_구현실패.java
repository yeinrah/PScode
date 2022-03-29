package a220329;

import java.util.Scanner;

// 아이디어까지는 떠올렸으나 구현 실패
public class swea1248_구현실패 {
	static int v, e, a, b;
	static int[] parent, child, api, bpi;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for (int tc = 1; tc <= t; tc++) {
			// 총 노드 수 v
			v = sc.nextInt();
			// 총 간선 수 e
			e = sc.nextInt();
			// 공통 조상을 찾으려는 대상 노드 번호 a
			a = sc.nextInt();
			// 공통 조상을 찾으려는 대상 노드 번호 b
			b = sc.nextInt();

			// 간선 정보를 담을 배열
			parent = new int[e];
			child = new int[e];
			for (int i = 0; i < e; i++) {
				parent[i] = sc.nextInt();
				child[i] = sc.nextInt();
			}

			// 공통 조상 노드 번호
			int anc = 0;
			// 서브 트리 크기
			int size = 0;

			// a 조상 배열 (api : a parent index)
			api = new int[v];
			// b 조상 배열 (bpi : b parent index)
			bpi = new int[v];
			
			findParentA(a, 0);
			findParentB(b, 0);
			
			for (int i = 0; i < v; i++) {
				for (int j = 0; j < v; j++) {
					if (api[i] == bpi[j]) {
						anc = api[i];
						break;
					}
				}
			}
			
			// size count 구현
			
			System.out.println("#" + tc + " " + anc + " " + size);
		}
		sc.close();
	}
	
	public static void findParentA(int a, int index) {
	
		if (index >= v)
			return;

		for (int i = 0; i < v; i++) {
			if (child[i] == a) {
				api[index] = parent[i];
				break;
			}
		}
		findParentA(api[index], index + 1);
	}
	
	public static void findParentB(int b, int index) {
		
		if (index >= v)
			return;

		for (int i = 0; i < v; i++) {
			if (child[i] == b) {
				bpi[index] = parent[i];
				break;
			}
		}
		findParentB(bpi[index], index + 1);
	}
}
