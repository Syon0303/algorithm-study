import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2606 {
    static int[][] graph;   
    static boolean[] visit;
    static int N, X = 0;
    
    public static void dfs(int i) {
        visit[i] = true;
        
        for(int j = 1; j < N+1; j++) {
            if(graph[i][j] == 1 && visit[j] == false) {
                X++;
                dfs(j);
            }
        }
    }
    
	public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    N = Integer.parseInt(br.readLine());        // 정점 수
	    int M = Integer.parseInt(br.readLine());    // 간선 수
	    
	    // 인접행렬 생성
	    StringTokenizer st;
	    graph = new int[N+1][N+1];
	    for(int i = 0; i < M; i++) {
	        st = new StringTokenizer(br.readLine());
	        int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a][b] = 1;
            graph[b][a] = 1;
	    }
	    
	    // visit 배열
	    visit = new boolean[N+1];
	    
	    // dfs
	    dfs(1); // target = 1
	    
	    System.out.println(X);
	}
}
