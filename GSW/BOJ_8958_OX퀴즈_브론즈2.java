import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class BOJ_8958_OX퀴즈_브론즈2 {

	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		for(int t=0;t<N;t++) {
			char [] arr = sc.nextLine().toCharArray();
			int sum=0;
			int temp=0;
			for(int i=0;i<arr.length;i++) {
				if(arr[i]=='O') {
					temp++;
					sum+=temp;
				}
				else {
					temp=0;
				}
			}
			System.out.println(sum);
		}
		
		
	}

}