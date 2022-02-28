import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.Queue;

public class BOJ_2810_컵홀더_브론즈1 {
	
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		sc.nextLine();
		char[] arr = sc.nextLine().toCharArray();
		int cnt =1;
		for(int i=0;i<N;i++) {
			if(arr[i]=='L') i++;
			cnt++;
			
		}
		cnt = Math.min(cnt,N);
		System.out.println(cnt);
		
		
	
	}
}