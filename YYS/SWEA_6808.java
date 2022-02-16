import java.util.*;
import java.io.*;
 
public class Solution {
	static boolean[] visit;
	static int[] answer = new int[9];  //인영이 덱을 경우마다 기록하는 곳
	static int[] G,I;
	static int lose,win;
	
	static void dfs(int depth) {
		if(depth==-1) {
			int sumG = 0;
			int sumI = 0;
			
			for(int i=0; i<9; i++) { // 9장의 카드를 선별했다면 점수를 계산해주고
				if(answer[i]>G[i]) {
					sumI += answer[i]+G[i];
				}else if(answer[i]<G[i]) {
					sumG += answer[i]+G[i];
				}
			}
			
			if(sumI > sumG) { //승리했는지 패배했는지 기록합니다
				lose++;
			}else if(sumI < sumG) {
				win++;
			}
			return;
		}
		
		for(int i=0; i<9; i++) {
			if(!visit[i]) { //방문하지 않았을 때
				visit[i] = true;
				answer[depth] = I[i];
				dfs(depth-1);
				visit[i] = false;
			}
		}
	}
    public static void main(String[] args) throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    int T = Integer.parseInt(br.readLine());
    G = new int[9]; // 규영이 덱 
    I = new int[9]; // 인영이 덱
    
    for(int t = 1; t<=T; t++) {
    	st = new StringTokenizer(br.readLine());
    	
    	boolean[] count = new boolean[19]; // 카운트
    	
    	for(int i=0; i<9; i++) { //규영이 덱 만들기
    		G[i] = Integer.parseInt(st.nextToken());
    		count[G[i]] = true;
    	}
    	int idx = 0;
    	for(int i=1; i<19; i++) { // 인영이 덱 완성
    		if(!count[i]) {
    			I[idx] = i;
    			idx++;
    		}
    	}
    	
    	lose = 0; //패배 승리 경우의 수 카운트
    	win = 0;
    	
    	visit = new boolean[9];
    	
    	dfs(8);
    	System.out.println("#"+t+" "+win+" "+lose);
    }
    	
}
}