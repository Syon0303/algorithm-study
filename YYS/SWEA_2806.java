import java.util.*;

public class Solution {
	static int N,cnt,arr[];
	static boolean[] v;
	
	static boolean isPossible(int row, int col) { //대각 검사
		for(int i=0; i<row; i++) {
			if(Math.abs(arr[i]-col)==Math.abs(i-row)) { //이전 원소들과 대각 위치에 있다면
				return false;
			}
		}
		return true;
	}
	
	static void dfs(int depth) { // depth는 곧 행
		if(depth==N) {
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) { // 열 선택
			if(!v[i] && isPossible(depth,i)) {
				v[i] = true;
				arr[depth] = i;
				dfs(depth+1);
				v[i] = false;
			}
		}
	}
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t<=T; t++) {
        	N = sc.nextInt();
        	cnt = 0;
        
        	arr = new int[N]; // 놓는 곳을 기록할 배열
        	v = new boolean[N]; // 방문체크 배열
        	dfs(0);
        	
        	System.out.println("#"+t+" "+cnt);
        }
	}
}