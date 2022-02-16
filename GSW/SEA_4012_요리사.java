import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;
public class Solution {
	static int [][] s;
	static int N;
	static boolean check[];
	static int min;
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		//System.setIn(new FileInputStream("input.txt"));
		Scanner sc = new Scanner(System.in);
		int testCase = sc.nextInt();

		for(int t=1;t<=testCase;t++) {
			////////////////////////////
			N = sc.nextInt();
			s = new int[N][N];
			check = new boolean[N];
			min = Integer.MAX_VALUE;
			for(int i=0;i<N;i++) {
				for(int j=0;j<N;j++) {
					s[i][j]=sc.nextInt();
				}
			}
			
			comb(0,0);
			System.out.printf("#%d %d\n",t,min);
			////////////////////////
		}
	}
	
	public static void comb(int cnt, int start) {
		if(cnt==N/2) {
			int sum1=0;
			int sum2=0;
			for(int i=0;i<N;i++) {
				if(check[i]) {
					for(int j=i+1;j<N;j++) {
						if(check[j]) {
							sum1+=s[i][j];
							sum1+=s[j][i];
						}
					}
				}
				else if(!check[i]) {
					for(int j=i+1;j<N;j++) {
						if(!check[j]) {
							sum2+=s[i][j];
							sum2+=s[j][i];
						}
					}
				}
			}
			min = Math.min(min,Math.abs(sum1-sum2));
			return;
		}
		for(int i=start;i<N;i++) {
			check[i] = true;
			comb(cnt+1,i+1);
			check[i] = false;
		}
	}
}
