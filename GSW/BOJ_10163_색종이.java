import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_10163_색종이 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
	
		int N = sc.nextInt();
		int map[][] = new int [1001][1001];
		int check[] = new int[N+1];
		for(int i=1;i<=N;i++) {
			int x = sc.nextInt();
			int y = sc.nextInt();
			int width = sc.nextInt();
			int height = sc.nextInt();
			for(int j=y;j<y+height;j++) {
				for(int k=x;k<x+width;k++) {
					map[j][k] = i;
				}
			}
		}
		for(int i=0;i<1001;i++) {
			for(int j=0;j<1001;j++) {
				check[map[i][j]]++;
			}
		}
		for(int i=1; i<=N;i++) {
			System.out.println(check[i]);
		}
		
		System.out.println();
		
		
	}

}