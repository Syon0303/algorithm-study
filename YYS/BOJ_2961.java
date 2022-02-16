import java.util.*;

public class Main {
	static int min = 1000000000;
	static int N, arr[][];
	static void dfs(int idx, int cnt, int A, int B) {
		if(idx==N) {

			if(cnt>0) min = Math.min(min,Math.abs(A-B));
			// 음식을 한번이라도 집었을 때 최소값 갱신
			
			return; // N에 도달하면 무조건 끝냄
		}
		
		dfs(idx+1,cnt+1,A*arr[idx][0],B+arr[idx][1]);
		dfs(idx+1, cnt, A, B);
	}
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt(); //요리의 개수
	arr = new int[N][2];
	for(int i=0; i<N; i++) {
		arr[i][0] = sc.nextInt(); // 신맛
		arr[i][1] = sc.nextInt(); // 쓴맛
	}
	
	dfs(0,0,1,0); // 인덱스, 선택한 개수,신맛, 쓴맛
	
	System.out.println(min);
}
}