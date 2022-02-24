import java.io.*;
import java.util.*;
public class Main {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		int V = Integer.parseInt(st.nextToken());
		
		ArrayList[] arr = new ArrayList[V+1]; // ArrayList 로 필요한 연결관계만 저장: 방향 그래프
		
		for (int i = 0; i <= V; i++) {
			arr[i] = new ArrayList<int[]>();
		}
		
		int E = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(br.readLine());
	
		boolean[] v = new boolean[V+1]; //방문 체크 배열
		
		int[] minEdge = new int[V+1]; // 출발선을 기준으로 최소 경로 저장
		
		Arrays.fill(minEdge, Integer.MAX_VALUE); // 모두 MAX 값으로 채우기
		
		//Dijkstra
		while(E-->0) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			arr[a].add(new int[] {w,b}); // 방향 그래프이므로 단방향으로 한 쪽에만 넣어줍니다
		}
		minEdge[K] = 0; // 출발값의 최소 경로를 0으로 만들어 인식하도록 만들어주고

		int current = K; // 현재 번호를 K로 저장합니다
		
		for(int k=0; k<V; k++) {
			
			int min = Integer.MAX_VALUE;
			int minIdx = -1;
			
			for(int i=0; i<=V; i++) { // 방문하지 않은 노드 중 출발선으로부터 최소 경로를 가진 노드를 골라냅니다
				if(!v[i] && min > minEdge[i]) {
					min = minEdge[i];
					minIdx = i;
				}
			}
			if(minIdx==-1) break; // 만약 인덱스가 -1로 나왔다면 나머지는 모두 MAX_VALUE이므로 종료해줍니다
			
			v[minIdx] = true; // 인덱스가 존재한다면 방문체크
			
			current = minIdx; // 찾아낸 노드로 이동합니다

			for(int i=0; i<arr[minIdx].size(); i++) {
				int[] tmp = (int[]) arr[minIdx].get(i); // 새로 찾은 노드를 기준으로
				
				if(!v[tmp[1]] && minEdge[current] + tmp[0] < minEdge[tmp[1]]) {
					// 출발 -> 현재 노드 -> 노드 I 의 경로와 출발 -> 노드 I 의 크기를 비교해 더 작은 값으로 갱신해줍니다.
					minEdge[tmp[1]] = minEdge[current] + tmp[0];
				}
			}
		}
		for(int i=1; i<=V; i++) { // 출력부분입니다. 무한으로 값이 남았다면 INF로 출력합니다
			if(minEdge[i]!=Integer.MAX_VALUE){
				sb.append(minEdge[i]+"\n");
			}else {
				sb.append("INF\n");
			}
		}
		System.out.println(sb.toString());
	}

}