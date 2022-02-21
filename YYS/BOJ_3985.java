import java.util.*;

public class Main {
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int L = sc.nextInt();
		boolean[] cake = new boolean[L+1];
		int N = sc.nextInt();
		
		int max1 = 0; // 최대값으로 예상한 방청객
		int answer1 = 0;
		int max2 = 0; // 실제로 많이 받은 방청객
		int answer2 = 0;
		
		for(int i=1; i<=N; i++) {
			int start = sc.nextInt();
			int last = sc.nextInt();
			
			if(max1 < last-start+1) {
				max1 = last-start+1;
				answer1 = i;
			}
			
			int cnt = 0;
			
			for(int j=start; j<=last; j++) {	
				if(!cake[j]) { //한 번도 선택되지 않았던 케이크조각인 경우
					cake[j] = true;
					cnt++;
				}
			}
			
			if(max2 < cnt) {
				max2 = cnt;
				answer2 = i;
			}
		}
		
		
		System.out.println(answer1);
		System.out.println(answer2);
	}
}