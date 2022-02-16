import java.util.Scanner;

public class Main {
	static int N,arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		int mod5 = N/5; //5로 나눈 몫 기록
		
		int mod3 = (N%5)/3; // 나눈 나머지에서 3으로 나눈다음 몫을 배분
		int remain = (N%5)%3; // 알짜 나머지
		
		while(remain!=0) {
			mod5 --;
			remain += 5;
			mod3 += remain/3;
			remain = remain%3;
		}
		System.out.println(mod5<0?-1:mod5+mod3);	
}
}