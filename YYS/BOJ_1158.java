import java.util.*;

public class Main {
    public static void main(String[] args) {
    Queue<Integer> Q = new LinkedList<Integer>();
    StringBuilder sb = new StringBuilder();
    Scanner sc = new Scanner(System.in);
    sb.append("<");
    int N = sc.nextInt();
    int K = sc.nextInt();
    
    for(int i=1; i<=N; i++) {
    	Q.offer(i);
    }
    
    int idx = 0;
    
    while(!Q.isEmpty()) {
    	idx ++;
    	
    	if(idx%K==0) {
    		sb.append(Q.poll()+", ");
    	}else {
    		Q.offer(Q.poll());
    	}
    }
    sb.setLength(sb.length()-2);
    sb.append(">");
    System.out.println(sb.toString());
}
}