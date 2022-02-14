import java.util.*;

public class Main {
	static int N,S,cnt,arr[];
	
	static void dfs(int idx, int sum, int select) { // i 현재 index
		if(idx==N && sum==S && select!=0) {
			cnt++;
			return;
		}
		if(idx==N) return; // 배열 끝에 도달하면 종료
		
		dfs(idx+1,sum+arr[idx],select+1); //현재 원소를 선택하고 보내기
		dfs(idx+1,sum,select); //현재 원소를 선택하지 않고 보내기
		
	}
	public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	N = sc.nextInt();
	S = sc.nextInt();
	cnt = 0; // 카운트
	arr = new int[N];

	
	//입력 받기
	for(int i = 0; i<N; i++) {
		arr[i] = sc.nextInt();
	}
	
	dfs(0,0,0);
	System.out.println(cnt);
}
}