import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int min = M; //차이의 최소값을 기록
		int sum = 0;
		int[] map = new int[N];
		for(int i=0; i<N; i++) {
			map[i] = sc.nextInt();
		}
		for(int i= 0; i<N; i++) {
			for(int j=i+1; j<N; j++) {
				for(int k=j+1; k<N; k++) {
					int now = M-(map[i]+map[j]+map[k]);
					
					if(min<=now || now<0) continue; //가지치기
					
					sum = map[i]+map[j]+map[k];
					min = now;
					
				}
			}
		}
		System.out.println(sum);
	}
}