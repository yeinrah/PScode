import java.util.Scanner;

public class boj1158 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		boolean[] arr = new boolean[n + 1]; // default : false
		int cnt = 0; // k번째를 셀 카운터
		int a = 0; // 라운드 수를 셀 카운터
		int i = 0; // n번만 출력하기 위한 카운터
		String res = "";
		while (true) {
			a++;
			if (arr[a % n] == false) // 이미 빠진 수가 아니라면 cnt++
				cnt++;
			if (cnt == k) { // k번째마다
				if (a <= n) {
					i++;
					if (i == n) { // 마지막 숫자면 ", " 없이 그대로 추가하고 while문 종료
						res += a;
						break;
					}
					res += a + ", "; // 라운드 수가 n보다 작을 때는 라운드 수 = 배열 내 숫자이므로 그대로 추가
					arr[a % n] = true; // 빠진 숫자라고 표시
				}
				else if (a % n == 0) {
					i++;
					if (i == n) {
						res += n;
						break;
					}
					res += n + ", "; // a % n이 0이면 배열내 마지막 숫자이므로 n 추가
					arr[a % n] = true;
				}
				else {
					i++;
					if (i == n) {
						res += a % n;
						break;
					}
					res += (a % n) + ", ";
					arr[a % n] = true;
				}
				cnt = 0;
			}
		}
		System.out.print("<" + res + ">");
	}
}
