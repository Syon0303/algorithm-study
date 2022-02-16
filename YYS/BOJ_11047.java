import java.util.Scanner;

public class Main {
	static int N,arr[];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] coin = new int[N];
		while(N-->0) {
			coin[N] = sc.nextInt();
		}
		int share = 0,remain=K,idx = 0; // 몫/ 나머지, 인덱스
		
		while(remain!=0) {
			share += remain/coin[idx];
			remain %= coin[idx];
			idx++;
		}
		
		System.out.println(share);
}
}