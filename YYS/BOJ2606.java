import java.util.*;

public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Queue<Integer> Q = new LinkedList<Integer>();
    int N = sc.nextInt();
    ArrayList[] arr = new ArrayList[N+1];
    boolean[] visited = new boolean[N+1]; //방문체크 배열
    
    for(int i=0; i<=N; i++) {
    	arr[i] = new ArrayList<Integer>();
    }

    int input = sc.nextInt();
    int cnt = 0;
    while(input-->0) {
    	int a = sc.nextInt();
    	int b = sc.nextInt();
    	arr[a].add(b); // 무향 그래프라서 처음에 생각지 못한 부분
    	arr[b].add(a); // 양쪽에 자식으로 추가 
    }
    
    Q.offer(1); //노드를 집어넣습니다
    visited[1] = true;
    while(!Q.isEmpty()) {
    	int now = Q.poll(); //원소를 빼서
    	for(int i=0 ; i<arr[now].size(); i++) { //자식들을 큐에 다시 넣습니다
    		int child = (int) arr[now].get(i);
    		if(!visited[child]) {
    			visited[child] = true; //방문 체크해주고
    			Q.offer((Integer) child);
    			cnt++; // 전파 상황이므로 카운트
    		}
    	}
    }
    
    System.out.println(cnt);
    
}
}