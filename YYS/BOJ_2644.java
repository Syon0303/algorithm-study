import java.util.*;
public class Main {

    // a의 조상들을 모두 방문하면서 촌수를 기록합니다
    // 다음번에 b가 자신의 조상들을 탐색하면서 만약 a의 촌수가 기록된 조상을 만날경우
    // 현재 재귀의 깊이(촌수)와 더해 정답으로 반환합니다.
	static int[] parents,record;
	static boolean judge = false;
	static int ans=0;
	
	static void dfs(int depth, int a) { //촌수, 자식 a
		record[a] = depth;
		if(a==parents[a]) return;
		
		dfs(depth+1,parents[a]);
	}
	
	static void dfs2(int depth, int b) { //촌수, 자식 a
		if(record[b]!=0) {
			judge = true;
			ans = depth + record[b];
			return;
		}else if(parents[b]==b) {
			return;
		}
		
		dfs2(depth+1,parents[b]);
	}
public static void main(String[] args){
	Scanner sc = new Scanner(System.in);
	int n = sc.nextInt();
	parents = new int[n+1];
	record = new int[n+1]; // 거슬러 올라가면서 기록할 배열
	
	for(int i=0; i<=n; i++) {
		parents[i] = i;
	}
	int a = sc.nextInt();
	int b = sc.nextInt();
	
	int input = sc.nextInt();
	
	while(input-->0) {
		int parent = sc.nextInt();
		int child = sc.nextInt();
		
		parents[child] = parent; // 현재 자식의 부모를 설정
	}
	
	dfs(1,a); //a의 조상들 모두 입력: 자기 자신과 친적이 될 수 있으므로 1부터 시작해 자기 자신도 표시 
	dfs2(0,b); //관계가 있다면
	System.out.println(!judge?-1:ans-1);
}
}