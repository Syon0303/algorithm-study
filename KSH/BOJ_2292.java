import java.util.Scanner;
// 벌집, 브론즈 2, 10분
public class BOJ_2292 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int cnt = 1;
		int temp = 1;
		
		while(n>temp) {
			temp = temp + cnt*6;
			cnt++;
		} System.out.println(cnt);
	}
}
