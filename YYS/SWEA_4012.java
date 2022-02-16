import java.util.*;

public class Solution {
    static int N, MIN;
    static int arr[][];
    static boolean[] v; // 방문체크
    
    static void calS() {
    	int A = 0;
    	int B = 0;
    	
    	for(int i=0; i<N; i++) {
    		for(int j=0; j<N; j++) {
    			if(v[i]!=v[j] || i==j) continue;  // 서로 다른 팀이거나 같은 번호일 때 넘어가기
    			
    			if(v[i]) { //동일한 팀이고 true면 A팀
    				A += arr[i][j];
    			}else if(!v[i]) {
    				B += arr[i][j];
    			}
    		}
    	}
    	MIN = Math.min(MIN, Math.abs(A-B));
    }
    
    static void dfs(int depth, int cnt) {
    	if(cnt>N/2) { //절반 이상 뽑으면 탈락
    		return;
    	} else if(cnt==N/2) {
    		
    			calS();
    		
    		return;
    		
    	} else if(depth==N) {
    		return;
    	}
    	
    	
    	v[depth] = true;
    	dfs(depth+1,cnt+1);
    	v[depth] = false;
    	dfs(depth+1, cnt);
    }
public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        for(int t=1; t<=T; t++) {
        	MIN = Integer.MAX_VALUE;
	        N = sc.nextInt(); // 음식의 개수
	        v = new boolean[N];
	        arr = new int[N][N]; // 시너지를 저장할 배열
	        
	        for(int i=0; i<N ; i++) { //시너지 입력 넣어주기
	        	for(int j=0; j<N; j++) {
	        		arr[i][j]= sc.nextInt();
	        	}
	        }
	        
	        dfs(0,0);
	        
	        System.out.println("#"+t+" "+MIN);
        }
	}
}