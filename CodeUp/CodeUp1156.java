import java.util.Scanner;

public class CodeUp1156 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
//		//3항연산자 이용
//		String msg = (num % 2 == 1) ? "odd" : "even";
//		System.out.println(msg);
		
//		//if~else문 이용
//		if( num % 2 == 1 )
//			System.out.println("odd");
//		else
//			System.out.println("even");
		
		//switch문 이용
		switch( num % 2 ) {
		case 0:
			System.out.println("even");
			break;
		case 1:
			System.out.println("odd");
			break;
		}
	}
}