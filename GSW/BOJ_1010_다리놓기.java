import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_다리 {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			double res=0;
			double num =1;
			double R = Integer.parseInt(st.nextToken());
			double N = Integer.parseInt(st.nextToken());
			for(double j = N;j>N-R;j--) {
				num *= j;
			}
			
			double num2 =1;
			for(double j=R;j>0;j--) {
				num2*=j;
			}
			res = num/num2;
			System.out.printf("%.0f\n",res);
		}
	}
}
	
	
