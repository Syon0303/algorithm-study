import java.util.*;
public class Solution {
	static int N, arr[][], MIN;
	
	//비트마스킹으로 체크하면서 그 동안의 합들을 sum에 저장하고 넘겼습니다.
	static void dfs(int row, int col, int sum, int v) {
		if(sum>=MIN) return;
		else if(((v+1)&1<<N)!=0) {
			MIN = Math.min(sum+Math.abs(row-arr[1][0])+Math.abs(col-arr[1][1]),MIN);
			return;
		}
		// 1번째 인덱스에는 도착지점이 들어있으므로 2부터 ~ N+1까지 탐색합니다.
		for(int i=2; i<N+2; i++) {
			if(((v&(1<<i-2)) == 0)){
				v |= 1<<i-2;
				dfs(arr[i][0],arr[i][1],sum+Math.abs(row-arr[i][0])+Math.abs(col-arr[i][1]),v);
				v &= ~(1<<i-2);
			}
		}
	}
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
        for(int t = 1; t<=T; t++) {
        	N = sc.nextInt();
        	arr = new int[N+2][2];
        	int v = 0;
        	MIN = 1000000000;
        	
            //0부터 N+1까지 넣어줍니다
        	for(int i=0; i<N+2; i++) {
        		arr[i][0] = sc.nextInt();
        		arr[i][1] = sc.nextInt();
        	}
        	
        	dfs(arr[0][0],arr[0][1],0,0);
        	System.out.println("#"+t+" "+MIN);
        }
	}
}