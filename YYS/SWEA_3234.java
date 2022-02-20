package workplace;
import java.util.*;

public class Solution {
	static int cnt;
	// 처음에 static을 많이 사용했는데 매개변수로 집어넣고 비트마스킹을 해서 시간단축을 했습니다.
	static void dfs(int v, int left, int right, int N,int[] arr) {
		
		if(v+1==1<<N) { // v는 N-1까지 체킹되어있는데 +1을 해서 2의 N승으로 바꿉니다
			cnt++;
			return;
		}
		
		for(int i=0; i<N; i++) {
			if((v&(1<<i)) == 0) { //왼쪽에 넣는 것은 조건없이 넣을 수 있음
				v |= 1<<i;
				dfs(v,left+arr[i],right,N,arr);
				
				if(left>=right+arr[i]) {
					dfs(v,left,right+arr[i],N,arr);
				}
				v  &= ~(1<<i);
			}
		}
	}
public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1; t<=T; t++) {
        	int N = sc.nextInt();
        	int[] arr = new int[N];
        	cnt = 0;
        	for(int i=0; i<N; i++) {
        		arr[i] = sc.nextInt();
        	}
        	
        	dfs(0,0,0,N,arr);
        	System.out.println("#"+t+" "+cnt);
        }
	}
}