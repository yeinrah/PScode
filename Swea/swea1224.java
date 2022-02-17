import java.util.Scanner;
import java.util.Stack;

public class swea1224 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Character> stack = new Stack<Character>();
		Stack<Integer> calc = new Stack<Integer>();
		for (int tc = 1; tc <= 10; tc++) {
			int l = sc.nextInt();
			String s = sc.next();
			char[] c = s.toCharArray();
			String res = "";
			// 후위 표기법으로 변환
			for (int i = 0; i < l; i++) {
				// 연산자일때
				if (c[i] == '+' || c[i] == '*' || c[i] == '(' || c[i] == ')') {
					// 비어있으면 바로 푸쉬
					if (stack.isEmpty())
						stack.push(c[i]);
					// 안 비어있을때
					else {
						// 곱하기 연산자면
						if (c[i] == '*') {
							// 스택 마지막이 *이 아니면 바로 푸쉬
							if (stack.peek() != '*')
								stack.push(c[i]);
							// 맨위가 *면 아닐때까지 팝하고 푸쉬
							else if (c[i] == '*' && stack.peek() == '*') {
								while (!stack.isEmpty() && stack.peek() == '*')
									res += stack.pop();
								stack.push(c[i]);
							}
						}
						// 더하기 연산자면 
						else if (c[i] == '+') {
							// 괄호일때만 바로 푸쉬
							if (stack.peek() == '(')
								stack.push(c[i]);
							// 그 외에는 다 팝하고 푸쉬
							else {
								while (!stack.isEmpty() && stack.peek() != '(')
									res += stack.pop();
								stack.push(c[i]);
							}
						}
						// 괄호 연산자면
						else {
							// 왼쪽 괄호면 바로 푸쉬
							if (c[i] == '(')
								stack.push(c[i]);
							// 오른쪽 괄호면
							else if (c[i] == ')') {
								// 왼쪽 괄호가 맨위에 나올때까지 팝
								while (!stack.isEmpty() && stack.peek() != '(') {
									res += stack.pop();
								}
								// 왼쪽 괄호면 한 번 팝(수식에 추가는 하지 않음)
								if (!stack.isEmpty() && stack.peek() == '(') {
									stack.pop();
								}
							}
						}
					}
				}
				// 숫자면 res에 바로 추가
				else
					res += c[i];
			}

			// 스택에 남은 연산자 res에 담기
			while (!stack.isEmpty())
				res += stack.pop();

			// 계산
			for (int i = 0; i < res.length(); i++) {
				int num = res.charAt(i) - '0';
				// 숫자면 계산 스택에 바로 푸쉬
				if (0 <= num && num <= 9)
					calc.push(num);
				// 연산자면
				else {
					// 숫자 2개 꺼내서 연산하고 푸쉬
					int n2 = calc.pop();
					int n1 = calc.pop();
					if (res.charAt(i) == '+')
						calc.push(n1 + n2);
					else
						calc.push(n1 * n2);
				}
			}
			System.out.println("#" + tc + " " + calc.pop());
		}
	}
}
