import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		//Scanner sc = new Scanner(System.in);
		String [] str = br.readLine().split("");
	
		int N = str.length;
		int C=0;
		int R=0;
		for(int i=1;i<N;i++) {
			if(N%i==0) {
				if(i>N/i) break;
				R=N/i;
				C=i;
			}
		}
		String [][] map = new String[C][R];
		for(int i=0;i<R;i++) {
			for(int j=0;j<C;j++) {
				map[j][i] = str[C*i+j];
			}
		}
		for(int i=0;i<C;i++) {
			for(int j=0;j<R;j++) {
				System.out.print(map[i][j]);
			}
		}
		System.out.println();
		
		
	}

}