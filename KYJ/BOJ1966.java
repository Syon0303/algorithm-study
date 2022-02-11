import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1966 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());
		for(int tc = 0; tc < T; tc++) {
			int X = 0;	// 출력 횟수
			st = new StringTokenizer(br.readLine(), " ");
            int N = Integer.parseInt(st.nextToken());		// 문서 수
            int targetW = Integer.parseInt(st.nextToken());	// 타겟 문서 위치
			
			st = new StringTokenizer(br.readLine(), " ");
			Queue<Integer> queue = new LinkedList<>();		// 문서들 담을 Queue
			Integer[] importanceArr = new Integer[N];		// 문서들의 중요도 담을 array
            for(int i = 0; i < N; i++) {
            	int temp = Integer.parseInt(st.nextToken());
            	queue.add(temp);
            	importanceArr[i] = temp;
            }
            Arrays.sort(importanceArr, Collections.reverseOrder()); // 중요한 순서(출력 순서)로 정렬
			
            while(!queue.isEmpty()) { // queue가 텅 비었을 때까지
            	int current = queue.poll();
            	if(current == importanceArr[X]) { // 가장 앞에 있는 문서가 이번에 출력할 문서라면
            		X++; // 출력 횟수 + 1
            		if(targetW == 0) { // 그 문서가 target이라면
            			break;
            		} else targetW--;
            	} else { // 중요도가 낮은 문서라면
            		queue.add(current); // 맨 뒤에 넣기 
            		targetW = (targetW == 0) ? queue.size() - 1 : targetW - 1; // 맨 뒤에 넣은 문서가 target이라면 타겟 위치 == queue.size - 1 아니면 한칸 앞으로
            	}
            }
            System.out.println(X);
		}
	}
}
