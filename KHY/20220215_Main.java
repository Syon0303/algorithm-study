import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.Scanner;

public class Main {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[] cost = new int[N];
		for (int i = 0; i < cost.length; i++) {
			cost[i] = sc.nextInt();
		}
		int cnt = cost.length-1;
		int res = 0;
		while(true) {
			if(K == 0) {
				break;
			}
			if(cost[cnt] <= K) {
				K = K-cost[cnt];
				res++;
			}else {
				cnt--;
			}
		}
		System.out.println(res);
	}
}