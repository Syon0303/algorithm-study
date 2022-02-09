import java.util.*;

// ť�� �ε����ϰ� �켱������ ���� ����������� ���� ��ü
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
    	int N = sc.nextInt(); //�� ����
    	int M = sc.nextInt(); //�ñ��� �ε��� ��ȣ
    	int cnt = 0;
    	int counting[] = new int[10]; // ī���� �迭�� ����� �켱 ������ ��� ���
    	
    	for(int i=0; i<N;i++) {
    		int now = sc.nextInt();
    		queue.offer(new Data(i,now));
    		counting[now]++; //ī���� �迭���� ���
    	}
    	
    	for(int i=9; i>0;i--) {
    		for(int j=0; j<counting[i]; j++) { //�ٸ� ť���ٴ� ī���� �迭�� ������
    			queue2.offer(i);   // �켱�������� ������������ ����ֱ�
    		}
    	}
    	while(true) { //�켱���� ť�� 443332211 �̷������� �������� = �ִ밪 �񱳰���
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