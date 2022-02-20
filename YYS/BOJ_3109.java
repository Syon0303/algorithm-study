import java.util.*;

public class Main {
	static boolean[][] v;
	static int R,C,SUM=0;
	static boolean found = false;
    //현재 루트에서 빵집을 도달하지 못한다면 다른 곳에서 이 루트로 들어오더라도
    //끝 점에 도달하지 못해 백트래킹으로 풀이하지 않습니다.
    // == 단방향 이동 
	static void dfs(int row, int col) {
		if(found) return; // 처음 백트래킹 시도하다 남은 변수
		if(col == C) { // 끝 점 도달 시
			SUM++; //카운트
			found =true; //
			return;
		}
		if(col>=0 && row>=0 && row<R && !v[row][col]) { // 순서 주의 배열 검색은 뒤로
			v[row][col] = true; //방문체크하지만 해제하지 않습니다.
			dfs(row-1,col+1); //오른쪽위
			dfs(row,col+1); //오른쪽
			dfs(row+1,col+1); //오른쪽 아래
			if(found) return;
		}
	}
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		v = new boolean[R][C];
		
		for(int i=0; i<R; i++) {
			String s = sc.next();
			for(int j=0; j<C; j++) {
				if(s.charAt(j)=='x') {
					v[i][j] = true; //x는 방문체크해줍니다.
				}
			}
		}
		
		for(int i=0; i<R; i++) { //각각 라인에서 시작해 끝으로 도달하게 합니다.
			found = false;
			dfs(i,0);
		}
		System.out.println(SUM);
	}
}