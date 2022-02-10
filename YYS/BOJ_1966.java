import java.util.*;

// 큐에 인덱스하고 우선순위를 같이 집어넣으려고 만든 객체
class Data{
	int idx;
	int prior;
	Data(int idx,int prior){
		this.idx = idx;
		this.prior = prior;
	}
}
public class Main {
    public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    Queue<Data> queue = new LinkedList<Data>();
    Queue<Integer> queue2 = new LinkedList<Integer>();
    int t = sc.nextInt();
    
    while(t-->0) {
    	int N = sc.nextInt(); //총 개수
    	int M = sc.nextInt(); //궁금한 인덱스 번호
    	int cnt = 0;
    	int counting[] = new int[10]; // 카운팅 배열을 사용해 우선 순위를 모두 기록
    	
    	for(int i=0; i<N;i++) {
    		int now = sc.nextInt();
    		queue.offer(new Data(i,now));
    		counting[now]++; //카운팅 배열에도 기록
    	}
    	
    	for(int i=9; i>0;i--) {
    		for(int j=0; j<counting[i]; j++) { //다른 큐에다는 카운팅 배열에 저장한
    			queue2.offer(i);   // 우선순위들을 내림차순으로 집어넣기
    		}
    	}
    	while(true) { //우선순위 큐는 443332211 이런식으로 내림차순 = 최대값 비교가능
    		if(queue.peek().prior==queue2.peek()) {
        		cnt++;
    			if(queue.poll().idx==M) {
    				break;
    			}else {
    				queue2.poll();
    			}
    		}else {
    			queue.offer(queue.poll());
    		}
    	}
    	System.out.println(cnt);
    	queue.clear();
    	queue2.clear();
    }
}
}