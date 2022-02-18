import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int sum = 0;
		for(int i=1; i<=Math.sqrt(N); i++) { //N의 루트값을 넘으면 카운트가 의미 없어집니다
			for(int j=i; j*i<=N; j++) { //면적 이하까지 더해줍니다
				sum += 1;
			}
		}
		System.out.println(sum);
	}
}