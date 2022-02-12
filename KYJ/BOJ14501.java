import java.io.IOException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14501 {
    public static int N, X = 0;
    public static int[][] Arr;
  
    public static void main(String[] args) throws IOException {
	    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	    StringTokenizer st;
	    
	    N = Integer.parseInt(br.readLine());
	    Arr = new int[N][2];
	    for(int i = 0; i < N; i++) {
	        st = new StringTokenizer(br.readLine());
	        Arr[i][0] = Integer.parseInt(st.nextToken());
	        Arr[i][1] = Integer.parseInt(st.nextToken());
	    }
	  
	    work(0,0);
	    
	    System.out.println(X);
	}
	
	public static void work(int day, int sum) {
	    if(day > N) return;                         // day가 N보다 크면 그냥 return
	    
	    X = Math.max(sum, X);                       // day가 N보다 작으면 X 계산 후
	   
	    for(int i = day; i < N; i++){
          work(i + Arr[i][0], sum + Arr[i][1]);   // 하나하나 다 해봄
      }
	}
}
